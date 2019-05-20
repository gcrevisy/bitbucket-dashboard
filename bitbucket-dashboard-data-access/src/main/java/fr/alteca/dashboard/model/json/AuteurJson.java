package fr.alteca.dashboard.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuteurJson {

    private UserJson user;

    public UserJson getUser() {
        return this.user;
    }

    public void setUser(UserJson user) {
        this.user = user;
    }

}