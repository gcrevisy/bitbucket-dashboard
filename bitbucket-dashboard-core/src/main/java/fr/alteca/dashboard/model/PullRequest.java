package fr.alteca.dashboard.model;

import java.util.GregorianCalendar;

public class PullRequest {
    private String name;
    private GregorianCalendar dateCreation;
    private String auteur;
    private String brancheDepart;
    private String brancheArrivee;

    public PullRequest() {
    }

    public PullRequest(String name, GregorianCalendar dateCreation, String auteur, String brancheDepart,
            String brancheArrivee) {
        this.name = name;
        this.dateCreation = dateCreation;
        this.auteur = auteur;
        this.brancheDepart = brancheDepart;
        this.brancheArrivee = brancheArrivee;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GregorianCalendar getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(GregorianCalendar dateCreation) {
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

    public PullRequest name(String name) {
        this.name = name;
        return this;
    }

    public PullRequest dateCreation(GregorianCalendar dateCreation) {
        this.dateCreation = dateCreation;
        return this;
    }

    public PullRequest auteur(String auteur) {
        this.auteur = auteur;
        return this;
    }

    public PullRequest brancheDepart(String brancheDepart) {
        this.brancheDepart = brancheDepart;
        return this;
    }

    public PullRequest brancheArrivee(String brancheArrivee) {
        this.brancheArrivee = brancheArrivee;
        return this;
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", dateCreation='" + getDateCreation() + "'" + ", auteur='"
                + getAuteur() + "'" + ", brancheDepart='" + getBrancheDepart() + "'" + ", brancheArrivee='"
                + getBrancheArrivee() + "'" + "}";
    }

}
