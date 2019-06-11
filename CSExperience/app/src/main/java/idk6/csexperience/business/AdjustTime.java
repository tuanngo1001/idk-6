package idk6.csexperience.business;

import idk6.csexperience.objects.Game;
import idk6.csexperience.objects.Time;

public class AdjustTime {
    private Game game;
    private Time time;
    private int day;
    private int period;

    public AdjustTime(Game ourGame) {
        this.game = ourGame;
        this.time = ourGame.getTime();
        day = ourGame.getTime().getDay();
        period = ourGame.getTime().getPeriod();
    }

    public void overnight() {
        day++;
        time.setPeriod(period);
        time.setDay(day);
    }

    public void nextPeriod() {
        if(period == 2) {
            period = 1;
        }
        else {
            period = 2;
        }
        time.setPeriod(period);
    }
}
