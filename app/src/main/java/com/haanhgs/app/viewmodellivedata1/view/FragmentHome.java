package com.haanhgs.app.viewmodellivedata1.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.haanhgs.app.viewmodellivedata1.R;
import com.haanhgs.app.viewmodellivedata1.Repo;
import com.haanhgs.app.viewmodellivedata1.model.Score;
import com.haanhgs.app.viewmodellivedata1.viewmodel.ScoreViewModel;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentHome extends Fragment {

    @BindView(R.id.tvTeamA)
    TextView tvTeamA;
    @BindView(R.id.bnTeamA)
    Button bnTeamA;
    @BindView(R.id.tvTeamB)
    TextView tvTeamB;
    @BindView(R.id.bnTeamB)
    Button bnTeamB;

    private ScoreViewModel model;
    private Score score;
    private FragmentActivity activity;
    private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        activity = getActivity();
    }

    private void handleTextViews(){
        model.getScore().observe(this, score -> {
            tvTeamA.setText(String.valueOf(score.getScoreA()));
            tvTeamB.setText(String.valueOf(score.getScoreB()));
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = ViewModelProviders.of(activity).get(ScoreViewModel.class);
        model.setScore(Repo.load(context));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        handleTextViews();
        return view;
    }

    @OnClick({R.id.bnTeamA, R.id.bnTeamB})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bnTeamA:
                Navigation.findNavController(view)
                        .navigate(R.id.action_fragmentHome_to_fragmentTeamA);
                break;
            case R.id.bnTeamB:
                Navigation.findNavController(view)
                        .navigate(R.id.action_fragmentHome_to_fragmentTeamB);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Repo.save(context, model.getScore().getValue());
    }

}
