package com.haanhgs.app.livedata.model;

import java.io.Serializable;

public class Score implements Serializable {
    private int scoreA;
    private int scoreB;
    private static final long serialVersionUID = 220479;
    public Score() {
        scoreA = 0;
        scoreB = 0;
    }
    public void increaseA(){
        scoreA++;
    }
    public void increaseB(){
        scoreB++;
    }
    public void decreaseA(){
        if (scoreA > 0){
            scoreA--;
        }else {
            scoreA = 0;
        }
    }
    public void decreaseB(){
        if (scoreB > 0){
            scoreB--;
        }else {
            scoreB = 0;
        }
    }
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
