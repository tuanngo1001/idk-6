package idk6.csexperience.persistence;

import java.util.List;

import idk6.csexperience.objects.CalendarEvent;

public interface CalendarPersistence {
    List<CalendarEvent> getCalEventSequential();

    CalendarEvent insertCalEvent(CalendarEvent currentCourse);

    void deleteCalEvent(CalendarEvent currentCourse);
}