package fr.alteca.dashboard.model.json;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserJson {
    private String nickname;

    public UserJson() {
    }

    public UserJson(String username) {
        this.nickname = username;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserJson)) {
            return false;
        }
        UserJson userJson = (UserJson) o;
        return Objects.equals(nickname, userJson.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nickname);
    }

}