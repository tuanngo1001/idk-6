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
    int jobSelect = 0;


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
        if (databasesKnowledge < 10)
            stats.setDatabasesKnowledge(++databasesKnowledge);
        else
            databasesKnowledge = 10;

        studyHealthCost();
    }

    public void studyAi(){
        if (aiKnowledge < 10)
            stats.setAiKnowledge(++aiKnowledge);
        else
            aiKnowledge = 10;

        studyHealthCost();
    }

    public void studyGraphics(){
        if (graphicsKnowledge < 10)
            stats.setGraphicsKnowledge(++graphicsKnowledge);
        else
            graphicsKnowledge = 10;

        studyHealthCost();
    }

    // ------------------------------------------------------
    // PURCHASABLE ITEM MODIFIERS
    // ------------------------------------------------------

    public String[] buyCoffee() {
        String[] display = new String[2];
        display[0] = "Insufficent Funds!";
        display[1] = "How embarassing...";
        if (money < 5) {
            return display;
        }
        else {
            money -= 5;
            energy += 15;
            food -= 10; //coffee makes you hungry?
            checkValues();
        }

        updateStats();
        display[0] = "Energy Increased!";
        display[1] = "Jittery Yet?";
        return display;
    }

    public String[] buyBeer() {
        String[] display = new String[2];
        display[0] = "Insufficent Funds!";
        display[1] = "How embarassing...";
        if (money < 7) {
            return display;
        }
        else {
            money -= 7;
            energy -= 15;
            food -= 15;
            happiness += 30;
            checkValues();
        }
        updateStats();
        display[0] = "Feeling Better!";
        display[1] = "But at what cost?";
        return display;
    }

    public String[] buySnack() {
        String[] display = new String[2];
        display[0] = "Insufficent Funds!";
        display[1] = "How embarassing...";
        if(money < 5){
            return display;
        }
        money -= 5;
        food += 15;
        checkValues();
        updateStats();
        display[0] = "Yum, Fries!";
        display[1] = "They count as vegetables right?";
        return display;
    }

    public String[] buyEnergyDrink() {
        String[] display = new String[2];
        display[0] = "Insufficent Funds!";
        display[1] = "How embarassing...";
        if(money <8 ) {
            return display;
        }
        money -= 8;
        energy +=25;
        checkValues();
        updateStats();
        display[0] = "Gulp!";
        display[1] = "Wow, that's genuinely disgusting.";
        return display;
    }

    public String[] useChegg() {
        String[] display = new String[2];
        display[0] = "Insufficent Funds!";
        display[1] = "How embarassing...";
        if (money < 25) {
            return display;
        }
        else {
            //money -= 25;
            //some sort of study benefit;
        }
        updateStats();
        display[0] = "'Studying' the quick way!";
        display[1] = "Pick a class to get ahead in!";
        return display;
    }

    public void payForChegg() {
        money -= 25;
        updateStats();
    }

    private void studyHealthCost(){
        // Study isn't free...

        happiness -= 20;
        energy -= 15;
        food -= 8;
        checkValues();


        stats.setHappiness(happiness);
        stats.setEnergy(energy);
        stats.setFood(food);
    }

    //ADDING FOR JOBS
    public boolean adjustServer(){
        if(happiness<20||energy<15||food<8){
            return false;
        }
        else{
            jobSelect = 1;
            workHealthCost();
            return true;
        }

    }

    public boolean adjustCashier(){
        if(happiness<15||energy<20||food<8){
            return false;
        }
        else{
            jobSelect = 2;
            workHealthCost();
            return true;
        }
    }
    public boolean adjustDelivering(){
        if(happiness<8||energy<20||food<15){
            return false;
        }
        else{
            jobSelect = 3;
            workHealthCost();
            return true;
        }
    }

    private void workHealthCost(){
        // Work isn't free...
        if(jobSelect == 1) {
            happiness -= 20;
            energy -= 15;
            food -= 8;
        }
        else if(jobSelect ==2){
            happiness -= 15;
            energy -= 20;
            food -= 8;
        }
        else if(jobSelect == 3) {
            happiness -= 8;
            energy -= 20;
            food -= 15;
        }
        if(happiness < 0){
            happiness = 0;
        }
        if(energy < 0){
            energy = 0;
        }
        if(food < 0 ){
            food = 0;
        }
        stats.setHappiness(happiness);
        stats.setEnergy(energy);
        stats.setFood(food);
    }

    //this method makes sure no values go out of range
    private void checkValues() {
        if(food > 100)
            food = 100;
        if(food < 0)
            food = 0;
        if(energy > 100)
            energy = 100;
        if(energy < 0)
            energy = 0;
        if(happiness > 100)
            happiness = 100;
        if(happiness < 0)
            happiness = 0;
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

