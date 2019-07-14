package idk6.csexperience.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import idk6.csexperience.R;
import idk6.csexperience.objects.Game;


public class HomeFragment extends Fragment {
    private Game game;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        game = Game.getCoreGame();
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        energyBar(view);
        happinessBar(view);
        foodBar(view);
        wallet(view);
        name(view);
        changeDay(view);
        examDate(view);
        changeProgress(view);
        arrowAnimation(view);


        // start DB testing button code
//        Button saveStats = (Button) view.findViewById(R.id.saveStats);
//
//        saveStats.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View view) {

//                System.out.println("Attempting to save game...");
//                GameServices gs = new GameServices();
//                gs.save();
//                //PlayerStatsPersistence persistence = Services.getPlayerStatsPersistence();
//                //persistence.insertNewPlayer(game.getPlayer().getName());

//                System.out.println("Attempting to save stats...");
//                PlayerStatsPersistence persistence = Services.getPlayerStatsPersistence();
//                persistence.insertNewPlayer(game.getPlayer().getName());
//
//        // end DB testing code
        return view;
    }

    private void changeDay(View view){
        TextView day = (TextView) view.findViewById(R.id.dayViewCounter);
        day.setText(game.getCalendar().getDay()+"");

        if(game.getCalendar().getDay() > 30){
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


    //TODO maybe this is business logic
    private void examDate(View view){
        int day = game.getCalendar().getDay();

        if(day == 10){
            Intent intent = new Intent(getActivity(), CombatActivity.class);
            startActivity(intent);
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

    private void wallet(View view) {
        TextView money = (TextView) view.findViewById(R.id.coinValue);
        money.setText("$"+game.getPlayer().getStats().getMoney()+".00");
    }

    private void name(View view){
        TextView name = (TextView) view.findViewById(R.id.Greeting);
        String playerName = Game.getCoreGame().getPlayer().getName();
        name.setText( "Hello " + playerName + "!" );
    }

    private void arrowAnimation(View view){
        ImageView arrow = view.findViewById(R.id.arrowImage);

        Animation animation = new AlphaAnimation(1, 0); //to change visibility from visible to invisible
        animation.setDuration(1500);
        animation.setRepeatCount(5);
        animation.setRepeatMode(Animation.REVERSE); //animation will start from end point once ended.
        arrow.startAnimation(animation);
    }
}
