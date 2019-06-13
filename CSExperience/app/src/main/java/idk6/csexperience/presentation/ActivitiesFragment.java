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

import java.util.zip.Inflater;

import idk6.csexperience.R;

public class ActivitiesFragment extends Fragment {
    Button study;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activities,container,false);

        study = (Button) view.findViewById(R.id.buttonStudy);

        study.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                StudyFragment nextFrag= new StudyFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, nextFrag, "studyFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }

}
