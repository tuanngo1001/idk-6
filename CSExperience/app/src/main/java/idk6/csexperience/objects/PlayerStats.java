package idk6.csexperience.objects;

import android.os.Parcel;
import android.os.Parcelable;

public class PlayerStats {
    private int energy;
    private int food;
    private int happiness;
    private int money;

    // Class knowledge
    // Right now there are only 3 courses. When we add difficulty there will be 5.
    private int databasesKnowledge;
    private int aiKnowledge;
    private int graphicsKnowledge;


    public PlayerStats() {
        energy = 50;
        food = 50;
        happiness = 50;
        money = 50;

        databasesKnowledge = 1;
        aiKnowledge = 1;
        graphicsKnowledge = 1;
    }

    public int getMoney() { return money; }

    public void changeMoney(int change) { money += change; }

    public void setMoney(int newMoney) { money = newMoney; }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int newHappiness) {
        happiness = newHappiness;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int newEnergy) {
        energy = newEnergy;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int newFood) {
        food = newFood;
    }

    public int getDatabasesKnowledge() {
        return databasesKnowledge;
    }

    public int getAiKnowledge() {
        return aiKnowledge;
    }

    public int getGraphicsKnowledge() {
        return graphicsKnowledge;
    }

    public void setDatabasesKnowledge(int databasesKnowledge) {
        this.databasesKnowledge = databasesKnowledge;
    }

    public void setAiKnowledge(int aiKnowledge) {
        this.aiKnowledge = aiKnowledge;
    }

    public void setGraphicsKnowledge(int graphicsKnowledge) {
        this.graphicsKnowledge = graphicsKnowledge;
    }

    protected PlayerStats(Parcel in) {
        energy = in.readInt();
        food = in.readInt();
        happiness = in.readInt();
    }
}