package de.qaware.qpi.slack.slackjudgearea.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Payload {

    private String token;

    private User user;

    @JsonProperty("response_url")
    private String responseUrl;

    private Action[] actions;

    private Message message;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Action[] getActions() {
        return actions;
    }

    public void setActions(Action[] actions) {
        this.actions = actions;
    }

    public String getResponseUrl() {
        return responseUrl;
    }

    public void setResponseUrl(String responseUrl) {
        this.responseUrl = responseUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
