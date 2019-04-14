package fr.alteca.dashboard.service.impl;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.service.BrancheService;
import fr.alteca.dashboard.wrapper.BitbucketWrapper;

public class BrancheServiceImpl implements BrancheService {

    private BitbucketWrapper bitbucketWrapper;

    public BrancheServiceImpl() {
    }

    public BrancheServiceImpl(BitbucketWrapper bitbucketWrapper) {
        this.bitbucketWrapper = bitbucketWrapper;
    }

    @Override
    public List<Branche> controlerNom(URI repoUri) {
        List<Branche> liste = bitbucketWrapper.listerBranches(repoUri);
        List<Branche> result = new ArrayList<Branche>();

        for (Branche item : liste) {

            if ("master".equals(item.getName())) {
                continue;
            }

            if (StringUtils.isNotBlank(item.getName()) && !item.getName().startsWith("feature/")) {
                result.add(item);
            }
        }

        return result;
    }

    @Override
    public List<Branche> controlerDateCreation(URI repoUri) {
        return null;
    }

}