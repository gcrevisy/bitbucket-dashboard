package fr.alteca.dashboard.model;

public class Branche {
    private String name;
    private String creationDate;

    public Branche() {
        this.name = "name";
        this.creationDate = "creationDate";
    }

    public Branche(String name, String creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

}