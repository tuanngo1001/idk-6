package idk6.csexperience.objects;

import org.junit.Test;

import static org.junit.Assert.*;

import idk6.csexperience.objects.Calendar;

public class CalendarTest {

    @Test
    public void testCalendar1(){

        //TESTING FOR CREATION OF PLAYER
        Calendar testCalendar;
        System.out.println("Starting testCalendar");
        testCalendar = new Calendar();
        assertNotNull("Should not be Null", testCalendar);

        //TESTING FOR setDay() & getDay()
        testCalendar.setDay(15);
        assertTrue(testCalendar.getDay()-15 == 0);

        //TESTING FOR setPeriod() & getPeriod()
        testCalendar.setPeriod(15);
        assertTrue(testCalendar.getPeriod()-15==0);

        //TESTING FOR setEvent() & getEvent()
        testCalendar.setEvent("testEvent");
        assertEquals("testEvent",testCalendar.getEvent());

        System.out.println("Finished testCalendar\n");

    }
}
