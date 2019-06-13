package idk6.csexperience.business;

import java.util.List;
import idk6.csexperience.objects.CalendarEvent;
import idk6.csexperience.persistence.stubs.CalendarPersistenceStub;

// The class servers as an interface between the persistence layer and other business or presentation
// level objects.

public class CalendarPersistenceAccessor {

    private CalendarPersistenceStub calendarData;

    public CalendarPersistenceAccessor(){
        calendarData = new CalendarPersistenceStub();
    }


    public List<CalendarEvent> getListOfExams(){
        return calendarData.getCalEventSequential();
    }


    public void addExamDate(CalendarEvent exam){
        calendarData.insertCalEvent(exam);
    }

    public void deleteExamDate(CalendarEvent exam){
        calendarData.deleteCalEvent(exam);
    }

}
