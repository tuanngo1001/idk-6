package idk6.csexperience.business;

import idk6.csexperience.objects.*;


// This class holds methods for manipulate the player's stats/knowledge and advancing the time of
// day. It also holds methods for the jobs that they can take, since money is really just another
// kind of player stat.

// NOTE: We need to add limits and tests to make sure that maximum and minimum stat/skill boundaries
//       are never violated. Yay testing!

public class Activity {

    private Game game;  // We need this to update both player stats and play time
    private Player player;
    private Time time;

    public Activity(Game game){
        this.game = game;
        player = game.getPlayer();
        time = game.getTime();
    }


    // Advance time by one time slot (and roll over into the next day if need be)
    // Note that time period is either 1 or 2.
    public void advanceTime(){
        int day = time.getDay();
        int period = time.getPeriod();

        period++;   // advance time...

        int rollover = period % 3;  // Has time rolled over into the day?

        if (rollover == 0){     // If so...
            day++;
            time.setDay(day);
            time.setPeriod(1);
        }
        else{   // Still the same day
            time.setPeriod(period);
        }
    }


    // ------------------------------------------
    // Health stat boosting activities
    // ------------------------------------------

    // The player goes to sleep
    // Stat affects:
    // Energy += 5
    public void sleep(){
        int currentEnergy =  player.getStats().getEnergy();
        player.getStats().setEnergy(currentEnergy + 5);
        advanceTime();
    }

    // The player eats something tasty
    // Stat affects:
    // Hunger += 5
    public void eat(){
        int currentHunger = player.getStats().getHunger();
        player.getStat().setHunger(currentHunger + 5);
        advanceTime();
    }

    // The player takes a night to play video-games (how meta)
    // Stat affects:
    // Happiness += 5
    public void gameItUp(){
        int currentHappiness = player.getStats().getHappiness();
        player.getStats().setHappiness(currentHappiness + 5);
        advanceTime();
    }

    // The player goes out for the night of moloko with his droogs (Reference: Clockwork Orange)
    // Stat affects:
    // Happiness += 8
    // Energy -= 3       (Booze always cost more than just money anyway, right?)
    public void nightOut(){
        int currentHappiness = player.getStats().getHappiness();
        player.getStats().setHappiness(currentHappiness + 8);

        int currentEnergy =  player.getStats().getEnergy();
        player.getStats().setEnergy(currentEnergy - 3);
        advanceTime();
    }

    // The player decides convenience store subs aren't cutting it anymore and wants real food.
    // Stat affects:
    // Hunger += 8
    // Energy -= 3
    public void groceryHaul(){
        int currentHunger = player.getStats().getHunger();
        player.getStats().setHappiness(currentHunger + 8);

        int currentEnergy =  player.getStats().getEnergy();
        player.getStats().setEnergy(currentEnergy - 3);
        advanceTime();
    }

    // The player gets the kind of sleep that is only possible on a Purple mattress (thanks Gino)
    // Stat affects:
    // Energy += 10         Max it out, boy!
    // Happiness += 10
    // Hunger -= 3          Wake up craving something awful no doubt
    // Time += 1            Time advances one slot more than normal
    public void superSleep(){
        int currentEnergy =  player.getStats().getEnergy();
        player.getStats().setEnergy(currentEnergy + 10);

        int currentHappiness = player.getStats().getHappiness();
        player.getStats().setHappiness(currentHappiness + 10);

        int currentHunger = player.getStats().getHunger();
        player.getStats().setHappiness(currentHunger - 3);

        advanceTime();
        advanceTime();  // Was it worth it?
    }


    // ------------------------------------------------
    // Course knowledge boosting activities (studying)
    // ------------------------------------------------



} // end Activity
