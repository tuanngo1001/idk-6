package idk6.csexperience.CombatSkills;

public class Skill {
    private String id;
    private String description;
    private int stat;

    public Skill(String des,int stat){
        description = des;
        this.stat = stat;
    }

    public String getID(){ return id; }

    public int getStat(){
        return stat;
    }

    public String getDescription(){
        return description;
    }

    public void setStat(int newStat){
        stat = newStat;
    }

    public void setDescription(String des){
        description = des;
    }

    public void reduceStat(int value){
        stat -= value;
    }

    public void upgradeStat(int value){
        stat += value;
    }
}
