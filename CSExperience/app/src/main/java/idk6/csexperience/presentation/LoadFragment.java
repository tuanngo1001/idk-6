package idk6.csexperience.presentation;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import idk6.csexperience.R;
import idk6.csexperience.application.Services;
import idk6.csexperience.business.AdjustGame;
import idk6.csexperience.business.GameServices;
import idk6.csexperience.objects.Game;
import idk6.csexperience.persistence.PlayerStatsPersistence;

public class LoadFragment extends Fragment {

    private Game game;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        game = Game.getCoreGame();
        View view = inflater.inflate(R.layout.load_main, container, false);

        System.out.println("Attempting to fetch Players...");
        PlayerStatsPersistence persistence = Services.getPlayerStatsPersistence();
        final List<String> names = persistence.getPlayers();

        TextView slot1 = (TextView) view.findViewById(R.id.titleSlot1);
        TextView slot2 = (TextView) view.findViewById(R.id.titleSlot2);
        TextView slot3 = (TextView) view.findViewById(R.id.titleSlot3);

        System.out.println(names.size());


        //bare bones initial implementation to just get something from the db on screen
        if(names.size() > 0) {
            System.out.println(names.get(0));
            slot1.setText(names.get(0));
        }
        if(names.size() > 1) {
            System.out.println(names.get(1));
            slot2.setText(names.get(1));
        }
        if(names.size() > 2) {
            System.out.println(names.get(2));
            slot3.setText(names.get(2));
        }

        Button load1 = (Button) view.findViewById(R.id.buttonLoad1);
        Button load2 = (Button) view.findViewById(R.id.buttonLoad2);
        Button load3 = (Button) view.findViewById(R.id.buttonLoad3);

        final GameServices gs = new GameServices();

        load1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                if(names.size() > 0) {
                    if(gs.load(names.get(0))) {
                        goToHome();


                        //go to home
                    }
                    else {
                        //error
                    }
                }
                else {
                    //error
                }
            }
        });
        load2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                if(names.size() > 1) {
                    if(gs.load(names.get(1))) {
                        goToHome();

                        //go to home
                    }
                    else {
                        //error
                    }
                }
                else {
                    //error
                }
            }
        });
        load3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                if(names.size() > 2) {
                    if(gs.load(names.get(2))) {
                        goToHome();

                        //go to home
                    }
                    else {
                        //error
                    }
                }
                else {
                    //error
                }
            }
        });

    return view;

    }


    private void goToHome(){

        HomeFragment nextFrag = new HomeFragment();      // After sleeping, go to home to see stat changes
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.relativeLayout5, nextFrag, "HomeFragment")
                .addToBackStack(null)
                .commit();
    }


} // end StudyFragment
