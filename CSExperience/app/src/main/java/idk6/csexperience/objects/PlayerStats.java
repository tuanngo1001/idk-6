package idk6.csexperience.objects;

import java.util.ArrayList;

import idk6.csexperience.CombatSkills.*;

public class PlayerStats {
    private int energy;
    private int hunger;
    private int happiness;


    private CombatSkills skills;

    //all of the skills that a player can acquire
    //private CombatSkills allSkill;

    private int[] classKnowledge = new int[5];


    public PlayerStats(int num_classes) {
        energy = 10;
        hunger = 10;
        happiness = 10;

        skills = new CombatSkills();
    }

    public ArrayList getSkillsList(){ return skills.getSkillsList(); }

    public void addSkill(Skill newSkill){
        skills.addSkill(newSkill);
    }

    public Skill getSkill(String id){ return skills.getSkill(id); }

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

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int newHunger) {
        hunger = newHunger;
    }

    public int getCourseKnowledge(int courseId){
        assert(courseId >= 0 && courseId <= 4);
        return classKnowledge[courseId];
    }

    public void setCourseKnowledge(int courseId, int value){
        assert(courseId >= 0 && courseId <= 4);
        classKnowledge[courseId] = value;
    }
}
