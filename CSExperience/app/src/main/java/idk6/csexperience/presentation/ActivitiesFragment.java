package idk6.csexperience.presentation;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

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

        game = Game.getCoreGame();

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

        // STUDY
        study.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new StudyFragment()).commit();
            }
        });

        // SLEEP
        sleep.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                adjuster.sleep();
                showDialog("Energy Increased!", "I'm not tired anymore!",true);
            }
        });

        // EAT
        eat.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                adjuster.eat();
                showDialog("Food Increased!", "That was delicious!",true);
            }
        });

        // GAME IT UP
        gameItUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                adjuster.gameItUp();
                showDialog("Happiness Increased!", "Too bad I can't do this all day.",true);
            }
        });

        // GROCERY HAUL
        groceryHaul.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                adjuster.groceryHaul();
                showDialog("Food Increased!", "Full stock! But I should rest now.",true);
            }
        });

        // NIGHT OUT
        nightOut.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                adjuster.nightOut();
                showDialog("Happiness Increased!", "That was fun! But I am very tired.",true);
            }
        });

        // SUPER SLEEP
        superSleep.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                adjuster.superSleep();
                showDialog("Energy Increased!", "I slept a whole day? I should eat something.",true);
            }
        });

        return view;

    } // end onCreateView

    private void showDialog(String dialogTitle, String dialogText, boolean home){
        final Dialog dialog = new Dialog(getActivity());
        final boolean goHome = home;
        dialog.setContentView(R.layout.dialog);

        // set the custom dialog components - text, image and button
        TextView title = (TextView) dialog.findViewById(R.id.dialogTitle);
        title.setText(dialogTitle);

        TextView text = (TextView) dialog.findViewById(R.id.dialogText);
        text.setText(dialogText);

        TextView blank = (TextView) dialog.findViewById(R.id.blankDialog);
        blank.setText(" ");

        FloatingActionButton dialogButton = (FloatingActionButton) dialog.findViewById(R.id.closeDialog);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

                if(goHome) {
                    HomeFragment nextFrag = new HomeFragment();      // After sleeping, go to home to see stat changes
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, nextFrag, "HomeFragment")
                            .addToBackStack(null)
                            .commit();
                }
            }
        });

        dialog.show();
    }
}
