package idk6.csexperience.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;


import idk6.csexperience.R;
import idk6.csexperience.objects.Game;

public class HomeFragment extends Fragment {
    private Game game;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intent i = getActivity().getIntent();
        game = (Game) i.getParcelableExtra("coreGame");
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        energyBar(view);
        happinessBar(view);
        foodBar(view);

        changeDay(view);
        changeProgress(view);

        return view;
    }

    private void changeDay(View view){
        TextView day = (TextView) view.findViewById(R.id.dayViewCounter);
        day.setText(game.getCalendar().getDay()+"");

        if(game.getCalendar().getDay() >= 30){
            EndGameFragment nextFrag = new EndGameFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, nextFrag, "EndGameFragment")
                    .addToBackStack(null)
                    .commit();
        }

    }

    private void changeProgress(View view){
        TextView progress = (TextView) view.findViewById(R.id.periodViewCounter);
        int checkProgress;

        checkProgress = game.getCalendar().getPeriod();

        if(checkProgress == 1){
            progress.setText("Afternoon");
        }else {
            progress.setText("Evening");
        }
    }

    private void energyBar(View view){
        ProgressBar progressEnergy = (ProgressBar) view.findViewById(R.id.progressBarEnergy);
        progressEnergy.setProgress(game.getPlayer().getStats().getEnergy());
    }

    private void happinessBar(View view){
        ProgressBar progressEnergy = (ProgressBar) view.findViewById(R.id.progressBarHappiness);
        progressEnergy.setProgress(game.getPlayer().getStats().getHappiness());
    }

    private void foodBar(View view){
        ProgressBar progressEnergy = (ProgressBar) view.findViewById(R.id.progressBarfood);
        progressEnergy.setProgress(game.getPlayer().getStats().getFood());
    }
}
