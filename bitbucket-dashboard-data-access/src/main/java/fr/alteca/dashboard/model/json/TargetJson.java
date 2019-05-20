package fr.alteca.dashboard.model.json;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TargetJson {

    private AuteurJson author;
    private String date;

    public TargetJson() {
    }

    public TargetJson(AuteurJson author, String date) {
        this.author = author;
        this.date = date;
    }

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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TargetJson)) {
            return false;
        }
        TargetJson targetJson = (TargetJson) o;
        return Objects.equals(author, targetJson.author) && Objects.equals(date, targetJson.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, date);
    }

}