package idk6.csexperience.Presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import idk6.csexperience.R;

public class CoursesToStudyActivity extends AppCompatActivity implements View.OnClickListener{

    //private Player player

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_to_study);

        // Create listeners for each button
        Button studyCourse1 = (Button) findViewById(R.id.studyCourse1);
        studyCourse1.setOnClickListener(this);  // tell it to call onClick
        Button studyCourse2 = (Button) findViewById(R.id.studyCourse2);
        studyCourse2.setOnClickListener(this);
        Button studyCourse3 = (Button) findViewById(R.id.studyCourse3);
        studyCourse3.setOnClickListener(this);
        Button studyCourse4 = (Button) findViewById(R.id.studyCourse4);
        studyCourse4.setOnClickListener(this);
        Button studyCourse5 = (Button) findViewById(R.id.studyCourse5);
        studyCourse5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Study a course
        int courseToStudy;
        switch (v.getId()){
            case R.id.studyCourse1:
                courseToStudy = 1;
                break;
            case R.id.studyCourse2:
                courseToStudy = 2;
                break;
            case R.id.studyCourse3:
                courseToStudy = 3;
                break;
            case R.id.studyCourse4:
                courseToStudy = 4;
                break;
            case R.id.studyCourse5:
                courseToStudy = 5;
                break;
        } // end switch

        // TODO:

        // Study
        // int newEnergy = player.getStats().getEnergy -1; // not a good way of doings this
        // player.getStats().setEnergy(newEnergy);

        // int newHappiness = player.getStats().getHappiness -1;
        // player.getStats().setHappiness(newHappiness);

        // player.rankUpKnowledge( courseToStudy ); // Add this method to the player
                                                    // It would be better if it modified stats too.
    }
}
