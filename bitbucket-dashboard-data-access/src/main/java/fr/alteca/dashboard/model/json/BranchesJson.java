package fr.alteca.dashboard.model.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BranchesJson {
    private String pagelen;
    private List<BrancheJson> values;

    public String getPagelen() {
        return this.pagelen;
    }

    public void setPagelen(String pagelen) {
        this.pagelen = pagelen;
    }

    public List<BrancheJson> getValues() {
        return this.values;
    }

    public void setValues(List<BrancheJson> values) {
        this.values = values;
    }

}