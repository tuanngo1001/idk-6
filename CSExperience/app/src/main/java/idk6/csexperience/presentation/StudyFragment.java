package idk6.csexperience.presentation;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;

import idk6.csexperience.R;
import idk6.csexperience.business.AdjustGame;
import idk6.csexperience.objects.Game;

public class StudyFragment extends Fragment {

    private Game game;
    private AdjustGame adjuster;
    private Button studyDB, studyAI, studyGraphics;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intent i = getActivity().getIntent();
        game = (Game) i.getParcelableExtra("coreGame");
        adjuster = new AdjustGame(game);
        View view = inflater.inflate(R.layout.fragment_study_courses, container, false);

        // Update the view with the player's current knowledge
        databasesRating(view);
        aiRating(view);
        graphicsRating(view);

        // Register the study buttons
        studyDB = (Button) view.findViewById(R.id.studyDB);
        studyAI = (Button) view.findViewById(R.id.studyAI);
        studyGraphics = (Button) view.findViewById(R.id.studyGraphics);

        // STUDY DATABASES
        studyDB.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                adjuster.studyDB();
                HomeFragment nextFrag = new HomeFragment();      // After sleeping, go to home to see stat changes
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, nextFrag, "HomeFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        // STUDY ARTIFICIAL INTELLIGENCE
        studyAI.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                adjuster.studyAI();
                HomeFragment nextFrag = new HomeFragment();      // After sleeping, go to home to see stat changes
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, nextFrag, "HomeFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });


        // STUDY GRAPHICS
        studyGraphics.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                adjuster.studyGraphics();
                HomeFragment nextFrag = new HomeFragment();      // After sleeping, go to home to see stat changes
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, nextFrag, "HomeFragment")
                        .addToBackStack(null)
                        .commit();
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


} // end StudyFragment
