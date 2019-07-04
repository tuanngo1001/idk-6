package idk6.csexperience.persistence;

import java.util.List;

import idk6.csexperience.objects.PlayerStats;

public interface PlayerStatsPersistence {
    // Return all stats for the player energy, food, happiness, money, and course knowledge

    PlayerStats getPlayerStats(String playerName);

    List<String> getPlayers();

    // Used at start of game to insert a new player into the database
    // Initial knowledge fields should be set 1 for each course
    boolean insertNewPlayer(String playerName);

    boolean doesExist(String PLAYER_ID);

    void insertPlayer(String PLAYER_ID, PlayerStats stats);



    // Update stat values for player
    void updatePlayerStats(String playerName, PlayerStats stats);

    // Delete the player "playerName" and his/her stats
    // Should return true if the player was found and deleted
    void deletePlayer(String playerName);
}
