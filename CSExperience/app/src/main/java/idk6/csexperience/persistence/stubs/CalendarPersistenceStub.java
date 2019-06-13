package idk6.csexperience.persistence.stubs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import idk6.csexperience.objects.CalendarEvent;
import idk6.csexperience.persistence.CalendarPersistence;


public class CalendarPersistenceStub implements CalendarPersistence {
    private List<CalendarEvent> calendarEvent;
    private boolean midTerm = true;
    private boolean finalExam = false;

    public CalendarPersistenceStub() {
        this.calendarEvent = new ArrayList<>();
        calendarEvent.add(new CalendarEvent("Databases",10,1,midTerm));
        calendarEvent.add(new CalendarEvent("Databases",28,2,finalExam));
        calendarEvent.add(new CalendarEvent("AI",13,1,midTerm));
        calendarEvent.add(new CalendarEvent("AI",29,2,finalExam));
        calendarEvent.add(new CalendarEvent("Graphics",15,1,midTerm));
        calendarEvent.add(new CalendarEvent("Graphics", 30, 2,finalExam));
    }

    @Override
    public List<CalendarEvent> getCalEventSequential() {
        return Collections.unmodifiableList(calendarEvent);
    }

    @Override
    public CalendarEvent insertCalEvent(CalendarEvent currentEvent) {
        // don't bother checking for duplicates
        calendarEvent.add(currentEvent);
        return currentEvent;
    }

    @Override
    public void deleteCalEvent(CalendarEvent currentCalendarEvent) {
        int index;

        index = calendarEvent.indexOf(currentCalendarEvent);
        if (index >= 0)
        {
            calendarEvent.remove(index);
        }
    }


}
