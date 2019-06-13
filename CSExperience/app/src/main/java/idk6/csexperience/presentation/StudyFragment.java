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
import android.widget.RatingBar;

import idk6.csexperience.R;
import idk6.csexperience.business.AdjustGame;
import idk6.csexperience.objects.Game;

public class StudyFragment extends Fragment {

    private Game game;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intent i = getActivity().getIntent();
        game = (Game) i.getParcelableExtra("coreGame");
        View view = inflater.inflate(R.layout.fragment_study_courses, container, false);

        databasesRating(view);
        aiRating(view);
        graphicsRating(view);

        return  view;
    }

    private void databasesRating(View view){
        RatingBar ratingDatabases = (RatingBar) view.findViewById(R.id.dbRatingBar);
        ratingDatabases.setNumStars(10);
        ratingDatabases.setRating(game.getPlayer().getStats().getDatabasesKnowledge());
    }

    private void aiRating(View view){
        RatingBar ratingAi = (RatingBar) view.findViewById(R.id.aiRatingBar);
        ratingAi.setNumStars(10);
        ratingAi.setRating(game.getPlayer().getStats().getAiKnowledge());
    }

    private void graphicsRating(View view){
        RatingBar ratingGraphics = (RatingBar) view.findViewById(R.id.graphicsRatingBar);
        ratingGraphics.setNumStars(10);
        ratingGraphics.setRating(game.getPlayer().getStats().getGraphicsKnowledge());
    }
}
