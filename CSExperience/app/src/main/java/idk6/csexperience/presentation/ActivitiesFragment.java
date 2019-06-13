package idk6.csexperience.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.zip.Inflater;

import idk6.csexperience.R;
import idk6.csexperience.business.AdjustGame;
import idk6.csexperience.objects.Game;

public class ActivitiesFragment extends Fragment {
    private Button study, sleep, eat, gameItUp, groceryHaul, nightOut, superSleep;
    private Game game;
    private AdjustGame adjuster;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activities,container,false);

        Intent i = getActivity().getIntent();                   // Get the game from the intent
        game = (Game) i.getParcelableExtra("coreGame");

        // Create a new adjuster for changing the game state:
        adjuster = new AdjustGame(game);

        // Define buttons
        study = (Button) view.findViewById(R.id.buttonStudy);
        sleep = (Button) view.findViewById(R.id.buttonSleep);
        eat = (Button) view.findViewById(R.id.buttonEat);
        gameItUp = (Button) view.findViewById(R.id.buttonGame);
        groceryHaul = (Button) view.findViewById(R.id.buttonGroceryHaul);
        nightOut = (Button) view.findViewById(R.id.buttonNightOut);
        superSleep = (Button) view.findViewById(R.id.buttonSuperSleep);

        // Define on-click listeners for those buttons
        // WARNING: Nasty copy-pasta code below

        // STUDY
        study.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                StudyFragment nextFrag = new StudyFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, nextFrag, "StudyFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        // SLEEP
        sleep.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                adjuster.sleep();

                HomeFragment nextFrag = new HomeFragment();      // After sleeping, go to home to see stat changes
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, nextFrag, "HomeFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        // EAT
        eat.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                adjuster.eat();

                HomeFragment nextFrag = new HomeFragment();      // After sleeping, go to home to see stat changes
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, nextFrag, "HomeFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        // GAME IT UP
        gameItUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                adjuster.gameItUp();

                HomeFragment nextFrag = new HomeFragment();      // After sleeping, go to home to see stat changes
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, nextFrag, "HomeFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        // GROCERY HAUL
        groceryHaul.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                adjuster.groceryHaul();

                HomeFragment nextFrag = new HomeFragment();      // After sleeping, go to home to see stat changes
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, nextFrag, "HomeFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        // NIGHT OUT
        nightOut.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                adjuster.nightOut();

                HomeFragment nextFrag = new HomeFragment();      // After sleeping, go to home to see stat changes
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, nextFrag, "HomeFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        // SUPER SLEEP
        superSleep.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                adjuster.superSleep();

                HomeFragment nextFrag = new HomeFragment();      // After sleeping, go to home to see stat changes
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, nextFrag, "HomeFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;

    } // end onCreateView
}
