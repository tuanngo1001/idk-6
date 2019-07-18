package idk6.csexperience.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import idk6.csexperience.objects.Game;
import idk6.csexperience.objects.PlayerStats;
import idk6.csexperience.persistence.PlayerStatsPersistence;
import idk6.csexperience.persistence.hsqldb.PlayerStatsPersistenceHSQLDB;
import idk6.csexperience.utils.TestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PlayerStatsPersistenceTest {
    private PlayerStatsPersistence Player;
    private File tempDB;

    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        this.Player = new PlayerStatsPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script",""));
        assertNotNull(this.Player);
    }

    @Test
    public void testDoesPlayerExist() {
        System.out.println("\nStarting testDoesPlayerExist");
        boolean exists = this.Player.doesExist("PLAYER");
        assertTrue("'PLAYER' should exist", exists);
        exists = this.Player.doesExist("BIGVERN");
        assertFalse("'BIGVERN' should not exist", exists);
        System.out.println("Finishing testDoesPlayerExist");
    }

    @Test
    public void testGetPlayers() {
        System.out.println("\nStarting testGetPlayers test");

        List<String> list = this.Player.getPlayers();
        //start with only the one player in list
        assertTrue(list.get(0).equals("PLAYER"));
        assertTrue(list.size()==1);

        System.out.println("Finishing testGetPlayers test");

    }

    @Test
    public void testGetPlayerStats() {
        System.out.println("\nStarting testGetPlayerStats test");

        PlayerStats stats = this.Player.getPlayerStats("PLAYER");
        System.out.println(stats);
        //start with only the one player in list
        assertTrue(stats.getMoney() == 50);
        assertTrue(stats.getFood() == 55);
        assertTrue(stats.getEnergy() == 25);
        assertTrue(stats.getHappiness() == 75);
        assertTrue(stats.getDatabasesKnowledge() == 3);
        assertTrue(stats.getAiKnowledge() == 2);
        assertTrue(stats.getGraphicsKnowledge() == 1);


        System.out.println("Finishing testGetPlayerStats test");

    }

    @After
    public void tearDown() {
        this.tempDB.delete();
    }


}
