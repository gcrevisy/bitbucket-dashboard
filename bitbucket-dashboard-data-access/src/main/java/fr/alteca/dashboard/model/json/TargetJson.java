package fr.alteca.dashboard.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TargetJson {

    private AuteurJson author;
    private String date;

    public AuteurJson getAuthor() {
        return this.author;
    }

    public void setAuthor(AuteurJson author) {
        this.author = author;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}