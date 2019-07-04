package idk6.csexperience.business;

import org.junit.Test;
import static org.junit.Assert.*;
import idk6.csexperience.objects.Game;

public class AdjustCalendarTest {
    @Test
    public void testAdjustCalendarCreating(){
        System.out.println("Starting testAdjustCalendarCreating");
        Game.destoryGame();
        Game testGame = Game.getCoreGame();
        AdjustCalendar adjustCalendar;
        String nameForTest = "testEvent";
        int dayForTest = 3;
        int periodForTest = 1;
        testGame.getCalendar().setEvent(nameForTest);
        testGame.getCalendar().setDay(dayForTest);
        testGame.getCalendar().setPeriod(periodForTest);
        adjustCalendar = new AdjustCalendar(testGame);
        assertNotNull("Game should not be Null", testGame);
        assertNotNull("AdjustCalendar should not be Null", adjustCalendar);
        System.out.println("Finishing testAdjustCalendarCreating");
    }
    @Test
    public void testNextDay(){
        System.out.println("Starting testNextDay");
        Game.destoryGame();
        Game testGame = Game.getCoreGame();
        AdjustCalendar adjustCalendar;
        String nameForTest = "testEvent";
        int dayForTest = 3;
        int periodForTest = 1;
        testGame.getCalendar().setEvent(nameForTest);
        testGame.getCalendar().setDay(dayForTest);
        testGame.getCalendar().setPeriod(periodForTest);
        adjustCalendar = new AdjustCalendar(testGame);
        assertNotNull("Game should not be Null", testGame);
        assertNotNull("AdjustCalendar should not be Null", adjustCalendar);
        //
        //TESTING FOR nextDay()
        adjustCalendar.nextDay();
        assertTrue(adjustCalendar.getCalendar().getDay() == dayForTest+1 );
        //
        System.out.println("Finishing testNextDay");
    }
    @Test
    public void testNextPeriod(){
        System.out.println("Starting testNextPeriod");
        Game.destoryGame();
        Game testGame = Game.getCoreGame();
        AdjustCalendar adjustCalendar;
        String nameForTest = "testEvent";
        int dayForTest = 3;
        int periodForTest = 1;
        testGame.getCalendar().setEvent(nameForTest);
        testGame.getCalendar().setDay(dayForTest);
        testGame.getCalendar().setPeriod(periodForTest);
        adjustCalendar = new AdjustCalendar(testGame);
        assertNotNull("Game should not be Null", testGame);
        assertNotNull("AdjustCalendar should not be Null", adjustCalendar);
        //
        //TESTING FOR nextPeriod()
        adjustCalendar.nextPeriod();
        assertTrue(adjustCalendar.getCalendar().getPeriod() == periodForTest+1 );
        //
        System.out.println("Finishing testNextPeriod");
    }
    @Test
    public void testAddImportantEvent(){
        System.out.println("Starting Add Delete and get important event");
        Game.destoryGame();
        Game testGame = Game.getCoreGame();
        AdjustCalendar adjustCalendar;
        String nameForTest = "testEvent";
        int dayForTest = 3;
        int periodForTest = 1;
        testGame.getCalendar().setEvent(nameForTest);
        testGame.getCalendar().setDay(dayForTest);
        testGame.getCalendar().setPeriod(periodForTest);
        adjustCalendar = new AdjustCalendar(testGame);
        assertNotNull("Game should not be Null", testGame);
        assertNotNull("AdjustCalendar should not be Null", adjustCalendar);
        //
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
        System.out.println("Finishing Add Delete and get important event");
    }
}
