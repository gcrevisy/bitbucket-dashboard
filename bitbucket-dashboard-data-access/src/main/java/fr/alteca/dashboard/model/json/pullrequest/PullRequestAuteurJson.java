package fr.alteca.dashboard.model.json.pullrequest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PullRequestAuteurJson {

  private String name;

  public PullRequestAuteurJson(String name) {
	super();
	this.name = name;
  }

  public String getName() {
	return name;
  }

  public void setName(String name) {
	this.name = name;
  }

}