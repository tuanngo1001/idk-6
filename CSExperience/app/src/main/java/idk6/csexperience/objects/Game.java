package idk6.csexperience.objects;

import android.os.Parcelable;

public class Game {
    private Time time;
    private Player player;

    public Game(String name) {
        time = new Time();
        player = new Player(name, 3);
    }

    public Player getPlayer() {
        return player;
    }

    public Time getTime() {
        return time;
    }
}
