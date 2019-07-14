package idk6.csexperience.objects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

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

    // Combat instance
    private CombatSkills skills;

    //all of the skills that a player can acquire
    private CombatSkills allSkill;

    public PlayerStats() {
        energy = INITIAL_ENERGY;
        food = INITIAL_FOOD;
        happiness = INITIAL_HAPPINESS;
        money = INITIAL_MONEY;
        databasesKnowledge = INITIAL_KNOWLEDGE;
        aiKnowledge = INITIAL_KNOWLEDGE;
        graphicsKnowledge = INITIAL_KNOWLEDGE;

        skills = new CombatSkills();

        allSkill = new CombatSkills();
        
        allSkill.addSkill(new Skill(0,0,"course 1 skill no 1", 100,10, 5));
        allSkill.addSkill(new Skill(0,1,"course 1 skill no 2", 200,15, 10));
        allSkill.addSkill(new Skill(0,2,"course 1 skill no 3", 300,25,20));
        allSkill.addSkill(new Skill(1,0,"course 2 skill no 1", 100,10,5));
        allSkill.addSkill(new Skill(1,1,"course 2 skill no 2", 200,15,10));
        allSkill.addSkill(new Skill(1,2,"course 2 skill no 3", 300,25,20));
        allSkill.addSkill(new Skill(2,0,"course 3 skill no 1", 100,10,5));
        allSkill.addSkill(new Skill(2,1,"course 3 skill no 2", 200,15,10));
        allSkill.addSkill(new Skill(2,2,"course 3 skill no 3", 300,25,20));

    }

    public Skill[][] getSkillsList(){ return skills.getSkillsList(); }

    public void addSkill(Skill newSkill){ skills.addSkill(newSkill); }

    public Skill getSkill(int courseID, int skillID){ return skills.getSkill(courseID,skillID); }

    public Skill getNewSkill(int cID, int skillNo){ return allSkill.getSkill(cID,skillNo); }

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
        if (databasesKnowledge == 2)
            addSkill(allSkill.getSkill(0,0));
        else if (databasesKnowledge == 5)
            addSkill(allSkill.getSkill(0,1));
        else if (databasesKnowledge == 10)
            addSkill(allSkill.getSkill(0,2));
    }

    public void setAiKnowledge(int aiKnowledge) {
        this.aiKnowledge = aiKnowledge;
        if (aiKnowledge == 2)
            addSkill(allSkill.getSkill(1,0));
        else if (aiKnowledge == 5)
            addSkill(allSkill.getSkill(1,1));
        else if (aiKnowledge == 10)
            addSkill(allSkill.getSkill(1,2));
    }

    public void setGraphicsKnowledge(int graphicsKnowledge) {
        this.graphicsKnowledge = graphicsKnowledge;
        if (graphicsKnowledge == 2)
            addSkill(allSkill.getSkill(2,0));
        else if (graphicsKnowledge == 5)
            addSkill(allSkill.getSkill(2,1));
        else if (graphicsKnowledge == 10)
            addSkill(allSkill.getSkill(2,2));
    }

    protected PlayerStats(Parcel in) {
        energy = in.readInt();
        food = in.readInt();
        happiness = in.readInt();
    }
}