package idk6.csexperience.objects;

import java.util.ArrayList;

public class CombatSkills {
    private ArrayList<Skill> skillsList;
    private int size;

    public CombatSkills(){
        skillsList = new ArrayList<Skill>();
        size = 0;
    }

    public ArrayList getSkillsList(){ return skillsList; }

    public Skill getLastSkill(){ return skillsList.get(size - 1); }

    public void addSkill(Skill newSkill){
        skillsList.add(newSkill);
        size++;
    }

    // do we have to write our own remove or we don't remove skill
    public void removeSkill(Skill skill){
        skillsList.remove(skill);
        size--;
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

    public int getSize(){ return size; }
}
