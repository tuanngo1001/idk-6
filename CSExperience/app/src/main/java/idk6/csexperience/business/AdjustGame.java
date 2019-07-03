package idk6.csexperience.business;

import idk6.csexperience.objects.Calendar;
import idk6.csexperience.objects.Player;
import idk6.csexperience.objects.Game;

public class AdjustGame {
    private Game game;
    private Calendar calendar;
    private Player player;
    private AdjustPlayerStats adjustStats;
    private AdjustCalendar adjustCalendar;

    public AdjustGame(Game ourGame) {
        game = ourGame;
        this.calendar = ourGame.getCalendar();
        this.player = ourGame.getPlayer();
        adjustStats = new AdjustPlayerStats(ourGame);
        adjustCalendar = new AdjustCalendar(ourGame);
    }

    // Advance time by one time slot (
    public void advanceTime() {
        adjustCalendar.nextPeriod();
    }

    // ------------------------------------------
    // Health stat boosting activities
    // ------------------------------------------

    // The player goes to sleep
    // Stat affects:
    // Energy += 50
    public void sleep(){
        adjustStats.sleep();
        this.advanceTime();
    }

    // The player eats something tasty
    // Stat affects:
    // Food += 50
    public void eat(){
        adjustStats.eat();
        advanceTime();
    }

    // The player takes a night to play video-games (how meta)
    // Stat affects:
    // Happiness += 50
    public void gameItUp() {
        adjustStats.play();
        advanceTime();
    }

    // The player goes out for the night of moloko with his droogs (Reference: Clockwork Orange)
    // Stat affects:
    // Happiness += 80
    // Energy -= 30       (Booze always cost more than just money anyway, right?)
    public void nightOut() {
        adjustStats.nightOut();
        advanceTime();
    }

    // The player decides convenience store subs aren't cutting it anymore and wants real food.
    // Stat affects:
    // Food += 80
    // Energy -= 30
    public void groceryHaul() {
        adjustStats.groceryHaul();
        advanceTime();
    }

    // The player takes the biggest nap of their life but loses an extra time slot
    // Stat affectsL
    // Energy += 100
    // Food -= 30
    public void superSleep() {
        adjustStats.superSleep();
        advanceTime();
        advanceTime();
    }

    public void studyDB() {
        adjustStats.studyDatabases();
        advanceTime();
    }

    public void cheggDB() {
        adjustStats.studyDatabases();
    }

    public void studyAI() {
        adjustStats.studyAi();
        advanceTime();
    }

    public void cheggAI() {
        adjustStats.studyAi();
    }

    public void studyGraphics() {
        adjustStats.studyGraphics();
        advanceTime();
    }

    public void cheggGraphics() {
        adjustStats.studyGraphics();
    }


    public boolean buyCoffee() {
        return adjustStats.buyCoffee();
    }

    public boolean useChegg() {
        return adjustStats.useChegg();
    }

    public boolean buyBeer() {
        return adjustStats.buyBeer();
    }

    //----------------------------------------------------------------------------------------------
    //ADDING FOR JOB:
    public boolean waiterWaitress () {
        boolean canDo;
        canDo = adjustStats.doServer();
        if(canDo){
            this.player.getStats().changeMoney(15);
            advanceTime();
            return true;
        }
        else{
            return false;
        }
    }

    public boolean cashier() {
        boolean canDo;
        canDo = adjustStats.doCashier();
        if(canDo){
            this.player.getStats().changeMoney(17);
            advanceTime();
            return true;
        }
        else{
            return false;
        }
    }

    public boolean delivery() {
        boolean canDo;
        canDo = adjustStats.doDelivering();
        if(canDo){
            this.player.getStats().changeMoney(20);
            advanceTime();
            return true;
        }
        else{
            return false;
        }
    }

}
