package fr.alteca.dashboard.model;

public class Contexte {
    private String repositoryName;
    private String projectName;
    private String brancheName;

    public Contexte() {
    }

    public Contexte(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public Contexte(String repositoryName, String projectName) {
        this.repositoryName = repositoryName;
        this.projectName = projectName;
    }

    public Contexte(String repositoryName, String projectName, String brancheName) {
        this.repositoryName = repositoryName;
        this.projectName = projectName;
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

    @Override
    public String toString() {
        return "{ " + "repositoryName='" + getRepositoryName() + "'" + ", projectName='" + getProjectName() + "'"
                + ", brancheName='" + getBrancheName() + "'" + " }";
    }

}
