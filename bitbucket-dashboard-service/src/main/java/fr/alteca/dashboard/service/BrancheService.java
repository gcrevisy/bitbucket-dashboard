package fr.alteca.dashboard.service;

import java.util.List;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.Contexte;

public interface BrancheService {

    /**
     * Serivce listant les branches en anomalies (nom ou date).
     * @param contexte {@link Contexte}
     * @return Liste de {@link Branche}
     * @throws DashboardException
     */
    List<Branche> listerBranche(Contexte contexte) throws DashboardException;

}