package fr.alteca.dashboard.model.json.pullrequest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PullRequestsJson {
  private List<PullRequestJson> values;

  public PullRequestsJson() {

  }

  public List<PullRequestJson> getValues() {
	return this.values;
  }

  public void setValues(List<PullRequestJson> values) {
	this.values = values;
  }

}