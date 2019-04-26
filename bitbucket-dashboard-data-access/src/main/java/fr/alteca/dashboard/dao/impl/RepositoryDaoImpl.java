package fr.alteca.dashboard.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import fr.alteca.dashboard.dao.RepositoryDao;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.model.Repositories;
import fr.alteca.dashboard.model.Repository;
import fr.alteca.dashboard.utils.UriBuilder;

public class RepositoryDaoImpl implements RepositoryDao {

    @Override
    public List<Repository> listerRepositories(Contexte contexte) {
        List<Repository> result = new ArrayList<Repository>();
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<Repositories> results = restTemplate.exchange(UriBuilder.buildUri(contexte), HttpMethod.GET,
                    null, Repositories.class);
            result.addAll(results.getBody().getValues());
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return result;
    }
}