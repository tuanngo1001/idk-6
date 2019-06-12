package idk6.csexperience.persistence.stubs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import idk6.csexperience.objects.CalendarEvent;
import idk6.csexperience.persistence.CalendarPersistence;


public class CalendarPersistenceStub implements CalendarPersistence {
    private List<CalendarEvent> calendarevent;
    private boolean midTerm = true;
    private boolean finalExam = false;

    public CalendarPersistenceStub() {
        this.calendarevent = new ArrayList<>();
        calendarevent.add(new CalendarEvent("Course1",1,1,midTerm));
        calendarevent.add(new CalendarEvent("Course2",2,2,finalExam));
        calendarevent.add(new CalendarEvent("Course3",3,1,midTerm));
        calendarevent.add(new CalendarEvent("Course4",4,2,finalExam));
        calendarevent.add(new CalendarEvent("Course5",5,1,midTerm));
    }
    @Override
    public List<CalendarEvent> getCalEventSequential() {
        return Collections.unmodifiableList(calendarevent);
    }

    @Override
    public CalendarEvent insertCalEvent(CalendarEvent currentEvent) {
        // don't bother checking for duplicates
        calendarevent.add(currentEvent);
        return currentEvent;
    }

    @Override
    public void deleteCalEvent(CalendarEvent currentCalendarevent) {
        int index;

        index = calendarevent.indexOf(currentCalendarevent);
        if (index >= 0)
        {
            calendarevent.remove(index);
        }
    }


}
