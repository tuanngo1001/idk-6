package idk6.csexperience.business;

import java.util.List;

import idk6.csexperience.objects.CalendarEvent;
import idk6.csexperience.persistence.ExamsPersistence;

// The class servers as an interface between the persistence layer and other business or presentation
// level objects.

public class CalendarPersistenceAccessor {

    private ExamsPersistence calendarData;  // Connection to our persistence object

    public CalendarPersistenceAccessor(ExamsPersistence persistenceRef){
        calendarData = persistenceRef;
    }

    public List<CalendarEvent> getListOfExams(){
        return calendarData.getCalEventsSequential();
    }

    public void addExamDate(CalendarEvent exam){
        calendarData.insertCalEvent(exam);
    }

    public void deleteExamDate(CalendarEvent exam){
        calendarData.deleteCalEvents();
    }

    public String examPeriodString(int examPeriod){
        if(examPeriod == 1)
            return "Morning";
        else if(examPeriod == 2)
            return "Afternoon";
        else
            return "Evening";
    }

}
