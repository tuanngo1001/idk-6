package idk6.csexperience.persistence.stubs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import idk6.csexperience.objects.CalendarEvent;
import idk6.csexperience.persistence.ExamsPersistence;


public class PlayerExamsPersistenceStub implements ExamsPersistence {
    private List<CalendarEvent> calendarEvents;
    private boolean midTerm = true;
    private boolean finalExam = false;

    public PlayerExamsPersistenceStub() {
        this.calendarEvents = new ArrayList<>();
        calendarEvents.add(new CalendarEvent("Databases",10,1,midTerm));
        calendarEvents.add(new CalendarEvent("Databases",28,2,finalExam));
        calendarEvents.add(new CalendarEvent("AI",13,1,midTerm));
        calendarEvents.add(new CalendarEvent("AI",29,2,finalExam));
        calendarEvents.add(new CalendarEvent("Graphics",15,1,midTerm));
        calendarEvents.add(new CalendarEvent("Graphics", 30, 2,finalExam));
    }

    @Override
    public List<CalendarEvent> getCalEventsSequential() {
        return Collections.unmodifiableList(calendarEvents);
    }

    @Override
    public CalendarEvent insertCalEvent(CalendarEvent currentEvent) {
        // don't bother checking for duplicates
        calendarEvents.add(currentEvent);
        return currentEvent;
    }

    @Override
    public void deleteCalEvents(){
        calendarEvents.clear();
    }
}
