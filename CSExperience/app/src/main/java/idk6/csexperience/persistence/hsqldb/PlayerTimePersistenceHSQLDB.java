package idk6.csexperience.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import idk6.csexperience.objects.Calendar;
import idk6.csexperience.objects.PlayerStats;
import idk6.csexperience.persistence.PlayerTimePersistence;

/*
    TABLE SCHEMA:
    Unique ID: string PLAYER_ID,
               int DAY,
               int PERIOD
 */

public class PlayerTimePersistenceHSQLDB implements PlayerTimePersistence {
    private final String dbPath;  // Relative path to our SQL database


    public PlayerTimePersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }


    private Connection connection() throws SQLException {
        System.out.println("CONNECTION TO  "+ dbPath);
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }


    /*
    fromResultSet()
    Purpose: Used to translate query results into a 2 element array
    Parameter: A query result set
    Returns: A short array
 */
    private List<Integer> fromResultSet(final ResultSet rs) throws SQLException {
        final int day = rs.getInt("DAY");
        final int timePeriod = rs.getInt("PERIOD");

        final List<Integer> result = new ArrayList<Integer>();
        result.add(day);
        result.add(timePeriod);

        return result;
    }


    @Override
    public List<Integer> getDateTime(String playerName) {
        List<Integer> dateTime = null;

        try(Connection c = connection()){
            dateTime = new ArrayList<Integer>();
            final PreparedStatement st = c.prepareStatement("SELECT * FROM PLAYER_TIME WHERE PLAYER_ID = ?");
            st.setString(1, playerName);

            final ResultSet rs = st.executeQuery();
            rs.next();

            dateTime = fromResultSet(rs);

            return dateTime;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dateTime;
    }


    /*
        insertNewPlayer
        Used at start of new game to store default values
     */
    @Override
    public void insertNewPlayer(String playerName) {
        try(Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("INSERT INTO PLAYER_TIME VALUES (?, ?, ?)");
            st.setString(1, playerName);
            st.setInt(2, 1);
            st.setInt(3, Calendar.AFTERNOON);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertDateTime(String PLAYER_ID, int day, int period) {
        try(Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO PLAYER_TIME VALUES (?,?,?)");
            st.setString(1,PLAYER_ID);
            st.setInt(2, day);
            st.setInt(3, period);
            st.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public void updateDateTime(String playerName, int day, int timePeriod) {
        try(Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("UPDATE PLAYER_TIME SET DAY = ?, " +
                    "PERIOD = ? WHERE PLAYER_ID = ?");
            st.setInt(1, day);
            st.setInt(2, timePeriod);
            st.setString(3, playerName);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePlayer(String playerName) {
        try(final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("DELETE FROM PLAYER_TIME " +
                    "WHERE PLAYER_ID = ?");
            st.setString(1, playerName);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
