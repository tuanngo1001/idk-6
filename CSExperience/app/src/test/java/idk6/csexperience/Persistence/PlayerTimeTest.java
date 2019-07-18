package idk6.csexperience.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import idk6.csexperience.objects.CalendarEvent;
import idk6.csexperience.persistence.ExamsPersistence;
import idk6.csexperience.persistence.PlayerTimePersistence;
import idk6.csexperience.persistence.hsqldb.ExamsPersistenceHSQLDB;
import idk6.csexperience.persistence.hsqldb.PlayerTimePersistenceHSQLDB;
import idk6.csexperience.utils.TestUtils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class PlayerTimeTest {
    private PlayerTimePersistence time;
    private File tempDB;

    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        this.time = new PlayerTimePersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script",""));
        assertNotNull(this.time);
    }

    @Test
    public void testGetDateTime() {
        System.out.println("\nStarting testGetDateTime");

        List<Integer> dateTime = time.getDateTime("PLAYER");
        assertNotNull(dateTime);
        assertTrue(dateTime.size() == 2);
        assertTrue(dateTime.get(0) == 3);
        assertTrue(dateTime.get(1) == 2);

        System.out.println("Finishing testDoesPlayerExist");
    }

    @Test
    public void testUpdateDateTime() {
        System.out.println("\nStarting testUpdateDateTime");

        time.updateDateTime("PLAYER", 6, 1);

        List<Integer> dateTime = time.getDateTime("PLAYER");
        assertNotNull(dateTime);
        assertTrue(dateTime.size() == 2);
        assertTrue(dateTime.get(0) == 6);
        assertTrue(dateTime.get(1) == 1);

        System.out.println("Finishing testDoesPlayerExist");

    }

    @Test
    public void testInsertNewPlayer() {
        System.out.println("\nStarting testInsertPlayer");

        time.insertNewPlayer("VERN");

        List<Integer> dateTime = time.getDateTime("VERN");
        assertNotNull(dateTime);
        assertTrue(dateTime.size() == 2);
        assertTrue(dateTime.get(0) == 1);
        assertTrue(dateTime.get(1) == 1);

        System.out.println("Finishing testDoesPlayerExist");
    }

    @Test
    public void testInsertDateTime() {
        System.out.println("\nStarting testInsertPlayer");

        time.insertDateTime("GUS", 12, 2);

        List<Integer> dateTime = time.getDateTime("GUS");
        assertNotNull(dateTime);
        assertTrue(dateTime.size() == 2);
        assertTrue(dateTime.get(0) == 12);
        assertTrue(dateTime.get(1) == 2);

        System.out.println("Finishing testDoesPlayerExist");
    }

    @Test
    public void testDeletePlayer() {
        System.out.println("\nStarting testDeletePlayer");

        time.deletePlayer("VERN");

        List<Integer> dateTime = time.getDateTime("VERN");
        assertTrue(dateTime == null);
        //Vern gone

        System.out.println("Finishing testDeletePlayer");
    }

    @After
    public void tearDown() {
        this.tempDB.delete();
    }


}
