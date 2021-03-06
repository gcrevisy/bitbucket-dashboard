package fr.alteca.dashboard.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.alteca.dashboard.converter.PullRequestJsonConverter;
import fr.alteca.dashboard.dao.PullRequestDao;
import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.model.PullRequest;
import fr.alteca.dashboard.model.json.pullrequest.PullRequestJson;
import fr.alteca.dashboard.model.json.pullrequest.PullRequestsJson;
import fr.alteca.dashboard.utils.UriBuilder;

@Service
public class PullRequestDaoImpl implements PullRequestDao {
    private static Logger logger = LoggerFactory.getLogger(PullRequestDaoImpl.class);

    @Override
    public List<PullRequest> listerPullRequests(Contexte contexte) throws DashboardException {

        List<PullRequest> result = new ArrayList<PullRequest>();
        List<PullRequestJson> resultJson = new ArrayList<PullRequestJson>();

        RestTemplate restTemplate = new RestTemplate();
        PullRequestJsonConverter converter = new PullRequestJsonConverter();

        try {
            ResponseEntity<PullRequestsJson> results = restTemplate.exchange(UriBuilder.buildUri(contexte),
                    HttpMethod.GET, null, PullRequestsJson.class);
            resultJson.addAll(results.getBody().getValues());
        } catch (Exception e) {
            logger.error("Erreur pendant l'acces a l'api REST", e.getMessage());
            throw new DashboardException("Impossible de construire l'URI avec le contexte" + contexte.toString(), e);
        }

        for (PullRequestJson item : resultJson) {
            result.add(converter.convertToModel(item));
        }
        return result;
    }

}