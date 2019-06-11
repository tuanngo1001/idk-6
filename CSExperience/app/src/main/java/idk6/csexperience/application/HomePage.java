package idk6.csexperience.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import idk6.csexperience.business.AdjustGame;

import idk6.csexperience.R;
import idk6.csexperience.business.AdjustPlayerStats;
import idk6.csexperience.objects.Game;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        String name = "Bob Ross";
        if(getIntent().hasExtra("name")) {

            name = getIntent().getExtras().getString("name");
        }

        final Game ourGame = new Game(name);

        this.updateText(ourGame);

        final AdjustGame adjustGame = new AdjustGame(ourGame);

        Button advanceButton = (Button) findViewById(R.id.advanceBtn);
        advanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adjustGame.advanceTime();
                updateText(ourGame);
            }
        });

        Button eatButton = (Button) findViewById(R.id.eatBtn);
        eatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adjustGame.eat();
                updateText(ourGame);
            }
        });

        }

        private void updateText(Game ourGame) {
            TextView nameDisplay = (TextView)findViewById(R.id.nameDisplay);
            TextView hungerDisplay = (TextView)findViewById(R.id.hungerDisplay);
            TextView energyDisplay = (TextView)findViewById(R.id.energyDisplay);
            TextView happinessDisplay = (TextView)findViewById(R.id.happinessDisplay);
            TextView dayDisplay = (TextView) findViewById(R.id.dayDisplay);
            TextView periodDisplay = (TextView) findViewById(R.id.periodDisplay);

            nameDisplay.setText("Hello "+ ourGame.getPlayer().getName());

            hungerDisplay.setText("Hunger lvl: "+ourGame.getPlayer().getStats().getHunger());
            energyDisplay.setText("Energy lvl: "+ourGame.getPlayer().getStats().getEnergy());
            happinessDisplay.setText("Happiness lvl: "+ourGame.getPlayer().getStats().getHappiness());

            dayDisplay.setText("Day: "+ourGame.getTime().getDay());
            periodDisplay.setText("Period: "+ourGame.getTime().getPeriod());

        }
}
