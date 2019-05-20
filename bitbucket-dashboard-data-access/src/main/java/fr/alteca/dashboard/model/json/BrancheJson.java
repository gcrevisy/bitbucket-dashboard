package fr.alteca.dashboard.model.json;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BrancheJson {

    private String name;
    private TargetJson target;

    public BrancheJson() {
    }

    public BrancheJson(String name, TargetJson target) {
        this.name = name;
        this.target = target;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TargetJson getTarget() {
        return this.target;
    }

    public void setTarget(TargetJson target) {
        this.target = target;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BrancheJson)) {
            return false;
        }
        BrancheJson brancheJson = (BrancheJson) o;
        return Objects.equals(name, brancheJson.name) && Objects.equals(target, brancheJson.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, target);
    }

}