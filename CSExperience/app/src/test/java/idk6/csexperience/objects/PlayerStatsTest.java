package idk6.csexperience.objects;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerStatsTest {
    @Test
    public void testSetGetStats(){
        System.out.println("Starting testSetGetStats");

        PlayerStats stats = new PlayerStats();
        assertNotNull("Should not be Null",stats);
        stats.setEnergy(1);
        stats.setHappiness(2);
        stats.setFood(3);
        assertEquals("Happiness should be 2",2,stats.getHappiness());
        assertEquals("Energy should be 1",1,stats.getEnergy());
        assertEquals("Food should be 3",3,stats.getFood());
        System.out.println("Finished testSetGetStat\n");
    }
    @Test
    public void testSetGetKnowledge(){
        System.out.println("Starting testSetGetKnowledge");

        PlayerStats stats = new PlayerStats();
        assertNotNull("Should not be Null",stats);
        stats.setAiKnowledge(5);
        stats.setDatabasesKnowledge(6);
        stats.setGraphicsKnowledge(7);
        assertEquals("AiKnowledge should be 5",5,stats.getAiKnowledge());
        assertEquals("GraphicsKnowledge should be 7",7,stats.getGraphicsKnowledge());
        assertEquals("DatabasesKnowledge should be 6",6,stats.getDatabasesKnowledge());
        System.out.println("Finished testSetGetKnowledge\n");
    }
    @Test
    public void testSetGetMoney(){
        System.out.println("Starting testSetGetMoney");

        PlayerStats stats = new PlayerStats();
        assertNotNull("Should not be Null",stats);
        stats.setMoney(100);
        assertEquals("Money should be 100",100,stats.getMoney());
        System.out.println("Finished testSetGetMoney\n");
    }
}
