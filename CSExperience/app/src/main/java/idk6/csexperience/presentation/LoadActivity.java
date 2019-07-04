package idk6.csexperience.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import idk6.csexperience.R;
import idk6.csexperience.application.Services;
import idk6.csexperience.business.GameServices;
import idk6.csexperience.objects.Game;
import idk6.csexperience.persistence.PlayerStatsPersistence;

public class LoadActivity extends AppCompatActivity {
    final private int SLOT1 = 0;
    final private int SLOT2 = 1;
    final private int SLOT3 = 2;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_main);

        System.out.println("Attempting to fetch Players...");
        PlayerStatsPersistence persistence = Services.getPlayerStatsPersistence();
        final List<String> names = persistence.getPlayers();

        TextView slot1 = (TextView) findViewById(R.id.titleSlot1);
        TextView slot2 = (TextView) findViewById(R.id.titleSlot2);
        TextView slot3 = (TextView) findViewById(R.id.titleSlot3);

        // Set slot names (only use the last 3 to appear in the db)
        if(names.size() > 0) {
            slot1.setText(names.get(0));
        }
        if(names.size() > 1) {
            slot2.setText(names.get(1));
        }
        if(names.size() > 2) {
            slot3.setText(names.get(2));
        }

//        System.out.println(names.size());
//        System.out.println(names.get(SLOT1));
//        System.out.println(names.get(SLOT2));
//        System.out.println(names.get(SLOT3));

        //bare bones initial implementation to just get something from the db on screen
        if(names.size() > SLOT1) {
            System.out.println(names.get(SLOT1));
            slot1.setText(names.get(SLOT1));
        }
        if(names.size() > SLOT2) {
            System.out.println(names.get(SLOT2));
            slot2.setText(names.get(SLOT2));
        }
        if(names.size() > SLOT3) {
            System.out.println(names.get(SLOT3));
            slot3.setText(names.get(SLOT3));
        }

        Button load1 = (Button) findViewById(R.id.buttonLoad1);
        Button load2 = (Button) findViewById(R.id.buttonLoad2);
        Button load3 = (Button) findViewById(R.id.buttonLoad3);

        final GameServices gs = new GameServices();

        load1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                getKey(names.size(), SLOT1, gs, names.get(SLOT1));
            }
        });
        load2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                getKey(names.size(), SLOT2, gs, names.get(SLOT2));
            }
        });
        load3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                getKey(names.size(), SLOT3, gs, names.get(SLOT3));
            }
        });
    }


    protected void onReturnClick(View view) {
        Intent newIntent = new Intent(getBaseContext(), StartActivity.class);
        startActivity(newIntent);
    }

    private void getKey(int listSize, int size, GameServices gs, String names){
        if(listSize > size) {
            if(gs.load(names)) {
                Intent newIntent = new Intent(getBaseContext(), NavActivity.class);
                startActivity(newIntent);
            }
            else {
                //error
            }
        }
        else {
            //error
        }
    }

}
