package fr.alteca.dashboard.model;

import java.util.Objects;

public class BrancheModel {
    private String name;
    private String dateCreation;
    private String auteur;

    public BrancheModel() {
    }

    public BrancheModel(String name, String dateCreation, String auteur) {
        this.name = name;
        this.dateCreation = dateCreation;
        this.auteur = auteur;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getAuteur() {
        return this.auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BrancheModel)) {
            return false;
        }
        BrancheModel brancheView = (BrancheModel) o;
        return Objects.equals(name, brancheView.name) && Objects.equals(dateCreation, brancheView.dateCreation)
                && Objects.equals(auteur, brancheView.auteur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateCreation, auteur);
    }

}