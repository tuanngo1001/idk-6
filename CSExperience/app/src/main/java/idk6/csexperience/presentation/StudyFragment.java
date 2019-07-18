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
import android.widget.RatingBar;
import android.widget.TextView;

import idk6.csexperience.R;
import idk6.csexperience.business.AdjustGame;
import idk6.csexperience.objects.Game;

public class StudyFragment extends Fragment {

    private Game game;
    private AdjustGame adjuster;
    private Button studyDB, studyAI, studyGraphics;
    // this chegg variable alters this page to be of use in a chegg purchase, in addition to studying
    private boolean chegg;

    public StudyFragment(){
        chegg = false;
    }
    public StudyFragment(boolean isChegg){
        chegg = isChegg;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        game = Game.getCoreGame();
        View view = inflater.inflate(R.layout.fragment_study_courses, container, false);

        adjuster = new AdjustGame(game);


        // Update the view with the player's current knowledge
        databasesRating(view);
        aiRating(view);
        graphicsRating(view);

        // Register the study buttons
        studyDB = (Button) view.findViewById(R.id.studyDB);
        studyAI = (Button) view.findViewById(R.id.studyAI);
        studyGraphics = (Button) view.findViewById(R.id.studyGraphics);

        if (chegg) {
            TextView welcomeText = (TextView) view.findViewById(R.id.selectCourseView);
            welcomeText.setText("Get Ahead");
        }
        // STUDY DATABASES
        studyDB.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                if(chegg){
                    adjuster.cheggDB();
                }
                else {
                    adjuster.studyDB();
                }

                showDialog("Database Knowledge Increased!", "I'm level " + game.getPlayer().getStats().getDatabasesKnowledge() + " now!",true);
            }
        });

        // STUDY ARTIFICIAL INTELLIGENCE
        studyAI.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                if(chegg) {
                    adjuster.cheggAI();
                }
                else {
                    adjuster.studyAI();
                }
                showDialog("AI Knowledge Increased!", "I'm level " + game.getPlayer().getStats().getAiKnowledge() + " now!",true);
            }
        });


        // STUDY GRAPHICS
        studyGraphics.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                if(chegg){
                    adjuster.cheggGraphics();
                }
                else {
                    adjuster.studyGraphics();
                }
                showDialog("Graphics Knowledge Increased!", "I'm level " + game.getPlayer().getStats().getGraphicsKnowledge() + " now!",true);
            }
        });

        return  view;
    }


    // The following methods are used to update the star ratings for each course in the view

    private void databasesRating(View view){
        RatingBar ratingDatabases = (RatingBar) view.findViewById(R.id.dbRatingBar);
        ratingDatabases.setNumStars(10);
        ratingDatabases.setRating(game.getPlayer().getStats().getDatabasesKnowledge());
    }

    private void aiRating(View view){
        RatingBar ratingAi = (RatingBar) view.findViewById(R.id.aiRatingBar);
        ratingAi.setNumStars(10);   // This was needed to get the right stepSize for the stars
        ratingAi.setRating(game.getPlayer().getStats().getAiKnowledge());
    }

    private void graphicsRating(View view){
        RatingBar ratingGraphics = (RatingBar) view.findViewById(R.id.graphicsRatingBar);
        ratingGraphics.setNumStars(10);
        ratingGraphics.setRating(game.getPlayer().getStats().getGraphicsKnowledge());
    }

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

} // end StudyFragment
