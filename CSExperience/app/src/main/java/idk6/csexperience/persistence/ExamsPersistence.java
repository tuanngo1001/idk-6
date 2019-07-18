package idk6.csexperience.persistence;

import java.util.List;

import idk6.csexperience.objects.CalendarEvent;

public interface ExamsPersistence {
    // Get all calendar events
    List<CalendarEvent> getCalEventsSequential();

    // Insert 1 calendar event
    CalendarEvent insertCalEvent(CalendarEvent currentCourse);

    // Delete all calendar events
    void deleteCalEvents();
}