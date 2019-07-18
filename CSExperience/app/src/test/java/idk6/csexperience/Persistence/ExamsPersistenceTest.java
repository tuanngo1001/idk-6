package idk6.csexperience.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import idk6.csexperience.objects.Calendar;
import idk6.csexperience.objects.CalendarEvent;
import idk6.csexperience.objects.PlayerStats;
import idk6.csexperience.persistence.ExamsPersistence;
import idk6.csexperience.persistence.PlayerStatsPersistence;
import idk6.csexperience.persistence.hsqldb.ExamsPersistenceHSQLDB;
import idk6.csexperience.persistence.hsqldb.PlayerStatsPersistenceHSQLDB;
import idk6.csexperience.utils.TestUtils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ExamsPersistenceTest {
    private ExamsPersistence calendar;
    private File tempDB;

    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        this.calendar = new ExamsPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script",""));
        assertNotNull(this.calendar);
    }

    @Test
    public void testGetExams() {
        System.out.println("\nStarting testGetExams");
        List<CalendarEvent> events = calendar.getCalEventsSequential();
        assertNotNull(events);
        assertTrue(events.get(0).getExamName().equals("Databases"));
        assertTrue(events.get(0).getExamDate() == 10);
        assertTrue(events.get(1).getExamName().equals("Databases"));
        assertTrue(events.get(1).getExamDate() == 28);
        assertTrue(events.get(2).getExamName().equals("AI"));
        assertTrue(events.get(2).getExamDate() == 13);
        assertTrue(events.get(3).getExamName().equals("AI"));
        assertTrue(events.get(3).getExamDate() == 29);
        assertTrue(events.get(4).getExamName().equals("Graphics"));
        assertTrue(events.get(4).getExamDate() == 15);
        assertTrue(events.get(5).getExamName().equals("Graphics"));
        assertTrue(events.get(5).getExamDate() == 30);

        System.out.println("Finishing testDoesPlayerExist");
    }


    @After
    public void tearDown() {
        this.tempDB.delete();
    }


}
