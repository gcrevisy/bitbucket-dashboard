package fr.alteca.dashboard.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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

@Service
public class BrancheDaoImpl implements BrancheDao {
    private Logger logger = LoggerFactory.getLogger(BrancheDaoImpl.class);

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
            logger.error("Erreur pendant l'acces a l'api REST", e.getMessage());
            throw new DashboardException("Impossible de construire l'URI avec le contexte" + contexte.toString(), e);
        }

        for (BrancheJson item : resultJson) {
            result.add(converter.convertToModel(item));
        }

        return result;
    }

}