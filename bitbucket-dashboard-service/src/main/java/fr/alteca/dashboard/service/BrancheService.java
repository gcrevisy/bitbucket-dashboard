package fr.alteca.dashboard.service;

public interface BrancheService{
/**
     * Controle le nom des branches du dépôt dont l'URI est fournie.
     * 
     * @param repoUri {@link URI}
     * @return Liste des {@link Branche} en erreur
     */
    List<Branche> controlerNom(URI repoUri);

    /** 
     * Controle la date de création des branches du dépôt dont l'URI est fournie.
     * 
     * @param repoUri {@link URI}
     * @return Liste des {@link Branche} en erreur
     */
    List<Branche> controlerDateCreation(URI repoUri);
}