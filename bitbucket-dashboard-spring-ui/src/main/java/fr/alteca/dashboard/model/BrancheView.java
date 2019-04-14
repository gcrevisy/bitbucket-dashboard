package fr.alteca.dashboard.model;

public class BrancheView {
    private String name;
    private String creationDate;
    private String color;

    public BrancheView() {
        this.name = "name";
        this.creationDate = "creationDate";
        color = "red";
    }

    public BrancheView(String name, String creationDate) {
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

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}