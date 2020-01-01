package fr.alteca.dashboard.model.json;

public class PullRequestMovementJson {

    private BrancheJson branch;

    public PullRequestMovementJson() {
    }

    public PullRequestMovementJson(BrancheJson branch) {
        this.branch = branch;
    }

    public BrancheJson getBranch() {
        return this.branch;
    }

    public void setBranch(BrancheJson branch) {
        this.branch = branch;
    }

    public PullRequestMovementJson branch(BrancheJson branch) {
        this.branch = branch;
        return this;
    }

    @Override
    public String toString() {
        return "{" + " branch='" + getBranch() + "'" + "}";
    }

}