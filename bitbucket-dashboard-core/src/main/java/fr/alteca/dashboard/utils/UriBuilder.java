package fr.alteca.dashboard.utils;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.lang3.StringUtils;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Contexte;

public final class UriBuilder {
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
            }
        }
        try {
            uri = new URI(uriValue);
        } catch (URISyntaxException e) {
            throw new DashboardException("impossible de construire l'URI avec le contexte" + contexte.toString());
        }

        return uri;
    }

}