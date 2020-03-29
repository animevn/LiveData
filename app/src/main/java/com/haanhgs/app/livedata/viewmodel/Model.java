package com.haanhgs.app.livedata.viewmodel;

import com.haanhgs.app.livedata.model.Score;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Model extends ViewModel {

    private MutableLiveData<Score> score = new MutableLiveData<>();

    public Model() {
        score.setValue(new Score());
    }

    public MutableLiveData<Score> getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score.setValue(score);
    }

    public void increaseA(){
        if (score.getValue() == null){
            score.setValue(new Score());
        }else {
            score.getValue().increaseA();
            score.setValue(score.getValue());
        }
    }

    public void increaseB(){
        if (score.getValue() == null){
            score.setValue(new Score());
        }else {
            score.getValue().increaseB();
            score.setValue(score.getValue());
        }
    }

    public void decreaseA(){
        if (score.getValue() == null){
            score.setValue(new Score());
        }else {
            score.getValue().decreaseA();
            score.setValue(score.getValue());
        }
    }

    public void decreaseB(){
        if (score.getValue() == null){
            score.setValue(new Score());
        }else {
            score.getValue().decreaseB();
            score.setValue(score.getValue());
        }
    }
}