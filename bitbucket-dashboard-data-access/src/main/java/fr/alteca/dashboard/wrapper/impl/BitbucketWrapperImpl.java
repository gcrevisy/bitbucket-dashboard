package fr.alteca.dashboard.wrapper.impl;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.Repository;
import fr.alteca.dashboard.wrapper.BitbucketWrapper;

public class BitbucketWrapperImpl implements BitbucketWrapper {

    @Override
    public List<Branche> listerBranches(URI repoUri) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Branche[]> branches = restTemplate.exchange(repoUri, HttpMethod.GET, null, Branche[].class);
        return Arrays.asList(branches.getBody());
    }

    @Override
    public List<Repository> listerRepositories(URI repoUri) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Repository[]> branches = restTemplate.exchange(repoUri, HttpMethod.GET, null,
                Repository[].class);
        return Arrays.asList(branches.getBody());
    }
}