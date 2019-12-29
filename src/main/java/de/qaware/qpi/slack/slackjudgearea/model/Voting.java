package de.qaware.qpi.slack.slackjudgearea.model;

import de.qaware.qpi.slack.slackjudgearea.model.Context;

public class Voting {

    private String title;
    private Context answer0;
    private Context answer1;
    private Context answer2;
    private Context answer3;
    private Context answer4;
    private Context answer5;
    private Context answer6;

    public Voting(String title, Context answer0, Context answer1, Context answer2, Context answer3, Context answer4, Context answer5, Context answer6) {
        this.title = title;
        this.answer0 = answer0;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.answer5 = answer5;
        this.answer6 = answer6;
    }

    public String getTitle() {
        return title;
    }

    public Context getAnswer0() {
        return answer0;
    }

    public Context getAnswer1() {
        return answer1;
    }

    public Context getAnswer2() {
        return answer2;
    }

    public Context getAnswer3() {
        return answer3;
    }

    public Context getAnswer4() {
        return answer4;
    }

    public Context getAnswer5() {
        return answer5;
    }

    public Context getAnswer6() {
        return answer6;
    }
}
