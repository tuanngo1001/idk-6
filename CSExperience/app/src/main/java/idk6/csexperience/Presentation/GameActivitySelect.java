package idk6.csexperience.Presentation;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import idk6.csexperience.R;
import idk6.csexperience.business.Activity;
import idk6.csexperience.objects.Game;

public class GameActivitySelect extends AppCompatActivity {

    private Game game;
    private Activity activities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_select);

        // game = get game object from intent... figure out how to pass objects
        activities = new Activity(game);

        // Create listeners for each button
        Button studyCourse1 = (Button) findViewById(R.id.sleepbutton);
        studyCourse1.setOnClickListener();  // tell it to call onClick

    }
}
