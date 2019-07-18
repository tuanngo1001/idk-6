package idk6.csexperience.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

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
        System.out.println("\nStarting testDoesPlayerExist creating");
        boolean exists = this.Player.doesExist("PLAYER");
        assertTrue("'PLAYER' should exist", exists);
        exists = this.Player.doesExist("BIGVERN");
        assertFalse("'BIGVERN' should not exist", exists);
        System.out.println("Finishing testDoesPlayerExist creating");
    }

    @After
    public void tearDown() {
        this.tempDB.delete();
    }


}
