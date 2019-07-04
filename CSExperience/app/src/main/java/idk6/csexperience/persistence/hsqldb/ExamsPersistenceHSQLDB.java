package idk6.csexperience.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import idk6.csexperience.objects.Calendar;
import idk6.csexperience.objects.CalendarEvent;
import idk6.csexperience.objects.PlayerStats;
import idk6.csexperience.persistence.ExamsPersistence;

/*
    TABLE SCHEMA:
    Unique ID: string PLAYER_ID,
               string EXAM_NAME,
               int is
               int DAY,
               int PERIOD
 */

public class ExamsPersistenceHSQLDB implements ExamsPersistence {

    private final String dbPath;  // Relative path to our SQL database

    public ExamsPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        System.out.println("CONNECTION TO  "+ dbPath);
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    /*
        fromResultSet()
        Purpose: Used to translate query results into a Calendar object
        Parameter: A query result set
        Returns: A PlayerStats object
     */
    private CalendarEvent fromResultSet(final ResultSet rs) throws SQLException {
        String courseName = rs.getString("COURSE_NAME");
        int day = rs.getInt("DAY");
        int period = rs.getInt("PERIOD");
        int examType = rs.getInt("IS_MIDTERM");
        boolean isMidterm = examType == 0;

        return new CalendarEvent(courseName, day, period, isMidterm);
    }


    @Override
    public List<CalendarEvent> getCalEventsSequential() {
        List<CalendarEvent> exams = null;

        System.out.println("Attemptin to connect to exam db...");
        try(Connection c = connection()) {
            System.out.println("Connected to exam db!");
            exams = new ArrayList<CalendarEvent>();

            PreparedStatement st = c.prepareStatement("SELECT * FROM EXAM_DATES");
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                CalendarEvent exam = fromResultSet(rs);
                exams.add(exam);
            }

            return exams;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exams;
    }


    @Override
    public CalendarEvent insertCalEvent(CalendarEvent currentCourse) {
        // No.
        // It has been decided that all players have the same course
        // schedule, so we can initialize the table in the db script
        // and forget about it.
        return null;
    }


    @Override
    public void deleteCalEvents() {
        // Also no.
        // Players cannot drop courses. You think mercy exists in this lawless land?
    }
}
