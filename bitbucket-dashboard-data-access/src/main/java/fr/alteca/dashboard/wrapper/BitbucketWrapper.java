package fr.alteca.dashboard.wrapper;

import java.net.URI;
import java.util.List;

import fr.alteca.dashboard.model.Branche;

public interface BitbucketWrapper {
    /**
     * Obtient la liste des branches d'un dépôt.
     * 
     * @param uri {@link URI} du dépôt
     * @return Liste des {@link Branche} du dépôt
     */
    List<Branche> listerBranches(URI uri);
}