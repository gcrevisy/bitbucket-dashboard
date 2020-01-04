package fr.alteca.dashboard.dao.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import fr.alteca.dashboard.converter.PullRequestJsonConverter;
import fr.alteca.dashboard.dao.PullRequestDao;
import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.model.PullRequest;
import fr.alteca.dashboard.model.json.PullRequestJson;
import fr.alteca.dashboard.model.json.PullRequestsJson;

public class PullRequestDaoImpl implements PullRequestDao {
    private static Logger logger = LoggerFactory.getLogger(PullRequestDaoImpl.class);

    @Override
    public List<PullRequest> listerPullRequests(Contexte contexte) throws DashboardException {

        List<PullRequest> result = new ArrayList<PullRequest>();
        List<PullRequestJson> resultJson = new ArrayList<PullRequestJson>();

        String http = "https://api.bitbucket.org/2.0/repositories/gcrevisy/poc-junit/pullrequests";

        RestTemplate restTemplate = new RestTemplate();
        PullRequestJsonConverter converter = new PullRequestJsonConverter();

        try {
            URI uri = new URI(http);
            ResponseEntity<PullRequestsJson> results = restTemplate.exchange(uri, HttpMethod.GET, null,
                    PullRequestsJson.class);
            resultJson.addAll(results.getBody().getValues());
        } catch (URISyntaxException e) {
            logger.error("Impossible de construire l'URI avec le contexte" + contexte.toString());
            throw new DashboardException("Impossible de construire l'URI avec le contexte" + contexte.toString(), e);
        }

        for (PullRequestJson item : resultJson) {
            result.add(converter.convertToModel(item));
        }
        return result;
    }

}