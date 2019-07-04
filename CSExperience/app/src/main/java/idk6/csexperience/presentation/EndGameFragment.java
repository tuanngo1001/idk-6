package idk6.csexperience.presentation;

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

public class EndGameFragment extends Fragment {

    private Game game;
    private AdjustGame adjuster;
    private Button studyDB, studyAI, studyGraphics;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_endgame,container,false);
    }

} // end StudyFragment
