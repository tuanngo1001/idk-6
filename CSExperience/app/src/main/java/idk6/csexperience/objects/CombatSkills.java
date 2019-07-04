package idk6.csexperience.objects;

import java.util.ArrayList;

public class CombatSkills {
    private ArrayList<Skill> skillsList;

    public CombatSkills(){
        skillsList = new ArrayList<Skill>();
    }

    public ArrayList<Skill> getSkillsList(){ return skillsList; }

    public Skill getLastSkill(){ return skillsList.get(skillsList.size() - 1); }

    public void addSkill(Skill newSkill){
        skillsList.add(newSkill);
    }

    // do we have to write our own remove or we don't remove skill
    public void removeSkill(Skill skill){
        skillsList.remove(skill);
    }

    // Use to adjust the skill stat
    // The player current stat will affect user's skill stat
    public void statEffect(){}

    // Get a specific skill in the skills list by its ID
    public Skill getSkill(int sID){
        for (Skill s : skillsList){
            if (s.getID() == sID)
                return s;
        }
        return null;
    }

    public int getSize(){ return skillsList.size(); }
}
