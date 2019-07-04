package idk6.csexperience.objects;

public class PlayerStats {
    // Constants:
    public static final int INITIAL_ENERGY = 50;
    public static final int INITIAL_FOOD = 50;
    public static final int INITIAL_HAPPINESS = 50;
    public static final int INITIAL_MONEY = 50;
    public static final int INITIAL_KNOWLEDGE = 1;

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
        energy = INITIAL_ENERGY;
        food = INITIAL_FOOD;
        happiness = INITIAL_HAPPINESS;
        money = INITIAL_MONEY;
        databasesKnowledge = INITIAL_KNOWLEDGE;
        aiKnowledge = INITIAL_KNOWLEDGE;
        graphicsKnowledge = INITIAL_KNOWLEDGE;
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

    @Override
    public String toString(){
        return "Stats:\n" + energy + ", " + food + ", " + happiness;
    }


}
