package idk6.csexperience.business;

import idk6.csexperience.objects.Player;
import idk6.csexperience.objects.Time;
import idk6.csexperience.objects.Game;

public class AdjustGame {
    private Game game;
    private Time time;
    private Player player;
    private AdjustPlayerStats adjustStats;
    private AdjustTime adjustTime;

    public AdjustGame(Game ourGame) {
        game = ourGame;
        this.time = ourGame.getTime();
        this.player = ourGame.getPlayer();
        adjustStats = new AdjustPlayerStats(ourGame);
        adjustTime = new AdjustTime(ourGame);
    }

    public void overnight() {
        adjustTime.overnight();
        adjustStats.sleep(1);
    }

    public void nextPeriod() {
        if(time.getPeriod() == 2) {
            adjustTime.nextPeriod();
            this.overnight();
        }
        else {
            adjustTime.nextPeriod();
        }
    }

    public void eat(int quantity, int quality) {
        adjustStats.eat(quantity, quality);

    }
}
