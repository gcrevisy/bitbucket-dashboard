package fr.alteca.dashboard.model.json.pullrequest;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PullRequestAuteurJson {

    private String nickname;

    public PullRequestAuteurJson() {
    }

    public PullRequestAuteurJson(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public PullRequestAuteurJson nickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PullRequestAuteurJson)) {
            return false;
        }
        PullRequestAuteurJson pullRequestAuteurJson = (PullRequestAuteurJson) o;
        return Objects.equals(nickname, pullRequestAuteurJson.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nickname);
    }

    @Override
    public String toString() {
        return "{" + " nickname='" + getNickname() + "'" + "}";
    }

}