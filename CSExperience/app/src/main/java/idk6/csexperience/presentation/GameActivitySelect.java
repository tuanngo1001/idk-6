package idk6.csexperience.presentation;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import idk6.csexperience.R;
import idk6.csexperience.business.AdjustGame;
import idk6.csexperience.objects.Game;

public class GameActivitySelect extends AppCompatActivity {

    private Game game;
    private AdjustGame adjuster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_select);

    }
}
