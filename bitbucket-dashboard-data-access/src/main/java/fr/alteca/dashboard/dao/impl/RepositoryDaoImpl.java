package fr.alteca.dashboard.dao.impl;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import fr.alteca.dashboard.dao.RepositoryDao;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.model.Repositories;
import fr.alteca.dashboard.model.Repository;

public class RepositoryDaoImpl extends AbstractDao implements RepositoryDao {

    @Override
    public List<Repository> listerRepositories(Contexte contexte) {
        List<Repository> result = new ArrayList<Repository>();
        RestTemplate restTemplate = new RestTemplate();
        URI repoUri;
        try {

            repoUri = new URI("https://api.bitbucket.org/2.0/repositories/gcrevisy");
            // Class clazz = (Class<Repository>) ((ParameterizedType)
            // getClass().getGenericSuperclass())
            // .getActualTypeArguments()[0];
            ResponseEntity<Repositories> results = restTemplate.exchange(repoUri, HttpMethod.GET, null,
                    Repositories.class);
            result.addAll(results.getBody().getValues());
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return result;
    }
}