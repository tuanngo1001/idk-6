package idk6.csexperience.presentation;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import idk6.csexperience.R;
import idk6.csexperience.business.Combat;
import idk6.csexperience.objects.Game;


public class CombatActivity extends AppCompatActivity{
    //} implements View.OnClickListener{
    private Button skill1, skill2, skill3, skill4;
    private FloatingActionButton exitCombat;
    private Combat adjuster;
    private Game game;
    private ProgressBar timer;
    public int cID = 0;

//    @Nullable
//    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game = Game.getCoreGame();
        if (cID == 2){
            cID = 0;
        }
        adjuster = new Combat(cID++);
        adjuster.getUsableSkill();

        setContentView(R.layout.combat);

        skill1 = (Button) findViewById(R.id.buttonSkill1);
        skill2 = (Button) findViewById(R.id.buttonSkill2);
        skill3 = (Button) findViewById(R.id.buttonSkill3);
        timer = (ProgressBar) findViewById(R.id.progressBarTime);

        energyBarCombat();
        happinessBarCombat();
        foodBarCombat();
        examAnimation();

        skill1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                adjuster.useSkill(0);
                refreshScreen();
            }
        });

        skill2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                adjuster.useSkill(1);
                refreshScreen();
            }
        });

        skill3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                adjuster.useSkill(2);
                refreshScreen();
            }
        });


//        exitCombat.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View view) {
//
//                showDialog(view);
//            }
//        });
    }

    public void onExitCombatClick(View view){
        refreshScreen();
    }


    private void timeBar(){
        ProgressBar timer = (ProgressBar) findViewById(R.id.progressBarTime);
        //timer.setProgress(game.timer...);
    }


    private void energyBarCombat(){
        ProgressBar progressEnergy = (ProgressBar) findViewById(R.id.progressBarEnergyCombat);
        progressEnergy.setProgress(game.getPlayer().getStats().getEnergy());
    }

    private void happinessBarCombat(){
        ProgressBar progressEnergy = (ProgressBar) findViewById(R.id.progressBarHappinessCombat);
        progressEnergy.setProgress(game.getPlayer().getStats().getHappiness());
    }

    private void foodBarCombat(){
        ProgressBar progressEnergy = (ProgressBar) findViewById(R.id.progressBarfoodCombat);
        progressEnergy.setProgress(game.getPlayer().getStats().getFood());
    }

    private void examAnimation(){
        ImageView exam = findViewById(R.id.examImage);

        Animation animation = new AlphaAnimation(1, 0); //to change visibility from visible to invisible
        animation.setDuration(1000);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE); //animation will start from end point once ended.
        exam.startAnimation(animation);

    }

    private void refreshScreen(){
        Intent intent = new Intent(this, CombatActivity.class);
        startActivity(intent);
    }

    private void showDialog(String dialogTitle, String dialogText){
        final Dialog dialog = new Dialog(getApplicationContext());
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
            }
        });

        dialog.show();
    }



}
