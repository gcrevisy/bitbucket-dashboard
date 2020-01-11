package fr.alteca.dashboard.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RepositoryModel {

    private String name;
    private List<BrancheModel> branches;
    private List<PullRequestModel> pullRequests;

    public RepositoryModel() {
        branches = new ArrayList<BrancheModel>();
        pullRequests = new ArrayList<PullRequestModel>();
    }

    public RepositoryModel(String name, List<BrancheModel> branches, List<PullRequestModel> pullRequests) {
        this.name = name;
        this.branches = branches;
        this.pullRequests = pullRequests;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BrancheModel> getBranches() {
        return this.branches;
    }

    public void setBranches(List<BrancheModel> branches) {
        this.branches = branches;
    }

    public List<PullRequestModel> getPullRequests() {
        return this.pullRequests;
    }

    public void setPullRequests(List<PullRequestModel> pullRequests) {
        this.pullRequests = pullRequests;
    }

    public RepositoryModel name(String name) {
        this.name = name;
        return this;
    }

    public RepositoryModel branches(List<BrancheModel> branches) {
        this.branches = branches;
        return this;
    }

    public RepositoryModel pullRequests(List<PullRequestModel> pullRequests) {
        this.pullRequests = pullRequests;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RepositoryModel)) {
            return false;
        }
        RepositoryModel repositoryModel = (RepositoryModel) o;
        return Objects.equals(name, repositoryModel.name) && Objects.equals(branches, repositoryModel.branches)
                && Objects.equals(pullRequests, repositoryModel.pullRequests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, branches, pullRequests);
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", branches='" + getBranches() + "'" + ", pullRequests='"
                + getPullRequests() + "'" + "}";
    }

}