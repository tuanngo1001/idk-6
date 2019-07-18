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

public class StoreFragment extends Fragment {
    private Button coffee, beer, chegg, snack, energyDrink;
    private Game game;
    private AdjustGame adjuster;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_items,container,false);

        game = Game.getCoreGame();

        // Create a new adjuster for changing the game state:
        adjuster = new AdjustGame(game);

        // Define buttons
        coffee = (Button) view.findViewById(R.id.buttonCoffee);
        beer = (Button) view.findViewById(R.id.buttonBeer);
        chegg = (Button) view.findViewById(R.id.buttonChegg);
        snack = (Button) view.findViewById(R.id.buttonSnacks);
        energyDrink = (Button) view.findViewById(R.id.buttonEnergyDrink);

        // Define on-click listeners for those buttons
        // WARNING: Nasty copy-pasta code below

        // COFFEE
        coffee.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                String[] result = adjuster.buyCoffee();
                showDialog(result[0], result[1], true);

            }
        });

        // BEER
        beer.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                String[] result = adjuster.buyBeer();
                showDialog(result[0], result[1], true);

            }
        });

        // CHEGG
        chegg.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                String[] result = adjuster.useChegg();
                showDialog(result[0], result[1], false);
                if(result[0] != "Insufficent Funds!") {
                    StudyFragment nextFrag = new StudyFragment(true);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, nextFrag, "StudyFragment")
                            .addToBackStack(null)
                            .commit();
                }
            }

        });

        // SNACK
        snack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                String[] result = adjuster.buySnack();
                showDialog(result[0], result[1], true);

            }
        });

        // Energy Drink
        energyDrink.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                String[] result = adjuster.buyEnergyDrink();
                showDialog(result[0], result[1], true);

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

        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }
}
