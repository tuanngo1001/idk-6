package idk6.csexperience.business;

import org.junit.Test;
import java.util.List;
import idk6.csexperience.objects.CalendarEvent;
import idk6.csexperience.persistence.ExamsPersistence;
import idk6.csexperience.persistence.stubs.PlayerExamsPersistenceStub;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class CalendarPersistenceAccessorTest {

    @Test
    public void testGetListOfExams(){
        System.out.println("Starting testGetListOfExams\n");
        ExamsPersistence testExamPersistence = new PlayerExamsPersistenceStub();
        CalendarPersistenceAccessor testCalendarPerAcc = new CalendarPersistenceAccessor(testExamPersistence);
        List<CalendarEvent> testCalendarEvent = testExamPersistence.getCalEventsSequential();
        assertTrue("Should have the same size ", testCalendarEvent.size() == testCalendarPerAcc.getListOfExams().size());
        System.out.println("Finishing testGetListOfExam\n");
    }
    @Test
    public void testAddExamDate(){
        System.out.println("Starting testAddExamDate\n");
        CalendarPersistenceAccessor mockCalendarPerAcc = mock(CalendarPersistenceAccessor.class);
        CalendarEvent testCalendarEvent = new CalendarEvent("Midterm", 10, 1, true);
        mockCalendarPerAcc.addExamDate(testCalendarEvent);
        verify(mockCalendarPerAcc).addExamDate((testCalendarEvent));
        System.out.println("Finishing testAddExamDate\n");
    }
    @Test
    public void testDeleteExamDate(){
        System.out.println("Starting testDeleteExamDate\n");
        CalendarPersistenceAccessor mockCalendarPerAcc = mock(CalendarPersistenceAccessor.class);
        CalendarEvent testCalendarEvent = new CalendarEvent("Midterm", 10, 1, true);
        mockCalendarPerAcc.deleteExamDate(testCalendarEvent);
        verify(mockCalendarPerAcc).deleteExamDate((testCalendarEvent));
        System.out.println("Finishing testDeleteExamDate\n");
    }
    @Test
    public void testExamPeriodString(){
        System.out.println("Starting testExamPeriodString\n");
        CalendarPersistenceAccessor mockCalendarPerAcc = mock(CalendarPersistenceAccessor.class);
        mockCalendarPerAcc.examPeriodString(1);
        verify(mockCalendarPerAcc).examPeriodString(1);
        when(mockCalendarPerAcc.examPeriodString(1)).thenReturn("Morning");
        System.out.println("Finishing testExamPeriodString\n");
    }

}
