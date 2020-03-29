package com.haanhgs.app.livedata.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.haanhgs.app.livedata.R;
import com.haanhgs.app.livedata.viewmodel.Model;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentTeamA extends Fragment {

    @BindView(R.id.tvPointA)
    TextView tvPointA;
    @BindView(R.id.bnIncreaseA)
    Button bnIncreaseA;
    @BindView(R.id.bnDecreaseA)
    Button bnDecreaseA;

    private Model viewModel;
    private FragmentActivity activity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = getActivity();
    }

    private void handleData() {
        viewModel = new ViewModelProvider(activity).get(Model.class);
        viewModel.getScore().observe(this, score ->
                tvPointA.setText(String.valueOf(score.getScoreA())));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team_a, container, false);
        ButterKnife.bind(this, view);
        handleData();
        return view;
    }

    @OnClick({R.id.bnIncreaseA, R.id.bnDecreaseA})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bnIncreaseA:
                viewModel.increaseA();
                break;
            case R.id.bnDecreaseA:
                viewModel.decreaseA();
                break;
        }
    }
}
