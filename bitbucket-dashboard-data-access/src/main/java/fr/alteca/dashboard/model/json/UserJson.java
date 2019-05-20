package fr.alteca.dashboard.model.json;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserJson {
    private String username;

    public UserJson() {
    }

    public UserJson(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserJson)) {
            return false;
        }
        UserJson userJson = (UserJson) o;
        return Objects.equals(username, userJson.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }

}