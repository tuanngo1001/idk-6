package idk6.csexperience.presentation;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

import idk6.csexperience.R;
import idk6.csexperience.application.Services;
import idk6.csexperience.business.AdjustGame;
import idk6.csexperience.business.CalendarPersistenceAccessor;
import idk6.csexperience.objects.CalendarEvent;
import idk6.csexperience.objects.Game;


public class HomeFragment extends Fragment {
    private Game game;
    private CalendarPersistenceAccessor calendarData;
    private AdjustGame adjuster;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        game = Game.getCoreGame();
        calendarData = new CalendarPersistenceAccessor(Services.getPlayerExamsPersistence());
        List<CalendarEvent> events = calendarData.getListOfExams();
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        adjuster = new AdjustGame(game);

        energyBar(view);
        happinessBar(view);
        foodBar(view);
        wallet(view);
        name(view);
        changeDay(view);
        examDate(view,events);
        changeProgress(view);
        arrowAnimation(view);

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

        if(game.getCalendar().getPeriod() == 1){
            progress.setText("Afternoon");
        }else {
            progress.setText("Evening");
        }
    }


    private void examDate(View view, List<CalendarEvent> examList){
        Iterator i =  examList.iterator();
        String exam = "";
        int day = game.getCalendar().getDay();
        int period = game.getCalendar().getPeriod();

        while(i.hasNext()) {
            CalendarEvent currentExam = (CalendarEvent) i.next();
            final String examName = getExamType(currentExam);
            final int examDate = currentExam.getExamDate();
            exam = examName;

            if(day == examDate){
                if(period == 1){
                    adjuster.advanceTime();
                    adjuster.advanceTime();
                }else{
                    adjuster.advanceTime();
                }

                Intent intent = new Intent(getActivity(), CombatActivity.class);
                showDialog("Exam time!", exam, intent);

            }
        }
    }

    private String getExamType(CalendarEvent currentExam){
        String examType;

        if( currentExam.checkMid()) {
            examType = currentExam.getExamName() + " Midterm";
        }else
            examType = currentExam.getExamName() + " Final";

        return examType;
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

    private void showDialog(String dialogTitle, String dialogText, Intent intent){
        final Dialog dialog = new Dialog(getActivity());
        final Intent i = intent;
        dialog.setContentView(R.layout.dialog);

        // set the custom dialog components - text, image and button
        TextView title = (TextView) dialog.findViewById(R.id.dialogTitle);
        title.setText(dialogTitle);

        TextView text = (TextView) dialog.findViewById(R.id.dialogText);
        text.setText(dialogText);

        TextView blank = (TextView) dialog.findViewById(R.id.blankDialog);
        blank.setText(" ");

        FloatingActionButton dialogButton = (FloatingActionButton) dialog.findViewById(R.id.closeDialog);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                startActivity(i);
            }
        });

        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }
}
