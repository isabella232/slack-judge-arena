package de.qaware.qpi.slack.slackjudgearea.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Block {

    private String type;

    @JsonProperty("block_id")
    private String blockId;

    private Element[] elements;

    private Text text;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public Element[] getElements() {
        return elements;
    }

    public void setElements(Element[] elements) {
        this.elements = elements;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }
}
