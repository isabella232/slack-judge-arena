package de.qaware.qpi.slack.slackjudgearea.model;

public class UserProfileResponse {

    private String ok;

    private UserProfile profile;

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }
}
