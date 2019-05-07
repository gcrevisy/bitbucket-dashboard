package fr.alteca.dashboard.utils;

import org.apache.commons.lang3.StringUtils;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Contexte;

public final class ModelValidator {

    private ModelValidator() {
    }

    public static void validerContexte(Contexte contexte) throws DashboardException {
        if (contexte == null) {
            throw new DashboardException("Contexte null");
        }
        if (StringUtils.isBlank(contexte.getRepositoryName())) {
            throw new DashboardException("Nom de repositry null");
        }
    }

}