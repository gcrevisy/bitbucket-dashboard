package fr.alteca.dashboard.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import fr.alteca.dashboard.converter.BrancheJsonConverter;
import fr.alteca.dashboard.dao.BrancheDao;
import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.model.json.BrancheJson;
import fr.alteca.dashboard.model.json.BranchesJson;
import fr.alteca.dashboard.utils.ModelValidator;
import fr.alteca.dashboard.utils.UriBuilder;

public class BrancheDaoImpl implements BrancheDao {

    @Override
    public List<Branche> listerBranches(Contexte contexte) throws DashboardException {
        ModelValidator.validerContexte(contexte);

        List<Branche> result = new ArrayList<Branche>();
        List<BrancheJson> resultJson = new ArrayList<BrancheJson>();

        RestTemplate restTemplate = new RestTemplate();
        BrancheJsonConverter converter = new BrancheJsonConverter();

        try {
            ResponseEntity<BranchesJson> results = restTemplate.exchange(UriBuilder.buildUri(contexte), HttpMethod.GET,
                    null, BranchesJson.class);
            resultJson.addAll(results.getBody().getValues());
        } catch (Exception e) {
            System.out.println(e.getCause());
        }

        for (BrancheJson item : resultJson) {
            result.add(converter.convertToModel(item));
        }

        return result;
    }

}