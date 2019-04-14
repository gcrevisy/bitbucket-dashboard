package fr.alteca.dashboard.wrapper;

import java.net.URI;
import java.util.List;

import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.Repository;

public interface BitbucketWrapper {
    /**
     * Obtient la liste des branches d'un dépôt.
     * 
     * @param repoUri {@link URI} du dépôt
     * @return Liste des {@link Branche} du dépôt
     */
    List<Branche> listerBranches(URI repoUri);

    /**
     * Obtient la liste des dépôts d'un user.
     * 
     * @param repoUri {@link URI} du dépôt
     * @return Liste des {@link Repository} du dépôt
     */
    List<Repository> listerRepositories(URI repoUri);
}