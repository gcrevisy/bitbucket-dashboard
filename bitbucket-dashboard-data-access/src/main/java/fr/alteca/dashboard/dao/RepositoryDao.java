package fr.alteca.dashboard.dao;

import java.util.List;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.model.Repository;

public interface RepositoryDao {
    /**
     * Obtient la liste des dépôts d'un user.
     * 
     * @param contexte {@link Contexte}
     * @return Liste des {@link Repository} du dépôt
     * @throws DashboardException
     */
    List<Repository> listerRepositories(Contexte contexte) throws DashboardException;
}