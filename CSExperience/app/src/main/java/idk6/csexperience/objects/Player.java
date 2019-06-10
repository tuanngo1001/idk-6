package idk6.csexperience.objects;

public class Player {
    private String name;
    private int difficulty;
    private PlayerStats stats;
    //private State; This maybe to hold where the player currently is? ie studying, sleeping, etc

    public Player(String name, int difficulty) {
        this.name = name;
        difficulty = difficulty;
        stats = new PlayerStats(difficulty);
    }

    public PlayerStats getStats() {
        return stats;
    }

    public String getName() {
        return name;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
