package idk6.csexperience.business;

import org.junit.Test;

import static org.junit.Assert.*;
import idk6.csexperience.objects.Calendar;
import idk6.csexperience.business.AdjustCalendar;


public class AdjustCalendarTest {

    @Test
    public void testPlayer1(){

        //TESTING FOR CREATION OF AdjustCalendar
        Calendar testCalendar;
        AdjustCalendar adjustCalendar;
        System.out.println("\nStarting test AdjustCalendar");
        testCalendar = new Calendar();
        //IMPLEMENTING the testCalendar with
        // event "testEvent"
        String nameForTest = "testEvent";
        // day 3
        int dayForTest = 3;
        // period 1
        int periodForTest = 1;
        testCalendar.setEvent(nameForTest);
        testCalendar.setDay(dayForTest);
        testCalendar.setPeriod(periodForTest);

        adjustCalendar = new AdjustCalendar(testCalendar);
        assertNotNull("Calendar should not be Null", testCalendar);
        assertNotNull("AdjustCalendar should not be Null", adjustCalendar);

        //TESTING FOR nextDay()
        adjustCalendar.nextDay();
        assertTrue(adjustCalendar.getCalendar().getDay() == dayForTest+1 );

        //TESTING FOR nextPeriod()
        adjustCalendar.nextPeriod();
        assertTrue(adjustCalendar.getCalendar().getPeriod() == periodForTest+1 );

        //TESTING FOR addImportantEvent()
        int dateForTest = 8;
        String impEventForTest = "exam";
        adjustCalendar.addImportantEvent(dateForTest, impEventForTest);
        assertTrue(!adjustCalendar.getCalendar().getImportantDates().isEmpty());

        //TESTING FOR deleteImportantEvent()
        adjustCalendar.deleteImportantEvent(dateForTest);
        assertTrue(adjustCalendar.getCalendar().getImportantDates().isEmpty());

        //TESTING FOR getEvent()
        adjustCalendar.addImportantEvent(dateForTest, impEventForTest);
        assertEquals(impEventForTest, adjustCalendar.getEvent(dateForTest));

        System.out.println("\nEnding test AdjustCalendar");


    }
}
