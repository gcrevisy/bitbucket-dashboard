package fr.alteca.dashboard.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.alteca.dashboard.converter.RepositoryJsonCoverter;
import fr.alteca.dashboard.dao.RepositoryDao;
import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.model.Repository;
import fr.alteca.dashboard.model.json.RepositoriesJson;
import fr.alteca.dashboard.model.json.RepositoryJson;
import fr.alteca.dashboard.utils.ModelValidator;
import fr.alteca.dashboard.utils.UriBuilder;

@Service
public class RepositoryDaoImpl implements RepositoryDao {
    private static Logger logger = LoggerFactory.getLogger(RepositoryDaoImpl.class);

    @Override
    public List<Repository> listerRepositories(Contexte contexte) throws DashboardException {
        ModelValidator.validerContexte(contexte);
        List<Repository> result = new ArrayList<Repository>();
        List<RepositoryJson> resultJson = new ArrayList<RepositoryJson>();

        RestTemplate restTemplate = new RestTemplate();
        RepositoryJsonCoverter converter = new RepositoryJsonCoverter();

        try {
            ResponseEntity<RepositoriesJson> results = restTemplate.exchange(UriBuilder.buildUri(contexte),
                    HttpMethod.GET, null, RepositoriesJson.class);
            resultJson.addAll(results.getBody().getValues());
        } catch (Exception e) {
            logger.error("Erreur pendant l'acces a l'api REST", e.getMessage());
            throw new DashboardException("Impossible de construire l'URI avec le contexte" + contexte.toString(), e);
        }

        for (RepositoryJson item : resultJson) {
            result.add(converter.convertToModel(item));
        }

        return result;
    }
}