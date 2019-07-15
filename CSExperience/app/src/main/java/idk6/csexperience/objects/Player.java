package idk6.csexperience.objects;

import android.os.Parcel;
import android.os.Parcelable;

public class Player {
    private String name;
    private PlayerStats stats;
    //private State; This maybe to hold where the player currently is? ie studying, sleeping, etc

    public Player() {
        stats = new PlayerStats();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayerStats(PlayerStats newPlayerStats) {
        stats = newPlayerStats;
    }

    public PlayerStats getStats() {
        return stats;
    }

    public String getName() {
        return name;
    }

}