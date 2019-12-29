package de.qaware.qpi.slack.slackjudgearea.model;

public class Message {

    private String type;
    private Block[] blocks;

    public Block[] getBlocks() {
        return blocks;
    }

    public void setBlocks(Block[] blocks) {
        this.blocks = blocks;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
