package fr.alteca.dashboard.model.json;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BrancheJson {

    private String name;
    private TargetJson target;

    public BrancheJson() {
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

}