package idk6.csexperience.persistence;

import java.util.List;

public interface PlayerTimePersistence {

    // Return all the day and time period for a specific player profile [day, timePeriod]
    List<Integer> getDateTime(String playerName);

    // Used to insert initial day and time values at start of game
    // Should set day and time periods to 1 and afternoon (use Calendar.AFTERNOON and Calendar.Evening)
    void insertNewPlayer(String playerName);

    // Used to update existing day and time period values
    void updateDateTime(String playerName, int day, int timePeriod);

    void insertDateTime(String PLAYER_ID, int day, int period);

    // Delete the "playerName" row from the table
    // Should return true if the player was found and deleted
    void deletePlayer(String playerName);
}
