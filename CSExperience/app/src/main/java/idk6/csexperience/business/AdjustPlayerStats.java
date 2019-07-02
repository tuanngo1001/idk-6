package idk6.csexperience.business;

import idk6.csexperience.objects.Game;
import idk6.csexperience.objects.Player;
import idk6.csexperience.objects.PlayerStats;


// This class is used to adjusted to health-related stats and course knowledge of the player

public class AdjustPlayerStats {
    private PlayerStats stats;

    private int energy;     // Health stats
    private int food;
    private int happiness;
    private int money;

    int databasesKnowledge; // Course stats
    int aiKnowledge;
    int graphicsKnowledge;


    public AdjustPlayerStats(Game ourGame) {
        stats = ourGame.getPlayer().getStats();
        energy = stats.getEnergy();
        food = stats.getFood();
        happiness = stats.getHappiness();
        money = stats.getMoney();

        databasesKnowledge = stats.getDatabasesKnowledge();
        aiKnowledge = stats.getAiKnowledge();
        graphicsKnowledge = stats.getGraphicsKnowledge();
    }


    // ------------------------------------------------------
    // HEALTH STATS MODIFIERS
    // ------------------------------------------------------

    public void eat() {
        food += 50;

        if(food > 100)
            food = 100;

        stats.setFood(food);
    }

    public void sleep() {
        energy += 50;
        food -= 20;
        if(food < 0)
            food = 0;
        if (energy > 100)
            energy = 100;

        stats.setEnergy(energy);
        stats.setFood(food);
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
        food += 80;
        if(food > 100) {
            food = 100;
        }
        energy -= 30;
        if(energy < 0) {
            energy = 0;
        }
        stats.setFood(food);
        stats.setEnergy(energy);
    }

    public void superSleep() {
        energy += 100;
        if(energy > 100) {
            energy = 100;
        }

        food -= 30;
        if(food < 0) {
            food = 0;
        }

        stats.setFood(food);
        stats.setEnergy(energy);
    }


    // ------------------------------------------------------
    // COURSE KNOWLEDGE MODIFIERS
    // ------------------------------------------------------

    public void studyDatabases(){
        databasesKnowledge++;
        if(databasesKnowledge > 10)
            databasesKnowledge = 10;

        studyHealthCost();

        stats.setDatabasesKnowledge(databasesKnowledge);
    }

    public void studyAi(){
        aiKnowledge++;
        if(aiKnowledge > 10)
            aiKnowledge = 10;

        studyHealthCost();

        stats.setAiKnowledge(aiKnowledge);
    }

    public void studyGraphics(){
        graphicsKnowledge++;
        if(graphicsKnowledge > 10)
            graphicsKnowledge = 10;

        studyHealthCost();

        stats.setGraphicsKnowledge(graphicsKnowledge);
    }

    // ------------------------------------------------------
    // PURCHASABLE ITEM MODIFIERS
    // ------------------------------------------------------

    public boolean buyCoffee() {
        if (money < 5) {
            return false;
        }
        else {
            money -= 5;
            energy += 15;
            food -= 10; //coffee makes you hungry?
        }

        updateStats();
        return true;
    }

    public boolean buyBeer() {
        if (money < 7) {
            return false;
        }
        else {
            money -= 7;
            energy -= 15;
            food -= 15;
            happiness += 30;
        }
        updateStats();
        return true;
    }

    public boolean useChegg() {
        if (money < 25) {
            return false;
        }
        else {
            money -= 25;
            //some sort of study benefit;
        }
        updateStats();
        return true;
    }

    private void studyHealthCost(){
        // Study isn't free...

        happiness -= 20;
        if(happiness < 0)
            happiness = 0;

        energy -= 15;
        if(energy < 0)
            energy = 0;

        food -= 8;
        if(food < 0 )
            food = 0;

        stats.setHappiness(happiness);
        stats.setEnergy(energy);
        stats.setFood(food);
    }

    private void updateStats() {
        stats.setHappiness(happiness);
        stats.setEnergy(energy);
        stats.setFood(food);
        stats.setMoney(money);
    }
    public int getHappiness() { return happiness; }

    public int getFood() { return food; }

    public int getEnergy() { return energy; }

    public int getAiKnowledge() { return aiKnowledge; }

    public int getDatabasesKnowledge() { return databasesKnowledge; }

    public int getGraphicsKnowledge() { return graphicsKnowledge; }

    public void setAllToZero(){
        happiness = 0;
        food = 0;
        energy = 0;
        aiKnowledge = 0;
        databasesKnowledge = 0;
        graphicsKnowledge = 0;
    }
} // end AdjustPlayerStats

