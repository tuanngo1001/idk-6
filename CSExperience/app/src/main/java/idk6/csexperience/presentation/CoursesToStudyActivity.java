package idk6.csexperience.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import idk6.csexperience.R;
import idk6.csexperience.business.AdjustGame;
import idk6.csexperience.objects.Game;

//public class CoursesToStudyActivity extends AppCompatActivity implements View.OnClickListener{

//    private Game game;
//    private AdjustGame adjuster;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_courses_to_study);
//
//        // game = how do we do this??
//        adjuster = new AdjustGame(game);
//
//        // Create listeners for each button
//        Button studyCourse1 = (Button) findViewById(R.id.studyCourse1);
//        studyCourse1.setOnClickListener(this);  // tell it to call onClick
//        Button studyCourse2 = (Button) findViewById(R.id.studyCourse2);
//        studyCourse2.setOnClickListener(this);
//        Button studyCourse3 = (Button) findViewById(R.id.studyCourse3);
//        studyCourse3.setOnClickListener(this);
//        Button studyCourse4 = (Button) findViewById(R.id.studyCourse4);
//        studyCourse4.setOnClickListener(this);
//        Button studyCourse5 = (Button) findViewById(R.id.studyCourse5);
//        studyCourse5.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        // Study a course
//        switch (v.getId()){
//            case R.id.studyCourse1:
//                adjuster.study(0);
//                break;
//            case R.id.studyCourse2:
//                adjuster.study(1);
//                break;
//            case R.id.studyCourse3:
//                adjuster.study(2);
//                break;
//            case R.id.studyCourse4:
//                adjuster.study(3);
//                break;
//            case R.id.studyCourse5:
//                adjuster.study(4);
//                break;
//        } // end switch
//
//    }
//}
