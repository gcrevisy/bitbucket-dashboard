package fr.alteca.dashboard.model.json;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BranchesJson {
    private String pagelen;
    private List<BrancheJson> values;

    public BranchesJson() {
    }

    public BranchesJson(String pagelen, List<BrancheJson> values) {
        this.pagelen = pagelen;
        this.values = values;
    }

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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BranchesJson)) {
            return false;
        }
        BranchesJson branchesJson = (BranchesJson) o;
        return Objects.equals(pagelen, branchesJson.pagelen) && Objects.equals(values, branchesJson.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagelen, values);
    }

}