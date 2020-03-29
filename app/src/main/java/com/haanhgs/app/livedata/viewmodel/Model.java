package com.haanhgs.app.livedata.viewmodel;

import android.app.Application;
import com.haanhgs.app.livedata.model.Repo;
import com.haanhgs.app.livedata.model.Score;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class Model extends AndroidViewModel {

    private Repo repo;

    public Model(@NonNull Application application) {
        super(application);
        repo = new Repo(application.getApplicationContext());
    }


    public LiveData<Score> getData(){
        return repo.getLiveData();
    }

    public void increaseA(){
        repo.increaseA();
    }

    public void decreaseA(){
        repo.decreaseA();
    }

    public void increaseB(){
        repo.increaseB();
    }

    public void decreaseB(){
        repo.decreaseB();
    }

    public void save(){
        repo.save();
    }

    public void load(){
        repo.load();
    }
}
