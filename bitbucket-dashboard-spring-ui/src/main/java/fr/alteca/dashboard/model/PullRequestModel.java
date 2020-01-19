package fr.alteca.dashboard.model;

import java.util.Objects;

public class PullRequestModel {
    private String id;
    private String name;
    private String dateCreation;
    private String auteur;
    private String brancheDepart;
    private String brancheArrivee;

    public PullRequestModel() {
    }

    public PullRequestModel(String id, String name, String dateCreation, String auteur, String brancheDepart,
            String brancheArrivee) {
        this.id = id;
        this.name = name;
        this.dateCreation = dateCreation;
        this.auteur = auteur;
        this.brancheDepart = brancheDepart;
        this.brancheArrivee = brancheArrivee;
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

    public String getBrancheDepart() {
        return this.brancheDepart;
    }

    public void setBrancheDepart(String brancheDepart) {
        this.brancheDepart = brancheDepart;
    }

    public String getBrancheArrivee() {
        return this.brancheArrivee;
    }

    public void setBrancheArrivee(String brancheArrivee) {
        this.brancheArrivee = brancheArrivee;
    }

    public PullRequestModel id(String id) {
        this.id = id;
        return this;
    }

    public PullRequestModel name(String name) {
        this.name = name;
        return this;
    }

    public PullRequestModel dateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
        return this;
    }

    public PullRequestModel auteur(String auteur) {
        this.auteur = auteur;
        return this;
    }

    public PullRequestModel brancheDepart(String brancheDepart) {
        this.brancheDepart = brancheDepart;
        return this;
    }

    public PullRequestModel brancheArrivee(String brancheArrivee) {
        this.brancheArrivee = brancheArrivee;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PullRequestModel)) {
            return false;
        }
        PullRequestModel pullRequestModel = (PullRequestModel) o;
        return Objects.equals(id, pullRequestModel.id) && Objects.equals(name, pullRequestModel.name)
                && Objects.equals(dateCreation, pullRequestModel.dateCreation)
                && Objects.equals(auteur, pullRequestModel.auteur)
                && Objects.equals(brancheDepart, pullRequestModel.brancheDepart)
                && Objects.equals(brancheArrivee, pullRequestModel.brancheArrivee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateCreation, auteur, brancheDepart, brancheArrivee);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", dateCreation='" + getDateCreation()
                + "'" + ", auteur='" + getAuteur() + "'" + ", brancheDepart='" + getBrancheDepart() + "'"
                + ", brancheArrivee='" + getBrancheArrivee() + "'" + "}";
    }

}