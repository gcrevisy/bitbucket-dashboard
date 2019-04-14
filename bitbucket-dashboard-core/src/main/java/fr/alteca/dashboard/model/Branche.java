package fr.alteca.dashboard.model;

import java.util.Date;

public class Branche {

    private String name;
    private Date dateCreation;
    private String auteur;

    public Branche() {
    }

    public Branche(String name, Date dateCreation, String auteur) {
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

    public Date getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getAuteur() {
        return this.auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

}