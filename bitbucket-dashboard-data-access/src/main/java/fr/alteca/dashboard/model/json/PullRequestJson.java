package fr.alteca.dashboard.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PullRequestJson {
    private String title;
    private PullRequestMovementJson source;
    private PullRequestMovementJson destination;
    private AuteurJson author;

    public PullRequestJson() {
    }

    public PullRequestJson(String title, PullRequestMovementJson source, PullRequestMovementJson destination,
            AuteurJson author) {
        this.title = title;
        this.source = source;
        this.destination = destination;
        this.author = author;
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

    public AuteurJson getAuthor() {
        return this.author;
    }

    public void setAuthor(AuteurJson author) {
        this.author = author;
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

    public PullRequestJson author(AuteurJson author) {
        this.author = author;
        return this;
    }

    @Override
    public String toString() {
        return "{" + " title='" + getTitle() + "'" + ", source='" + getSource() + "'" + ", destination='"
                + getDestination() + "'" + ", author='" + getAuthor() + "'" + "}";
    }

}