package idk6.csexperience.presentation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import idk6.csexperience.R;
import idk6.csexperience.objects.Game;


public class CombatActivity extends AppCompatActivity{//} implements View.OnClickListener{
    private Button skill1, skill2, skill3, skill4;
    private FloatingActionButton exitCombat;
    private Game game;

//    @Override
//    public void onClick(View view) {}

    @Nullable
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game = Game.getCoreGame();
        setContentView(R.layout.combat);

        skill1 = (Button) findViewById(R.id.buttonSkill1);
        skill2 = (Button) findViewById(R.id.buttonSkill2);
        skill3 = (Button) findViewById(R.id.buttonSkill3);
        skill4 = (Button) findViewById(R.id.buttonSkill4);
        exitCombat = (FloatingActionButton) findViewById(R.id.exitCombatButton);

        energyBarCombat();
        happinessBarCombat();
        foodBarCombat();
        examAnimation();

        skill1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                refreshScreen();
            }
        });

        skill2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                refreshScreen();
            }
        });

        skill3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                refreshScreen();
            }
        });

        skill4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

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
        ProgressBar progressTime = (ProgressBar) findViewById(R.id.progressBarTime);
        progressTime.setProgress(game.getPlayer().getStats().getEnergy());
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

//    private void showDialog(View view){
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        TextView title = new TextView(this);
//        title.setText("Exit Combat?");
//        title.setTextColor(getColor(R.color.colorWhite));
//
//        builder.setTitle(title.getText());
//        builder.setMessage("You will receive an F");
//
//        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
//
//            public void onClick(DialogInterface dialog, int which) {
//                // Do do my action here
//
//                dialog.dismiss();
//            }
//
//        });
//
//        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                // I do not need any action here you might
//                dialog.dismiss();
//            }
//        });
//
//        AlertDialog alert = builder.create();
//        alert.getWindow().setBackgroundDrawableResource(R.drawable.dialog_background);
//        alert.show();
//    }



}
