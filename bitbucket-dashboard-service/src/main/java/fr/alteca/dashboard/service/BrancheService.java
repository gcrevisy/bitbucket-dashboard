package fr.alteca.dashboard.service;

import java.util.List;

import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.Contexte;

public interface BrancheService {
    /**
     * Controle le nom des branches du dépôt dont l'URI est fournie.
     * 
     * @param contexte {@link Contexte}
     * @return Liste des {@link Branche} en erreur
     */
    List<Branche> controlerNom(Contexte contexte);

    /**
     * Controle la date de création des branches du dépôt dont l'URI est fournie.
     * 
     * @param contexte {@link Contexte}
     * @return Liste des {@link Branche} en erreur
     */
    List<Branche> controlerDateCreation(Contexte contexte);
}