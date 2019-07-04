package idk6.csexperience.objects;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CalendarEventTest {
    @Test
    public void testCalendarEventAddGetCheck() {
        CalendarEvent testCalendarEvent;
        System.out.println("Starting testCalenderEventAddGetCheck");
        testCalendarEvent =
                new CalendarEvent("Birthday", 1,1,true);
        assertNotNull("Should not be Null", testCalendarEvent);

        assertEquals("Should be birthday",testCalendarEvent.getExamName(), "Birthday");
        assertEquals("Should be 1",testCalendarEvent.getExamDate(), 1);
        assertEquals("Should be 1",testCalendarEvent.getExamSlot(), 1);
        assertTrue("Should be true", testCalendarEvent.checkMid());
        System.out.println("Finishing testCalenderEventAddGetCheck");
    }

}
