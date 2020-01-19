package fr.alteca.dashboard.model;

import java.util.Objects;

public class BrancheModel {
    private String id;
    private String name;
    private String dateCreation;
    private String auteur;

    public BrancheModel() {
    }

    public BrancheModel(String id, String name, String dateCreation, String auteur) {
        this.id = id;
        this.name = name;
        this.dateCreation = dateCreation;
        this.auteur = auteur;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    public BrancheModel id(String id) {
        this.id = id;
        return this;
    }

    public BrancheModel name(String name) {
        this.name = name;
        return this;
    }

    public BrancheModel dateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
        return this;
    }

    public BrancheModel auteur(String auteur) {
        this.auteur = auteur;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BrancheModel)) {
            return false;
        }
        BrancheModel brancheModel = (BrancheModel) o;
        return Objects.equals(id, brancheModel.id) && Objects.equals(name, brancheModel.name)
                && Objects.equals(dateCreation, brancheModel.dateCreation)
                && Objects.equals(auteur, brancheModel.auteur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateCreation, auteur);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", dateCreation='" + getDateCreation()
                + "'" + ", auteur='" + getAuteur() + "'" + "}";
    }

}