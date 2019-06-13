package idk6.csexperience.business;

import org.junit.Test;

import static org.junit.Assert.*;
import idk6.csexperience.objects.Calendar;
import idk6.csexperience.business.AdjustCalendar;
import idk6.csexperience.objects.Game;


public class AdjustCalendarTest {

    @Test
    public void testPlayer1(){

        //TESTING FOR CREATION OF AdjustCalendar
        Game testGame = new Game("testUser");
        AdjustCalendar adjustCalendar;
        System.out.println("Starting test AdjustCalendar");
        //IMPLEMENTING the testCalendar with
        // event "testEvent"
        String nameForTest = "testEvent";
        // day 3
        int dayForTest = 3;
        // period 1
        int periodForTest = 1;
        testGame.getCalendar().setEvent(nameForTest);
        testGame.getCalendar().setDay(dayForTest);
        testGame.getCalendar().setPeriod(periodForTest);

        adjustCalendar = new AdjustCalendar(testGame);
        assertNotNull("Game should not be Null", testGame);
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

        System.out.println("Finished test AdjustCalendar\n");

    }
}
