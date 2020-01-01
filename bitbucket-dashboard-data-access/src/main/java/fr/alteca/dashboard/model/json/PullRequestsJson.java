package fr.alteca.dashboard.model.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PullRequestsJson {
    private String pagelen;
    private List<PullRequestJson> values;

    public PullRequestsJson() {

    }

    public List<PullRequestJson> getValues() {
        return this.values;
    }

    public void setValues(List<PullRequestJson> values) {
        this.values = values;
    }

    public String getPagelen() {
        return this.pagelen;
    }

    public void setPagelen(String pagelen) {
        this.pagelen = pagelen;
    }
}