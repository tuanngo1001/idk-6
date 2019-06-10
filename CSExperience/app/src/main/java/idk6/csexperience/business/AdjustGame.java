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

    private void overnight() {
        adjustTime.overnight();
        adjustStats.sleep();
    }

    // Advance time by one time slot (and roll over into the next day if need be)
    // Note that time period is either 1 or 2.
    public void advanceTime() {
        if(time.getPeriod() == 2) {
            adjustTime.nextPeriod();
            this.overnight();
        }
        else {
            adjustTime.nextPeriod();
        }
    }

    // ------------------------------------------
    // Health stat boosting activities
    // ------------------------------------------

    // The player goes to sleep
    // Stat affects:
    // Energy += 5
    public void sleep(){
        adjustStats.sleep();
        this.advanceTime();
    }

    // The player eats something tasty
    // Stat affects:
    // Hunger += 5
    public void eat(){
        adjustStats.eat(5, 5);
        advanceTime();
    }

    // The player takes a night to play video-games (how meta)
    // Stat affects:
    // Happiness += 5
    public void gameItUp() {
        adjustStats.play();
        advanceTime();
    }

    // The player goes out for the night of moloko with his droogs (Reference: Clockwork Orange)
    // Stat affects:
    // Happiness += 8
    // Energy -= 3       (Booze always cost more than just money anyway, right?)
    public void nightOut() {
        adjustStats.nightOut();
        advanceTime();
    }

    // The player decides convenience store subs aren't cutting it anymore and wants real food.
    // Stat affects:
    // Hunger += 8
    // Energy -= 3
    public void groceryHaul() {
        adjustStats.groceryHaul();

        advanceTime();
    }

    public void study(int courseId) {
        if (courseId >= 0 && courseId < 5) {
            //do shit
        }
    }


}
