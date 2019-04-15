package fr.alteca.dashboard.model;

public class Contexte {
    private String projectName;
    private String repositoryName;
    private String brancheName;

    public Contexte(String projectName) {
        this.projectName = projectName;
    }

    public Contexte(String projectName, String repositoryName) {
        this.projectName = projectName;
        this.repositoryName = repositoryName;
    }

    public Contexte(String projectName, String repositoryName, String brancheName) {
        this.projectName = projectName;
        this.repositoryName = repositoryName;
        this.brancheName = brancheName;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getRepositoryName() {
        return this.repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getBrancheName() {
        return this.brancheName;
    }

    public void setBrancheName(String brancheName) {
        this.brancheName = brancheName;
    }

}
