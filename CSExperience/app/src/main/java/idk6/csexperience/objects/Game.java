package idk6.csexperience.objects;

import android.os.Parcel;
import android.os.Parcelable;

public class Game implements Parcelable {
    private Calendar calendar;
    private Player player;

    public Game(String name) {
        calendar = new Calendar();
        player = new Player(name, 3);
    }

    public Player getPlayer() {
        return player;
    }

    public Calendar getCalendar() { return calendar; }

    protected Game(Parcel in) {
        calendar = (Calendar) in.readValue(Calendar.class.getClassLoader());
        player = (Player) in.readValue(Player.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(calendar);
        dest.writeValue(player);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Game> CREATOR = new Parcelable.Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel in) {
            return new Game(in);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };
}