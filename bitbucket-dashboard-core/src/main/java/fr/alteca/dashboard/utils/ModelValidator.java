package fr.alteca.dashboard.utils;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Contexte;

public final class ModelValidator {

    private ModelValidator() {
    }

    public static void validerContexte(Contexte contexte) throws DashboardException {
        if (contexte == null) {
            throw new DashboardException("Contexte null");
        }
    }

}