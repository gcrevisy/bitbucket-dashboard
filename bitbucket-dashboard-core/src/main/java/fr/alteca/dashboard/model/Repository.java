package fr.alteca.dashboard.model;

import java.util.Objects;

public class Repository {
    private String name;
    private String scm;

    public Repository() {
    }

    public Repository(String name, String scm) {
        this.name = name;
        this.scm = scm;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScm() {
        return this.scm;
    }

    public void setScm(String scm) {
        this.scm = scm;
    }

    public Repository name(String name) {
        this.name = name;
        return this;
    }

    public Repository scm(String scm) {
        this.scm = scm;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Repository)) {
            return false;
        }
        Repository repository = (Repository) o;
        return Objects.equals(name, repository.name) && Objects.equals(scm, repository.scm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, scm);
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", scm='" + getScm() + "'" + "}";
    }

}