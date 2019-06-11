package idk6.csexperience.objects;

import android.os.Parcel;
import android.os.Parcelable;

public class Player implements Parcelable {
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

    protected Player(Parcel in) {
        name = in.readString();
        difficulty = in.readInt();
        stats = (PlayerStats) in.readValue(PlayerStats.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(difficulty);
        dest.writeValue(stats);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Player> CREATOR = new Parcelable.Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };
}