package fr.alteca.dashboard.model.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoriesJson {

    private String pagelen;
    private List<RepositoryJson> values;

    public RepositoriesJson() {

    }

    public List<RepositoryJson> getValues() {
        return this.values;
    }

    public void setValues(List<RepositoryJson> values) {
        this.values = values;
    }

    public String getPagelen() {
        return this.pagelen;
    }

    public void setPagelen(String pagelen) {
        this.pagelen = pagelen;
    }

}