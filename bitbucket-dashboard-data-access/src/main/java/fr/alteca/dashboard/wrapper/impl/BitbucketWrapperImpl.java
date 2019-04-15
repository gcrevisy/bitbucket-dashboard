package fr.alteca.dashboard.wrapper.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.model.Repository;
import fr.alteca.dashboard.wrapper.BrancheDao;
import fr.alteca.dashboard.wrapper.RepositoryDao;

public class BitbucketWrapperImpl implements RepositoryDao, BrancheDao {

    @Override
    public List<Branche> listerBranches(Contexte contexte) {
        RestTemplate restTemplate = new RestTemplate();
        List<Branche> result = new ArrayList<Branche>();
        URI repoUri;
        try {
            repoUri = new URI("");
            ResponseEntity<Branche[]> branches = restTemplate.exchange(repoUri, HttpMethod.GET, null, Branche[].class);
            result.addAll(Arrays.asList(branches.getBody()));
        } catch (URISyntaxException e) {

        }
        return result;
    }

    @Override
    public List<Repository> listerRepositories(Contexte contexte) {
        RestTemplate restTemplate = new RestTemplate();
        List<Repository> result = new ArrayList<Repository>();
        URI repoUri;
        try {
            repoUri = new URI("");
            ResponseEntity<Repository[]> branches = restTemplate.exchange(repoUri, HttpMethod.GET, null,
                    Repository[].class);
            result.addAll(Arrays.asList(branches.getBody()));
        } catch (URISyntaxException e) {

        }
        return result;
    }
}