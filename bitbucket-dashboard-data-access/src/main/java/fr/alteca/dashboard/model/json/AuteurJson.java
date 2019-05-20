package fr.alteca.dashboard.model.json;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuteurJson {

    private UserJson user;

    public AuteurJson() {
    }

    public AuteurJson(UserJson user) {
        this.user = user;
    }

    public UserJson getUser() {
        return this.user;
    }

    public void setUser(UserJson user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AuteurJson)) {
            return false;
        }
        AuteurJson auteurJson = (AuteurJson) o;
        return Objects.equals(user, auteurJson.user);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(user);
    }

}