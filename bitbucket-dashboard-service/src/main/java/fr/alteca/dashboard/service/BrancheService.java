package fr.alteca.dashboard.service;

import java.util.List;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.Contexte;

public interface BrancheService {

    /**
     * 
     * @param contexte
     * @return
     * @throws DashboardException
     */
    List<Branche> listerBranche(Contexte contexte) throws DashboardException;

}