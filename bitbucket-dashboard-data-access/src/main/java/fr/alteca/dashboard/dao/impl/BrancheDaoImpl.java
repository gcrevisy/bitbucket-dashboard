package fr.alteca.dashboard.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private Logger logger = LoggerFactory.getLogger(BrancheDaoImpl.class);

    @Override
    public List<Branche> listerBranches(Contexte contexte) throws DashboardException {
        ModelValidator.validerContexte(contexte);

        List<Branche> result = new ArrayList<Branche>();
        List<BrancheJson> resultJson = new ArrayList<BrancheJson>();

        RestTemplate restTemplate = new RestTemplate();
        BrancheJsonConverter converter = new BrancheJsonConverter();

        try {

            // String username = "gcrevisy@outlook.com";
            // String password = "zwj3cmb5tp";
            // HttpEntity httpEntity = new HttpEntity(createHeaders(username, password));
            // httpEntity.getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
            // ResponseEntity<Branche[]> branches = restTemplate.excChange(new
            // URI(uriValueBranche), HttpMethod.GET, httpEntity, Branche[].class);
            // ResponseEntity<Branche[]> branches = restTemplate.exchange(new
            // URI(uriValueBranche), HttpMethod.GET, null, Branche[].class);
            // List<Branche> branches = Arrays.asList(restTemplate.getForObject(new
            // URI(uriValue), Branche[].class));

            // restTemplate.getInterceptors().add(new
            // BasicAuthorizationInterceptor(username, password));

            ResponseEntity<BranchesJson> results = restTemplate.exchange(UriBuilder.buildUri(contexte), HttpMethod.GET,
                    null, BranchesJson.class);
            resultJson.addAll(results.getBody().getValues());
        } catch (Exception e) {
            logger.error("Erreur pendant l'acces a l'api REST", e.getMessage());
        }

        for (BrancheJson item : resultJson) {
            result.add(converter.convertToModel(item));
        }

        return result;
    }

    // private MultiValueMap createHeaders(String username, String password) {
    // return new HttpHeaders() {
    // private static final long serialVersionUID = 1L;

    // {
    // String auth = username + ":" + password;
    // byte[] encodedAuth =
    // Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
    // String authHeader = "Basic " + new String(encodedAuth);
    // set("Authorization", authHeader);
    // }
    // };
    // }

}