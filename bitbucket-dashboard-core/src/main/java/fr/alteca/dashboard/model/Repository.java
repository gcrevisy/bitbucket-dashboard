package fr.alteca.dashboard.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {
    private String name;
    private String scm;

    public Repository() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScm() {
        return this.scm;
    }

    public void setScm(String scm) {
        this.scm = scm;
    }

}