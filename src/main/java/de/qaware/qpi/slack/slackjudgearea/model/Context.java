package de.qaware.qpi.slack.slackjudgearea.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Context {

    public static final Context EMPTY = new Context();

    private List<Element> elements;

    public Context() {
        this.elements = new ArrayList<>();
    }

    public Element[] getElements() {
        return elements.toArray(new Element[elements.size()]);
    }

    public void setElements(Element[] elements) {
        this.elements = Arrays.asList(elements);
    }

    public void addElement(Element element) {
        this.elements.add(element);
    }
}
