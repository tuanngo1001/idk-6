package idk6.csexperience.presentation;

import android.app.Dialog;
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
    private Button bookStore, cafeteria, delivery;
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
        delivery = (Button) view.findViewById(R.id.buttonDelivery);

        // Define on-click listeners for those buttons
        // WARNING: Nasty copy-pasta code below

        // CAFETERIA
        cafeteria.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                //TODO
                if(adjuster.doServer()){
                    showDialog("Hard work pays off!", "$15 Profit!",true);
                }
                else {
                    showDialog("Low Energy!", "Can't work now!",true);
                }
            }
        });

        // BOOKSTORE
        bookStore.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                //TODO
                if(adjuster.doCashier()){
                    showDialog("Hard work pays off!", "$17 Profit!",true);
                }
                else {
                    showDialog("Low Energy!", "Can't work now!",true);
                }
            }
        });

        // DELIVERY
        delivery.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                //TODO
                if(adjuster.doDelivery()){
                    showDialog("Hard work pays off!", "$20 Profit!",true);
                }
                else {
                    showDialog("Low Energy!", "Can't work now!",true);
                }
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
