package idk6.csexperience.objects;

import org.junit.Test;

import static org.junit.Assert.*;

import idk6.csexperience.objects.Player;

public class PlayerTest {

    @Test
    public void testPlayer1(){

        //TESTING FOR CREATION OF PLAYER
        Player playRole;
        System.out.println("Starting testPlayer");
        playRole = new Player();
        playRole.setName("playerName");
        assertNotNull("Should not be Null", playRole);

        //TESTING FOR getDifficulty()
        assertEquals("Should be equal",3, playRole.getDifficulty());

        //TESTING FOR getName()
        assertEquals("playerName",playRole.getName());

        //TESTING FOR getStats()

        System.out.println("Finished testPlayer\n");
    }
}
