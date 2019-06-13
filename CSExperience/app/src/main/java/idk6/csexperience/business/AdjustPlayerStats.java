package idk6.csexperience.business;

import idk6.csexperience.objects.Game;
import idk6.csexperience.objects.Player;
import idk6.csexperience.objects.PlayerStats;

public class AdjustPlayerStats {
    private PlayerStats stats;
    private int energy;
    private int food;
    private int happiness;

    public AdjustPlayerStats(Game ourGame) {
        stats = ourGame.getPlayer().getStats();
        energy = stats.getEnergy();
        food = stats.getfood();
        happiness = stats.getHappiness();
    }

    //drinking increases happiness, food, decreases energy
    public void drink(int quantity) {
        int DRINK_MODIFIER = 10; //this subject to change, will adjust game difficulty

        happiness += DRINK_MODIFIER * quantity;
        if(happiness > 100)
            happiness =100;
        food += DRINK_MODIFIER/2 * quantity;
        if(food > 100)
            food = 100;
        energy -= DRINK_MODIFIER/2 * quantity;
        if(energy < 0)
            energy = 0;

        stats.setEnergy(energy);
        stats.setfood(food);
        stats.setHappiness(happiness);
    }

    // eating decreases food at a steady rate, increases energy. Low quality food will lower happiness
    // food quality is from 1-10
    public void eat(int quantity, int quality) {
        int FOOD_MODIFIER = 10; //subject to change, will adjust difficulty of game

        food = food - (FOOD_MODIFIER * quantity);
        energy += FOOD_MODIFIER/4 * quality;
        if(food < 0)
            food = 0;
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
        stats.setfood(food);
        stats.setEnergy(energy);
    }

    public void sleep() {
        energy += 50;
        food -= 20;         // It seems weird, but more food is a good thing
        if(food > 100)
            food =100;
        if (energy > 100)
            energy = 100;

        stats.setEnergy(energy);
        stats.setfood(food);
    }

    public void play() {
        happiness += 50;
        if(happiness > 100) {
            happiness = 100;
        }

        stats.setHappiness(happiness);
    }

    public void nightOut() {
        happiness += 80;
        if(happiness > 100) {
            happiness = 100;
        }
        energy -= 30;
        if(energy < 0) {
            energy = 0;
        }
        stats.setHappiness(happiness);
        stats.setEnergy(energy);
    }

    public void groceryHaul() {
        food -= 80;
        if(food < 0) {
            food = 0;
        }
        energy -= 30;
        if(energy < 0) {
            energy = 0;
        }
    }

}
