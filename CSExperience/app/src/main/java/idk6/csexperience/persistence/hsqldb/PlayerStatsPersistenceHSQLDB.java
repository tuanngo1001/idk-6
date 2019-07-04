package idk6.csexperience.persistence.hsqldb;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import idk6.csexperience.objects.PlayerStats;
import idk6.csexperience.persistence.PlayerStatsPersistence;

/*
    TABLE SCHEMA:
    Unique ID: string playerID,
               int energy,
               int food,
               int happiness,
               int money,
               int dbKnowledge,
               int aiKnowledge,
               int graphicsKnowledge
 */


public class PlayerStatsPersistenceHSQLDB implements PlayerStatsPersistence {

    private final String dbPath;  // Relative path to our SQL database

    public PlayerStatsPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        System.out.println("CONNECTION TO  "+ dbPath);
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    /*
        fromResultSet()
        Purpose: Used to translate query results into a PlayerStats object
        Parameter: A query result set
        Returns: A PlayerStats object
     */
    private PlayerStats fromResultSet(final ResultSet rs) throws SQLException {
        final int energy = rs.getInt("ENERGY");
        final int food = rs.getInt("FOOD");
        final int happiness = rs.getInt("HAPPINESS");
        final int money = rs.getInt("MONEY");
        final int dbKnowledge = rs.getInt("DB_KNOWLEDGE");
        final int aiKnowledge = rs.getInt("AI_KNOWLEDGE");
        final int graphicsKnowledge = rs.getInt("GRAPHICS_KNOWLEDGE");

        PlayerStats statsBundle = new PlayerStats();

        statsBundle.setEnergy(energy);
        statsBundle.setFood(food);
        statsBundle.setHappiness(happiness);
        statsBundle.setMoney(money);
        statsBundle.setDatabasesKnowledge(dbKnowledge);
        statsBundle.setAiKnowledge(aiKnowledge);
        statsBundle.setGraphicsKnowledge(graphicsKnowledge);

        return statsBundle;
    }

    /*
        getPlayers
        Purpose: Get Names of all saved games
        Parameters: None
        Returns: A list of strings of names
     */
    @Override
    public List<String> getPlayers() {
        List<String> list = new ArrayList<>();
        try (final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("SELECT * FROM PLAYERSTATS");

            final ResultSet rs = st.executeQuery();
            //rs.next();
            while(rs.next()) {
                list.add(rs.getString("PLAYER_ID"));
                System.out.println(rs.getString("PLAYER_ID"));
            }
            //System.out.println((String)list.get(0));
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    /*
        getPlayerStats
        Purpose: Get the health and money for a specific player
        Parameters: String value for the playerID (i.e. the player's name)
        Returns: A new PlayerStats object containing the player's stats
     */
    @Override
    public PlayerStats getPlayerStats(String playerName) {
        try (final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("SELECT * FROM PLAYERSTATS WHERE PLAYER_ID = ?");
            st.setString(1, playerName);

            final ResultSet rs = st.executeQuery();
            rs.next();
            final PlayerStats stats = fromResultSet(rs);
            return stats;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean doesExist(String PLAYER_ID) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM PLAYERSTATS WHERE PLAYER_ID = ?");
            st.setString(1, PLAYER_ID);

            final ResultSet rs = st.executeQuery();
            rs.next();
            if(rs.getRow() > 0){
                System.out.println("is found is TRUE");
                return true;
            }
            else {
                System.out.println("is found is FALSE");
                return false;
            }
        } catch( SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    /*
        insertNewPlayer
        Purpose: Used to insert a new player (check to make sure one doesn't exist already)
        Parameters: String value for the playerID (i.e. the player's name)
        Returns: True if new player was successfully inserted
     */
    @Override
    public boolean insertNewPlayer(String playerName) {

        System.out.println("In persistence layer trying to add " + playerName);

        try (final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("INSERT INTO PLAYERSTATS VALUES(?,?,?,?,?,?,?,?)");
            st.setString(1, playerName);
            st.setInt(2, PlayerStats.INITIAL_ENERGY);
            st.setInt(3, PlayerStats.INITIAL_FOOD);
            st.setInt(4, PlayerStats.INITIAL_HAPPINESS);
            st.setInt(5, PlayerStats.INITIAL_MONEY);
            st.setInt(6, PlayerStats.INITIAL_KNOWLEDGE);
            st.setInt(7, PlayerStats.INITIAL_KNOWLEDGE);
            st.setInt(8, PlayerStats.INITIAL_KNOWLEDGE);
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void insertPlayer(String PLAYER_ID, PlayerStats stats) {
        System.out.println("Updating SAve GAme with name: " + PLAYER_ID);

        try(final Connection c = connection()){
        final PreparedStatement st = c.prepareStatement("INSERT INTO PLAYERSTATS VALUES(?,?,?,?,?,?,?,?)");
        st.setString(1, PLAYER_ID);
        st.setInt(2, stats.getEnergy());
        st.setInt(3, stats.getFood());
        st.setInt(4, stats.getHappiness());
        st.setInt(5, stats.getMoney());
        st.setInt(6, stats.getDatabasesKnowledge());
        st.setInt(7, stats.getAiKnowledge());
        st.setInt(8, stats.getGraphicsKnowledge());

        st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updatePlayerStats(String playerName, PlayerStats stats) {
        try(final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("UPDATE PLAYERSTATS SET " +
                    "ENERGY = ?, FOOD = ?, HAPPINESS = ?, MONEY = ?, DB_KNOWLEDGE = ?, " +
                    "AI_KNOWLEDGE = ?, GRAPHICS_KNOWLEDGE = ? WHERE PLAYER_ID = ?");
            st.setInt(1, stats.getEnergy());
            st.setInt(2, stats.getFood());
            st.setInt(3, stats.getHappiness());
            st.setInt(4, stats.getMoney());
            st.setInt(5, stats.getDatabasesKnowledge());
            st.setInt(6, stats.getAiKnowledge());
            st.setInt(7, stats.getGraphicsKnowledge());
            st.setString(8, playerName);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deletePlayer(String playerName) {
        try(final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("DELETE FROM PLAYERSTATS " +
                    "WHERE PLAYER_ID = ?");
            st.setString(1, playerName);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
