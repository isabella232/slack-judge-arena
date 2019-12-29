package de.qaware.qpi.slack.slackjudgearea.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Action {

    @JsonProperty("action_id")
    private String actionId;

    @JsonProperty("value")
    private String value;

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
