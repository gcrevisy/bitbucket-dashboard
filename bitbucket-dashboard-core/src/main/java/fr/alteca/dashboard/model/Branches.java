package fr.alteca.dashboard.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Branches {
    private String pagelen;
    private List<Branche> values;

    public String getPagelen() {
        return this.pagelen;
    }

    public void setPagelen(String pagelen) {
        this.pagelen = pagelen;
    }

    public List<Branche> getValues() {
        return this.values;
    }

    public void setValues(List<Branche> values) {
        this.values = values;
    }

}