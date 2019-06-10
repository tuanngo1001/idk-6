package idk6.csexperience.business;

import idk6.csexperience.objects.Game;
import idk6.csexperience.objects.Player;
import idk6.csexperience.objects.PlayerStats;

public class AdjustPlayerStats {
    private PlayerStats stats;
    private int energy;
    private int hunger;
    private int happiness;

    public AdjustPlayerStats(Game ourGame) {
        stats = ourGame.getPlayer().getStats();
        energy = stats.getEnergy();
        hunger = stats.getHunger();
        happiness = stats.getHappiness();
    }

    //drinking increases happiness, hunger, decreases energy
    public void drink(int quantity) {
        int DRINK_MODIFIER = 10; //this subject to change, will adjust game difficulty

        happiness += DRINK_MODIFIER * quantity;
        if(happiness > 100)
            happiness =100;
        hunger += DRINK_MODIFIER/2 * quantity;
        if(hunger > 100)
            hunger = 100;
        energy -= DRINK_MODIFIER/2 * quantity;
        if(energy < 0)
            energy = 0;

        stats.setEnergy(energy);
        stats.setHunger(hunger);
        stats.setHappiness(happiness);
    }

    // eating decreases hunger at a steady rate, increases energy. Low quality food will lower happiness
    // food quality is from 1-10
    public void eat(int quantity, int quality) {
        int FOOD_MODIFIER = 10; //subject to change, will adjust difficulty of game

        hunger = hunger - (FOOD_MODIFIER * quantity);
        energy += FOOD_MODIFIER/4 * quality;
        if(hunger < 0)
            hunger = 0;
        if(energy > 100)
            energy = 100;

        if(quality >= 6){
            //no happiness penalty
        }
        else if(quality < 6 && quality >= 3) {
            happiness -= quantity * 3;
        }
        else {
            happiness -= quantity * 5;
        }

        if(happiness < 0)
            happiness = 0;

        stats.setHappiness(happiness);
        stats.setHunger(hunger);
        stats.setEnergy(energy);
    }

    // a general method to adjust energy levels. This will be called every night and if a player decides
    // to nap instead of studying or doing some other activity.
    // quantity will normally be just 1
    public void sleep() {
        energy += 5;
        hunger += 25;
        if(hunger > 100)
            hunger =100;
        if (energy > 100)
            energy = 100;

        stats.setEnergy(energy);
        stats.setHunger(hunger);
    }

    public void play() {
        happiness += 5;
        if(happiness > 100) {
            happiness = 100;
        }

        stats.setHappiness(happiness);
    }

    public void nightOut() {
        happiness += 8;
        if(happiness > 100) {
            happiness = 100;
        }
        energy -= 3;
        if(energy < 0) {
            energy = 0;
        }
        stats.setHappiness(happiness);
        stats.setEnergy(energy);
    }

    public void groceryHaul() {
        hunger -= 8;
        if(hunger < 0) {
            hunger = 0;
        }
        energy -= 3;
        if(energy < 0) {
            energy = 0;
        }
    }

}
