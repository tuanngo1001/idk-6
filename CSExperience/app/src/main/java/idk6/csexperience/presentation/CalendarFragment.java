package idk6.csexperience.presentation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;

import idk6.csexperience.R;
import idk6.csexperience.business.CalendarPersistenceAccessor;
import idk6.csexperience.objects.CalendarEvent;

public class CalendarFragment extends Fragment {

    private CalendarPersistenceAccessor calendarData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar,container,false);
        CalendarEvent currentExam;
        calendarData = new CalendarPersistenceAccessor();

        // Fetch the list of exams and get ready to iterate through them
        List<CalendarEvent> examList = calendarData.getListOfExams();
        Iterator i = examList.iterator();


        while(i.hasNext()){
            currentExam = (CalendarEvent) i.next();
            final String examName = getExamType(currentExam);
            final int examDate = currentExam.getExamDate();
            int id = getResources().getIdentifier("idk6.csexperience:drawable/button_background_exam_date" , null, null);

            // change the colour of the exam days to red
            // All date buttons are ID as dayX. Thanks Ren!
            final String buttonDay = "day" + examDate;
            int resID = getResources().getIdentifier(buttonDay, "id", "idk6.csexperience" );
            Button dateIcon = (Button) view.findViewById(resID);
            dateIcon.setBackgroundResource(id);

            dateIcon.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    showDialog("Day "+examDate, examName);
                }
            });

        }
        return view;
    }

    private String getExamType(CalendarEvent currentExam){
        String examType;

        if( currentExam.checkMid()) {
            examType = currentExam.getExamName() + " Midterm";
        }else
            examType = currentExam.getExamName() + " Final";

        return examType;
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
