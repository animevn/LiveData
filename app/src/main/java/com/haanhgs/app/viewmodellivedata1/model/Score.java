package com.haanhgs.app.viewmodellivedata1.model;

import java.io.Serializable;

public class Score implements Serializable {

    private int scoreA;
    private int scoreB;
    private static final long serialUID = 220479;

    public Score() { }

    public Score(int scoreA, int scoreB) {
        this.scoreA = scoreA;
        this.scoreB = scoreB;
    }

    public int getScoreA() {
        return scoreA;
    }

    public void setScoreA(int scoreA) {
        this.scoreA = scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }

    public void setScoreB(int scoreB) {
        this.scoreB = scoreB;
    }
}
