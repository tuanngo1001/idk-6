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
import android.widget.Button;
import android.widget.TextView;

import idk6.csexperience.R;
import idk6.csexperience.business.AdjustGame;
import idk6.csexperience.objects.Game;

public class JobsFragment extends Fragment {
    private Button bookStore, cafeteria, deliver;
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
        deliver = (Button) view.findViewById(R.id.buttonDelivery);

        // Define on-click listeners for those buttons
        // WARNING: Nasty copy-pasta code below

        // BOOKSTORE
        bookStore.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                //TODO
                if(adjuster.cashier()){
                    showDialog("Well Done!", "Get $17!");
                    goToHome();
                }
                else {
                    showDialog("Status Low!", "Cannot do job now!");
                }
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
                if(adjuster.waiterWaitress()){
                    showDialog("Good Job!", "Get $15!");
                    goToHome();
                }
                else {
                    showDialog("Status Low!", "Cannot do job now!");
                }
                //adjuster.sleep();

                HomeFragment nextFrag = new HomeFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, nextFrag, "HomeFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        // LAB TRIALS
        deliver.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                //TODO
                if(adjuster.delivery()){
                    showDialog("Well Done!", "Get $20!");
                    goToHome();
                }
                else {
                    showDialog("Status Low!", "Cannot do job now!");
                }
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
    private void goToHome(){
        HomeFragment nextFrag = new HomeFragment();      // After sleeping, go to home to see stat changes
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, nextFrag, "HomeFragment")
                .addToBackStack(null)
                .commit();
    }


    private void showDialog(String dialogTitle, String dialogText){
        final Dialog dialog = new Dialog(getActivity());
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
            }
        });

        dialog.show();
    }
}
