package com.haanhgs.app.viewmodellivedata1.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.haanhgs.app.viewmodellivedata1.R;
import com.haanhgs.app.viewmodellivedata1.viewmodel.ScoreViewModel;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentTeamB extends Fragment {

    @BindView(R.id.tvPointB)
    TextView tvPointB;
    @BindView(R.id.bnIncreaseB)
    Button bnIncreaseB;
    @BindView(R.id.bnDecreaseB)
    Button bnDecreaseB;

    private ScoreViewModel model;
    private FragmentActivity activity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = getActivity();
    }

    private void handleTextView() {
        model.getScore().observe(this, score
                -> tvPointB.setText(String.valueOf(score.getScoreB())));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team_b, container, false);
        ButterKnife.bind(this, view);
        model = ViewModelProviders.of(activity).get(ScoreViewModel.class);
        handleTextView();
        return view;
    }

    @OnClick({R.id.bnIncreaseB, R.id.bnDecreaseB})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bnIncreaseB:
                model.increaseScoreB();
                break;
            case R.id.bnDecreaseB:
                model.decreaseScoreB();
                break;
        }
    }
}
