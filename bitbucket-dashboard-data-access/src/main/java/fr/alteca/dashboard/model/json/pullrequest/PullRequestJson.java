package fr.alteca.dashboard.model.json.pullrequest;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PullRequestJson {
  private String id;
  private String title;
  private PullRequestMovementJson fromRef;
  private PullRequestMovementJson toRef;
  private PullRequestAuteurJson author;
  private String updated_on;

  public PullRequestJson() {
  }

  public PullRequestJson(String id, String title, PullRequestMovementJson source, PullRequestMovementJson destination, PullRequestAuteurJson author, String updated_on) {
	this.id = id;
	this.title = title;
	this.fromRef = source;
	this.toRef = destination;
	this.author = author;
	this.updated_on = updated_on;
  }

  public PullRequestJson author(PullRequestAuteurJson author) {
	this.author = author;
	return this;
  }

  public PullRequestJson destination(PullRequestMovementJson destination) {
	this.toRef = destination;
	return this;
  }

  @Override
  public boolean equals(Object o) {
	if (o == this) {
	  return true;
	}
	if (!(o instanceof PullRequestJson)) {
	  return false;
	}
	PullRequestJson pullRequestJson = (PullRequestJson) o;
	return Objects.equals(id, pullRequestJson.id) && Objects.equals(title, pullRequestJson.title) && Objects.equals(fromRef, pullRequestJson.fromRef) && Objects.equals(toRef, pullRequestJson.toRef) && Objects.equals(author, pullRequestJson.author) && Objects.equals(updated_on, pullRequestJson.updated_on);
  }

  public PullRequestAuteurJson getAuthor() {
	return this.author;
  }

  public PullRequestMovementJson getDestination() {
	return this.toRef;
  }

  public String getId() {
	return this.id;
  }

  public PullRequestMovementJson getSource() {
	return this.fromRef;
  }

  public String getTitle() {
	return this.title;
  }

  public String getUpdated_on() {
	return this.updated_on;
  }

  @Override
  public int hashCode() {
	return Objects.hash(id, title, fromRef, toRef, author, updated_on);
  }

  public PullRequestJson id(String id) {
	this.id = id;
	return this;
  }

  public void setAuthor(PullRequestAuteurJson author) {
	this.author = author;
  }

  public void setDestination(PullRequestMovementJson destination) {
	this.toRef = destination;
  }

  public void setId(String id) {
	this.id = id;
  }

  public void setSource(PullRequestMovementJson source) {
	this.fromRef = source;
  }

  public void setTitle(String title) {
	this.title = title;
  }

  public void setUpdated_on(String updated_on) {
	this.updated_on = updated_on;
  }

  public PullRequestJson source(PullRequestMovementJson source) {
	this.fromRef = source;
	return this;
  }

  public PullRequestJson title(String title) {
	this.title = title;
	return this;
  }

  @Override
  public String toString() {
	return "{" + " id='" + getId() + "'" + ", title='" + getTitle() + "'" + ", source='" + getSource() + "'" + ", destination='" + getDestination() + "'" + ", author='" + getAuthor() + "'" + ", updated_on='" + getUpdated_on() + "'" + "}";
  }

  public PullRequestJson updated_on(String updated_on) {
	this.updated_on = updated_on;
	return this;
  }

}