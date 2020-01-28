package fr.alteca.dashboard.model.json;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BrancheJson {

  private String displayId;
  private TargetJson target;

  public BrancheJson() {
  }

  public BrancheJson(String name, TargetJson target) {
	this.displayId = name;
	this.target = target;
  }

  @Override
  public boolean equals(Object o) {
	if (o == this) {
	  return true;
	}
	if (!(o instanceof BrancheJson)) {
	  return false;
	}
	BrancheJson brancheJson = (BrancheJson) o;
	return Objects.equals(displayId, brancheJson.displayId) && Objects.equals(target, brancheJson.target);
  }

  public String getName() {
	return this.displayId;
  }

  public TargetJson getTarget() {
	return this.target;
  }

  @Override
  public int hashCode() {
	return Objects.hash(displayId, target);
  }

  public void setName(String name) {
	this.displayId = name;
  }

  public void setTarget(TargetJson target) {
	this.target = target;
  }

}