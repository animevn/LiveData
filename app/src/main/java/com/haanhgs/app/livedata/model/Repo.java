package com.haanhgs.app.livedata.model;

import android.content.Context;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import androidx.lifecycle.MutableLiveData;

public class Repo {

    private final ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 8, 60, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>());
    private Score score = new Score();
    private MutableLiveData<Score> liveData = new MutableLiveData<>();
    private Context context;

    public Repo(Context context) {
        this.context = context;
        liveData.setValue(score);
    }

    public MutableLiveData<Score> getLiveData() {
        return liveData;
    }

    public void increaseA(){
        executor.execute(() -> {
            score.increaseA();
            liveData.postValue(score);
        });
    }

    public void decreaseA(){
        executor.execute(() -> {
            score.decreaseA();
            liveData.postValue(score);
        });
    }

    public void increaseB(){
        executor.execute(() -> {
            score.increaseB();
            liveData.postValue(score);
        });
    }

    public void decreaseB(){
        executor.execute(() -> {
            score.decreaseB();
            liveData.postValue(score);
        });
    }

    public void save(){
        executor.execute(() -> Helper.saveSerializable(context, score));
    }

    public void load(){
        executor.execute(() -> {
            score = Helper.loadSerializable(context);
            liveData.postValue(score);
        });
    }











}
