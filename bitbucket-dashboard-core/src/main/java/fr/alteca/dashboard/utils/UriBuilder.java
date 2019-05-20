package fr.alteca.dashboard.utils;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Contexte;

public final class UriBuilder {

    private static Logger logger = LoggerFactory.getLogger(UriBuilder.class);

    private UriBuilder() {
    }

    public static URI buildUri(Contexte contexte) throws DashboardException {
        ModelValidator.validerContexte(contexte);
        URI uri = null;
        String uriValue = "https://api.bitbucket.org/2.0/repositories/";

        if (StringUtils.isNotBlank(contexte.getRepositoryName())) {
            uriValue += contexte.getRepositoryName();
            if (StringUtils.isNotBlank(contexte.getProjectName())) {
                uriValue += "/" + contexte.getProjectName() + "/refs/branches/";
                if (StringUtils.isNotBlank(contexte.getBrancheName())) {
                    uriValue += contexte.getBrancheName();
                }
            }
        }
        try {
            logger.info("Construction de l'uri " + uriValue);
            uri = new URI(uriValue);
        } catch (URISyntaxException e) {
            logger.error("Impossible de construire l'URI avec le contexte" + contexte.toString());
            throw new DashboardException("Impossible de construire l'URI avec le contexte" + contexte.toString(), e);
        }

        return uri;
    }

}