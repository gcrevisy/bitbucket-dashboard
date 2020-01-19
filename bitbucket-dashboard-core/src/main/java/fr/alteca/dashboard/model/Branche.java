package fr.alteca.dashboard.model;

import java.util.GregorianCalendar;
import java.util.Objects;

public class Branche {

    private String id;
    private String name;
    private GregorianCalendar dateCreation;
    private String auteur;

    public Branche() {
    }

    public Branche(String id, String name, GregorianCalendar dateCreation, String auteur) {
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

    public Branche id(String id) {
        this.id = id;
        return this;
    }

    public Branche name(String name) {
        this.name = name;
        return this;
    }

    public Branche dateCreation(GregorianCalendar dateCreation) {
        this.dateCreation = dateCreation;
        return this;
    }

    public Branche auteur(String auteur) {
        this.auteur = auteur;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Branche)) {
            return false;
        }
        Branche branche = (Branche) o;
        return Objects.equals(id, branche.id) && Objects.equals(name, branche.name)
                && Objects.equals(dateCreation, branche.dateCreation) && Objects.equals(auteur, branche.auteur);
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