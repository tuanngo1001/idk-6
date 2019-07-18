package idk6.csexperience.objects;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testSetGetName(){
        //TESTING FOR CREATION OF PLAYER
        Player playRole;
        System.out.println("Starting testSetGetName");
        playRole = new Player();
        playRole.setName("playerName");
        assertNotNull("Should not be Null", playRole);
        //TESTING FOR getName()
        assertEquals("playerName",playRole.getName());

        System.out.println("Finished testSetGetName\n");
    }

    @Test
    public void testGetStats() {
        //TESTING FOR CREATION OF PLAYER
        Player playRole;
        System.out.println("Starting testGetDifficulty");
        playRole = new Player();
        assertNotNull("Should not be Null", playRole);
        assertEquals(50, playRole.getStats().getEnergy());
        assertEquals(50, playRole.getStats().getFood());
        assertEquals(50, playRole.getStats().getHappiness());
        System.out.println("Finished testGetDifficulty\n");
    }
}
