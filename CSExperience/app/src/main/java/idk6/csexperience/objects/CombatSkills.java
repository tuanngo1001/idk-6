package idk6.csexperience.objects;

public class CombatSkills {
    private Skill[][] skillsList;
    private int totalSkill;

    public CombatSkills(){
        skillsList = new Skill[3][3];
        totalSkill = 0;
    }

    public Skill[][] getSkillsList(){ return skillsList; }

    public void addSkill(Skill newSkill){
        int cID = newSkill.getCourseID();
        int sID = newSkill.getID();
        skillsList[cID][sID] = newSkill;
        totalSkill++;
    }

    // Get a specific skill in the skills list by its ID
    public Skill getSkill(int cID,int sID){
        return skillsList[cID][sID];
    }

    public int getSize(){ return totalSkill; }
}
