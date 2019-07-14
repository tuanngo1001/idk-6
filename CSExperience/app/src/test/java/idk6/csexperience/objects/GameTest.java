package idk6.csexperience.objects;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void testSetPlayerNameGetPlayer(){
        Game testGame;
        System.out.println("Starting testSetPlayerName");
        Game.destoryGame();
        testGame = Game.getCoreGame();
        testGame.setPlayerName("playerName");
        assertNotNull(testGame);
        assertTrue("playerName".equals(testGame.getPlayer().getName()));
        System.out.println("Finished testSet\n");
    }
    @Test
    public void testSetGetCalendar(){
        Game testGame;
        System.out.println("Starting testSetPlayerName");
        Game.destoryGame();
        testGame = Game.getCoreGame();
        assertNotNull(testGame);

        List<Integer> dateAndTime = new ArrayList<Integer>();
        dateAndTime.add(3);  // Day = 3
        dateAndTime.add( Calendar.EVENING);  // Period = evening

        testGame.setCalendar(dateAndTime);  // Set the calendar's clock

        Calendar calendar = testGame.getCalendar();

        assertEquals(calendar.getDay() , 3);
        assertEquals(calendar.getPeriod(), Calendar.EVENING);
        System.out.println("Finished testSet\n");
    }
}
