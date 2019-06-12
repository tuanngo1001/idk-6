package idk6.csexperience.business;

import org.junit.Test;

import idk6.csexperience.objects.Game;

import static org.junit.Assert.*;

public class AdjustTimeTest
{
    @Test
    public void testAdjustTime()
    {
        Game game;
        AdjustTime adjustTime;

        System.out.println("\nStarting testCourse");

        game = new Game("playerName");
        adjustTime = new AdjustTime(game);

        assertNotNull(game);
        assertNotNull(adjustTime);

        //TESTING overnight()
        int gameDay = game.getTime().getDay();
        adjustTime.overnight();
        assertTrue(game.getTime().getDay()== gameDay+1);

        //TESTING nextPeriod()
        int gamePeriod = game.getTime().getPeriod();
        int periodOne = 1;
        int periodTwo = 2;
        adjustTime.nextPeriod();
        if(gamePeriod ==periodOne){
            assertTrue(game.getTime().getPeriod()== periodTwo);
        }
        else{
            assertTrue(game.getTime().getPeriod()== periodOne);
        }

        System.out.println("Finished testCourse");
    }
}