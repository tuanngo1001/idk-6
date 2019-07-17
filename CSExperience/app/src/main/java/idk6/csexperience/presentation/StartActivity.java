package idk6.csexperience.presentation;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import idk6.csexperience.R;
import idk6.csexperience.application.DatabaseSetupHelper;
import idk6.csexperience.objects.Game;

public class StartActivity extends AppCompatActivity{
    private Game game;
    private static boolean loaded = false;
    private Button start, load, play;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        game = Game.getCoreGame();
        System.out.println("onCREATE");
        System.out.println(game);
        System.out.println("postCREATE");
        setContentView(R.layout.start_main);
        start = findViewById(R.id.buttonStart);
        load = findViewById(R.id.buttonLoad);


        if(!loaded) {
            DatabaseSetupHelper.copyDatabaseToDevice(getApplicationContext());
            loaded = true;
        }

        start.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                setContentView(R.layout.name_main);
                play = findViewById(R.id.buttonPlay);

                play.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onPlayClick(view);
                    }
                });

            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoadClick(view);
            }
        });
    }
    protected void onPlayClick(View view){
        // Get the name that was input by the user
        Game.destoryGame();  // Remake the game whenever we hit play
        game = Game.getCoreGame();
        TextView textElement = (TextView) findViewById(R.id.gameName);

        String playerName = textElement.getText().toString();

        //Only continue if a name has been entered
        if(playerName.length() > 0) {
            game.setPlayerName(playerName);  // and set it as our player's name
            Intent intent = new Intent(this, NavActivity.class);
            startActivity(intent);
        }else{
            final Dialog dialog = new Dialog(view.getContext());
            dialog.setContentView(R.layout.dialog);

            // set the custom dialog components - text, image and button
            TextView title = (TextView) dialog.findViewById(R.id.dialogTitle);
            title.setText("Invalid Name!");

            TextView text = (TextView) dialog.findViewById(R.id.dialogText);
            text.setText("Please enter your name!");

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

            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        }

    }

    protected void onLoadClick(View view){
        Intent intent = new Intent(this, LoadActivity.class);
        startActivity(intent);

    }

    protected void onReturnClick(View view) {
        System.out.println("RETURNCLICK -------------------------------------");
        System.out.println(game.getPlayer().getName());
        System.out.println("NAME");
        setContentView(R.layout.start_main);
    }

}
