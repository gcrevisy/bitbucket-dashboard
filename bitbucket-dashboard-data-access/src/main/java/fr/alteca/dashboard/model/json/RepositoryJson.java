package fr.alteca.dashboard.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryJson {
    private String name;
    private String scm;

    public RepositoryJson() {
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