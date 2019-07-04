package idk6.csexperience.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import idk6.csexperience.R;
import idk6.csexperience.application.DatabaseSetupHelper;
import idk6.csexperience.objects.Game;

public class StartActivity extends AppCompatActivity{
    private Game game;
    private static boolean loaded = false;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game = Game.getCoreGame();
        System.out.println("onCREATE");
        System.out.println(game);
        System.out.println("postCREATE");
        setContentView(R.layout.start_main);
        if(!loaded) {
            DatabaseSetupHelper.copyDatabaseToDevice(getApplicationContext());
            loaded = true;
        }
    }

    protected void onStartClick(View view){
        setContentView(R.layout.name_main);
    }

    protected void onPlayClick(View view){
        // Get the name that was input by the user
        TextView textElement = (TextView) findViewById(R.id.gameName);

        String playerName = textElement.getText().toString();

        //Only continue if a name has been entered
        if(playerName.length() > 0) {
            game.setPlayerName(playerName);  // and set it as our player's name
            Intent intent = new Intent(this, NavActivity.class);
            startActivity(intent);
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
