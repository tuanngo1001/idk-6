package idk6.csexperience.CombatSkills;

import java.util.ArrayList;

import idk6.csexperience.objects.*;

public class CombatSkills {
    private ArrayList<Skill> skillsList;
    //private SkillLevel level;

    public CombatSkills(){
        skillsList = new ArrayList<Skill>();
        //level = new SkillLevel();
    }

    public ArrayList getSkillsList(){ return skillsList; }

    public void addSkill(Skill newSkill){
        skillsList.add(newSkill);
    }

    // do we have to write our own remove or we don't remove skill
    public void removeSkill(Skill skill){
        skillsList.remove(skill);
    }

    public void statEffect(){}

    public Skill getSkill(String sID){
        for (Skill s : skillsList){
            if (s.getID().equals(sID))
                return s;
        }
        return null;
    }
}
