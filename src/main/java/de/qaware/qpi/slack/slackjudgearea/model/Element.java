package de.qaware.qpi.slack.slackjudgearea.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Element {

    private String type;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("alt_text")
    private String altText;

    public Element(String type, String imageUrl, String altText) {
        this.type = type;
        this.imageUrl = imageUrl;
        this.altText = altText;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }
}
