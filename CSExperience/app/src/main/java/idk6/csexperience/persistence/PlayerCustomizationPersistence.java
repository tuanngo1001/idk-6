package idk6.csexperience.persistence;

public interface PlayerCustomizationPersistence {

    // Return the name of the image file associated with the player's profile/game
    String getImageName(String PlayerName);

    // Associate an image resource name with the player's name
    // Only include the image name and not the full path. This way we can change
    // where we store our images if need be.
    void inerstPlayerImage(String resouceName);

    // Delete a player from the table
    // Return true if playerName was found and his/her row was deleted
    boolean deletePlayer(String playerName);
}
