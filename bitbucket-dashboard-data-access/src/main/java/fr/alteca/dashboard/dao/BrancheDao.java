package fr.alteca.dashboard.dao;

import java.util.List;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.Contexte;

public interface BrancheDao {
    /**
     * Obtient la liste des branches d'un dépôt.
     * 
     * @param contexte {@link URI} du dépôt
     * @return Liste des {@link Branche} du dépôt
     * @throws DashboardException
     */
    List<Branche> listerBranches(Contexte contexte) throws DashboardException;
}