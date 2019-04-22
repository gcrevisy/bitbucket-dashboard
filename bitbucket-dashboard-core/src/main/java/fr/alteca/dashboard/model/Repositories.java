package fr.alteca.dashboard.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repositories {

    private String pagelen;
    private List<Repository> values;

    public Repositories() {

    }

    public List<Repository> getValues() {
        return this.values;
    }

    public void setValues(List<Repository> values) {
        this.values = values;
    }

    public String getPagelen() {
        return this.pagelen;
    }

    public void setPagelen(String pagelen) {
        this.pagelen = pagelen;
    }

}