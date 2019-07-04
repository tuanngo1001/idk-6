package idk6.csexperience.objects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class PlayerStats {
    private int energy;
    private int food;
    private int happiness;

    // Class knowledge
    // Right now there are only 3 courses. When we add difficulty there will be 5.
    private int databasesKnowledge;
    private int aiKnowledge;
    private int graphicsKnowledge;

    // Combat instance
    private CombatSkills skills;

    //all of the skills that a player can acquire
    private Skill[][] allSkill;

    public PlayerStats() {
        energy = 50;
        food = 50;
        happiness = 50;

        databasesKnowledge = 1;
        aiKnowledge = 1;
        graphicsKnowledge = 1;

        skills = new CombatSkills();

        allSkill = new Skill[3][3];

        allSkill[0][0] = (new Skill(1,11,"course 1 skill no 1", 100));
        allSkill[0][1] = (new Skill(1,12,"course 1 skill no 2", 200));
        allSkill[0][2] = (new Skill(1,13,"course 1 skill no 3", 300));
        allSkill[1][0] = (new Skill(2,21,"course 2 skill no 1", 100));
        allSkill[1][1] = (new Skill(2,22,"course 2 skill no 2", 200));
        allSkill[1][2] = (new Skill(2,23,"course 2 skill no 3", 300));
        allSkill[2][0] = (new Skill(3,31,"course 3 skill no 1", 100));
        allSkill[2][1] = (new Skill(3,32,"course 3 skill no 2", 200));
        allSkill[2][2] = (new Skill(3,33,"course 3 skill no 3", 300));

    }

    public ArrayList<Skill> getSkillsList(){ return skills.getSkillsList(); }

    public void addSkill(Skill newSkill){ skills.addSkill(newSkill); }

    public Skill getSkill(int id){ return skills.getSkill(id); }

    public Skill getNewSkill(int cID, int skillNo){ return allSkill[cID][skillNo]; }

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
            addSkill(allSkill[0][0]);
        else if (databasesKnowledge == 5)
            addSkill(allSkill[0][1]);
        else if (databasesKnowledge == 10)
            addSkill(allSkill[0][2]);
    }

    public void setAiKnowledge(int aiKnowledge) {
        this.aiKnowledge = aiKnowledge;
        if (aiKnowledge == 2)
            addSkill(allSkill[1][0]);
        else if (aiKnowledge == 5)
            addSkill(allSkill[1][1]);
        else if (aiKnowledge == 10)
            addSkill(allSkill[1][2]);
    }

    public void setGraphicsKnowledge(int graphicsKnowledge) {
        this.graphicsKnowledge = graphicsKnowledge;
        if (graphicsKnowledge == 2)
            addSkill(allSkill[2][0]);
        else if (graphicsKnowledge == 5)
            addSkill(allSkill[2][1]);
        else if (graphicsKnowledge == 10)
            addSkill(allSkill[2][2]);
    }

    protected PlayerStats(Parcel in) {
        energy = in.readInt();
        food = in.readInt();
        happiness = in.readInt();
    }
}