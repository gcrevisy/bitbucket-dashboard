package fr.alteca.dashboard.model;

public class Contexte {
  private String repositoryName;
  private String projectName;
  private String brancheName;
  private int pageSize;

  private boolean gettingPullRequestInfo;
  private boolean gettingBrancheInfo;

  public Contexte() {
	pageSize = 200;
  }

  public Contexte(Contexte contexte) {
	setRepositoryName(contexte.getRepositoryName());
	setProjectName(contexte.getProjectName());
	setBrancheName(contexte.getBrancheName());
	setPageSize(contexte.getPageSize());
  }

  public Contexte(String repositoryName) {
	this();
	this.repositoryName = repositoryName;
  }

  public Contexte(String repositoryName, String projectName) {
	this();
	this.repositoryName = repositoryName;
	this.projectName = projectName;
  }

  public Contexte(String repositoryName, String projectName, boolean brancheInfo, boolean pullRequestInfo) {
	this();
	this.repositoryName = repositoryName;
	this.projectName = projectName;
	this.gettingBrancheInfo = brancheInfo;
	this.gettingPullRequestInfo = pullRequestInfo;
  }

  public Contexte(String repositoryName, String projectName, String brancheName) {
	this();
	this.repositoryName = repositoryName;
	this.projectName = projectName;
	this.brancheName = brancheName;
  }

  public String getBrancheName() {
	return this.brancheName;
  }

  public int getPageSize() {
	return this.pageSize;
  }

  public String getProjectName() {
	return this.projectName;
  }

  public String getRepositoryName() {
	return this.repositoryName;
  }

  public boolean isGettingBrancheInfo() {
	return this.gettingBrancheInfo;
  }

  public boolean isGettingPullRequestInfo() {
	return this.gettingPullRequestInfo;
  }

  public void setBrancheName(String brancheName) {
	this.brancheName = brancheName;
  }

  public void setGettingBrancheInfo(boolean gettingBrancheInfo) {
	this.gettingBrancheInfo = gettingBrancheInfo;
	this.gettingPullRequestInfo = !gettingBrancheInfo;
  }

  public void setGettingPullRequestInfo(boolean gettingPullRequestInfo) {
	this.gettingPullRequestInfo = gettingPullRequestInfo;
	this.gettingBrancheInfo = !gettingPullRequestInfo;
  }

  public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
  }

  public void setProjectName(String projectName) {
	this.projectName = projectName;
  }

  public void setRepositoryName(String repositoryName) {
	this.repositoryName = repositoryName;
  }

  @Override
  public String toString() {
	return "{" + " repositoryName='" + getRepositoryName() + "'" + ", projectName='" + getProjectName() + "'" + ", brancheName='" + getBrancheName() + "'" + ", pageSize='" + getPageSize() + "'" + ", gettingPullRequestInfo='" + isGettingPullRequestInfo() + "'" + ", gettingBrancheInfo='" + isGettingBrancheInfo() + "'" + "}";
  }

}
