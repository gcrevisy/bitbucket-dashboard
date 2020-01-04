package fr.alteca.dashboard.service;

import java.util.List;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.Contexte;

public interface BrancheService {

    /**
     * Controle le nom des branches du dépôt dont l'URI est fournie.
     * 
     * @param contexte {@link Contexte}
     * @return Liste des {@link Branche} en erreur
     * @throws DashboardException
     */
    List<Branche> controlerNom(Contexte contexte) throws DashboardException;

    /**
     * Controle la date de création des branches du dépôt dont l'URI est fournie.
     * 
     * @param contexte {@link Contexte}
     * @return Liste des {@link Branche} en erreur
     * @throws DashboardException
     */
    List<Branche> controlerDateCreation(Contexte contexte) throws DashboardException;

}