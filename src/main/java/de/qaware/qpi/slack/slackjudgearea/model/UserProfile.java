package de.qaware.qpi.slack.slackjudgearea.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserProfile {

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("image_32")
    private String image;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("displayName", displayName)
                .append("image", image)
                .toString();
    }
}
