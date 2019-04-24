package fr.alteca.dashboard.model;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Branche)) {
            return false;
        }
        Branche branche = (Branche) o;
        return Objects.equals(name, branche.name) && Objects.equals(dateCreation, branche.dateCreation)
                && Objects.equals(auteur, branche.auteur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateCreation, auteur);
    }

}