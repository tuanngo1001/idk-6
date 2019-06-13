package idk6.csexperience.presentation;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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

        calendarData = new CalendarPersistenceAccessor();

        // Fetch the list of exams and get ready to iterate through them
        List<CalendarEvent> examList = calendarData.getListOfExams();
        Iterator i = examList.iterator();
        CalendarEvent currentExam;

        while(i.hasNext()){
            currentExam = (CalendarEvent) i.next();
            int examDate = currentExam.getExamDate();
            int id = getResources().getIdentifier("idk6.csexperience:drawable/button_background_exam_date" , null, null);

            // change the colour of the exam days to red
            // All date buttons are ID as dayX. Thanks Ren!
            String buttonDay = "day" + examDate;
            int resID = getResources().getIdentifier(buttonDay, "id", "idk6.csexperience" );
            Button dateIcon = (Button) view.findViewById(resID);
            dateIcon.setBackgroundResource(id);
        }

        return view;
    }
}
