package idk6.csexperience.objects;

import org.junit.Test;

import static org.junit.Assert.*;

import idk6.csexperience.objects.Player;

public class PlayerTest {

    @Test
    public void testPlayer1(){

        //TESTING FOR CREATION OF PLAYER
        Player playRole;
        System.out.println("\nStarting testPlayer");
        playRole = new Player("playerName", 1);
        assertNotNull("Should not be Null", playRole);

        //TESTING FOR getDifficulty()
        assertTrue(playRole.getDifficulty() == 1);

        //TESTING FOR getName()
        assertEquals("playerName",playRole.getName());

        //TESTING FOR getStats()

    }
}
