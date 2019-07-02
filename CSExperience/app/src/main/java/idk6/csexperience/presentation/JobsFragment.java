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

import idk6.csexperience.R;
import idk6.csexperience.business.AdjustGame;
import idk6.csexperience.objects.Game;

public class JobsFragment extends Fragment {
    private Button bookStore, cafeteria, labTrials;
    private Game game;
    private AdjustGame adjuster;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jobs,container,false);

        game = Game.getCoreGame();

        // Create a new adjuster for changing the game state:
        adjuster = new AdjustGame(game);

        // Define buttons
        bookStore = (Button) view.findViewById(R.id.buttonBookStore);
        cafeteria = (Button) view.findViewById(R.id.buttonCafeteria);
        labTrials = (Button) view.findViewById(R.id.buttonLabTrials);

        // Define on-click listeners for those buttons
        // WARNING: Nasty copy-pasta code below

        // BOOKSTORE
        bookStore.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                //TODO
                //adjuster.sleep();

                HomeFragment nextFrag = new HomeFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, nextFrag, "HomeFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        // CAFETERIA
        cafeteria.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                //TODO
                //adjuster.sleep();

                HomeFragment nextFrag = new HomeFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, nextFrag, "HomeFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        // LAB TRIALS
        labTrials.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                //TODO
                //adjuster.sleep();

                HomeFragment nextFrag = new HomeFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, nextFrag, "HomeFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;

    } // end onCreateView
}
