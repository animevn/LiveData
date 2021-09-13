package com.haanhgs.app.livedata.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import com.haanhgs.app.livedata.R;
import com.haanhgs.app.livedata.viewmodel.Model;

public class MainActivity extends AppCompatActivity {

    private Model viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(Model.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.load();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.save();
    }


}
