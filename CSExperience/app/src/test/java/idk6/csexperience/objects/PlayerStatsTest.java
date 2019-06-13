package idk6.csexperience.objects;

import org.junit.Test;

import static org.junit.Assert.*;

import idk6.csexperience.objects.PlayerStats;

public class PlayerStatsTest {
    @Test
    public void testPS1(){
        System.out.println("Starting testPlayerStat");

        PlayerStats stats = new PlayerStats();
        assertNotNull("Should not be Null",stats);
        assertEquals("Happiness should be 50",50,stats.getHappiness());
        assertEquals("Energy should be 50",50,stats.getEnergy());
        assertEquals("Food should be 50",50,stats.getFood());
        assertEquals("AiKnowledge should be 1",1,stats.getAiKnowledge());
        assertEquals("GraphicsKnowledge should be 1",1,stats.getGraphicsKnowledge());
        assertEquals("DatabasesKnowledge should be 1",1,stats.getDatabasesKnowledge());

        System.out.println("Finished testPlayerStat\n");
    }
}
