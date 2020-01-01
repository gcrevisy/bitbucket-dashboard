package fr.alteca.dashboard.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PullRequestJson {
    private String title;
    private PullRequestMovementJson source;
    private PullRequestMovementJson destination;

    public PullRequestJson() {
    }

    public PullRequestJson(String title, PullRequestMovementJson source, PullRequestMovementJson destination) {
        this.title = title;
        this.source = source;
        this.destination = destination;
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

}