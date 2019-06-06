package fr.alteca.dashboard.dao.impl;

import java.util.ArrayList;
import java.util.List;

import fr.alteca.dashboard.dao.RepositoryDao;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.model.Repository;

public class RepositoryDaoImpl implements RepositoryDao {

    @Override
    public List<Repository> listerRepositories(Contexte contexte) {
        List<Repository> result = new ArrayList<Repository>();
        // RestTemplate restTemplate = new RestTemplate();

        try {
            // ResponseEntity<RepositoriesJson> results =
            // restTemplate.exchange(UriBuilder.buildUri(contexte),
            // HttpMethod.GET, null, RepositoriesJson.class);
            // FIXME result.addAll(results.getBody().getValues());
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return result;
    }
}