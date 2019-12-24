package com.haanhgs.app.viewmodellivedata1.viewmodel;

import com.haanhgs.app.viewmodellivedata1.model.Score;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ScoreViewModel extends ViewModel {

    private MutableLiveData<Score> score = new MutableLiveData<>();

    public MutableLiveData<Score> getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score.setValue(score);
    }

    public void increaseScoreA(){
        if (score.getValue() == null){
            score.setValue(new Score());
        }else {
            score.getValue().setScoreA(score.getValue().getScoreA() + 1);
            score.setValue(score.getValue());
        }
    }

    public void increaseScoreB(){
        if (score.getValue() == null){
            score.setValue(new Score());
        }else {
            score.getValue().setScoreB(score.getValue().getScoreB() + 1);
            score.setValue(score.getValue());
        }
    }

    public void decreaseScoreA(){
        if (score.getValue() == null){
            score.setValue(new Score());
        }else if (score.getValue().getScoreA() > 0){
            score.getValue().setScoreA(score.getValue().getScoreA() - 1);
            score.setValue(score.getValue());
        }else {
            score.getValue().setScoreA(0);
            score.setValue(score.getValue());
        }
    }

    public void decreaseScoreB(){
        if (score.getValue() == null){
            score.setValue(new Score());
        }else if (score.getValue().getScoreB() > 0){
            score.getValue().setScoreB(score.getValue().getScoreB() - 1);
            score.setValue(score.getValue());
        }else {
            score.getValue().setScoreB(0);
            score.setValue(score.getValue());
        }
    }
}
