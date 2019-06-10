package idk6.csexperience.CombatSkills;

import java.util.ArrayList;

import idk6.csexperience.objects.*;

public class CombatSkills {
    private Player user;
    private ArrayList<Skill> skillsList;
    //private SkillLevel level;

    public CombatSkills(Player user){
        this.user = user;
        skillsList = new ArrayList<Skill>();
        //level = new SkillLevel();
    }

    public void setUser(Player newUser){
        user = newUser;
    }

    public void addSkill(Skill newSkill){
        skillsList.add(newSkill);
    }

    // do we have to write our own remove or we don't remove skill
    public void removeSkill(Skill skill){
        skillsList.remove(skill);
    }

    public void statEffect(){}
}
