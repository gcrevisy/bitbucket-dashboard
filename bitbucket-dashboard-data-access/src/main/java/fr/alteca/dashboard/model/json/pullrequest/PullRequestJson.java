package fr.alteca.dashboard.model.json.pullrequest;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PullRequestJson {
    private String title;
    private PullRequestMovementJson source;
    private PullRequestMovementJson destination;
    private PullRequestAuteurJson author;
    private String updated_on;

    public PullRequestJson() {
    }

    public PullRequestJson(String title, PullRequestMovementJson source, PullRequestMovementJson destination,
            PullRequestAuteurJson author, String updated_on) {
        this.title = title;
        this.source = source;
        this.destination = destination;
        this.author = author;
        this.updated_on = updated_on;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PullRequestMovementJson getSource() {
        return this.source;
    }

    public void setSource(PullRequestMovementJson source) {
        this.source = source;
    }

    public PullRequestMovementJson getDestination() {
        return this.destination;
    }

    public void setDestination(PullRequestMovementJson destination) {
        this.destination = destination;
    }

    public PullRequestAuteurJson getAuthor() {
        return this.author;
    }

    public void setAuthor(PullRequestAuteurJson author) {
        this.author = author;
    }

    public String getUpdated_on() {
        return this.updated_on;
    }

    public void setUpdated_on(String updated_on) {
        this.updated_on = updated_on;
    }

    public PullRequestJson title(String title) {
        this.title = title;
        return this;
    }

    public PullRequestJson source(PullRequestMovementJson source) {
        this.source = source;
        return this;
    }

    public PullRequestJson destination(PullRequestMovementJson destination) {
        this.destination = destination;
        return this;
    }

    public PullRequestJson author(PullRequestAuteurJson author) {
        this.author = author;
        return this;
    }

    public PullRequestJson updated_on(String updated_on) {
        this.updated_on = updated_on;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PullRequestJson)) {
            return false;
        }
        PullRequestJson pullRequestJson = (PullRequestJson) o;
        return Objects.equals(title, pullRequestJson.title) && Objects.equals(source, pullRequestJson.source)
                && Objects.equals(destination, pullRequestJson.destination)
                && Objects.equals(author, pullRequestJson.author)
                && Objects.equals(updated_on, pullRequestJson.updated_on);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, source, destination, author, updated_on);
    }

    @Override
    public String toString() {
        return "{" + " title='" + getTitle() + "'" + ", source='" + getSource() + "'" + ", destination='"
                + getDestination() + "'" + ", author='" + getAuthor() + "'" + ", updated_on='" + getUpdated_on() + "'"
                + "}";
    }

}