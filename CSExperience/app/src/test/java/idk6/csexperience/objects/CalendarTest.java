package idk6.csexperience.objects;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalendarTest {
    @Test
    public void testCalendar1() {

        //TESTING FOR CREATION OF PLAYER
        Calendar testCalendar;
        System.out.println("Starting testCalendar creating");
        testCalendar = new Calendar();
        assertNotNull("Should not be Null", testCalendar);
        System.out.println("Finishing testCalendar");
    }
    @Test
    public void testSetGetDay() {

        //TESTING FOR CREATION OF PLAYER
        Calendar testCalendar;
        System.out.println("Starting testSetDay and testGetDay");
        testCalendar = new Calendar();
        assertNotNull("Should not be Null", testCalendar);
        //
        //TESTING FOR setDay() & getDay()
        testCalendar.setDay(15);
        assertTrue(testCalendar.getDay()-15 == 0);
        //
        System.out.println("Finishing testCalendar");
    }
    @Test
    public void testSetGetPeriod() {

        //TESTING FOR CREATION OF PLAYER
        Calendar testCalendar;
        System.out.println("Starting testSetPeriod and testGetPeriod");
        testCalendar = new Calendar();
        assertNotNull("Should not be Null", testCalendar);
        //
        //TESTING FOR setPeriod() & getPeriod()
        testCalendar.setPeriod(1);
        assertTrue(testCalendar.getPeriod()-1==0);
        //
        System.out.println("Finishing testCalendar");
    }
    @Test
    public void testSetGetEvent() {
        //TESTING FOR CREATION OF PLAYER
        Calendar testCalendar;
        System.out.println("Starting testSetEvent and testGetEvent");
        testCalendar = new Calendar();
        assertNotNull("Should not be Null", testCalendar);
        //
        //TESTING FOR setEvent() & getEvent()
        testCalendar.setEvent("testEvent");
        assertEquals("testEvent",testCalendar.getEvent());
        //
        System.out.println("Finishing testCalendar");
    }
}
