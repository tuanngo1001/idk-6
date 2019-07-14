package idk6.csexperience.objects;

public class Skill {
    private int cID;
    private int id;
    private String description;
    private int stat;
    private int usage;
    private int energyCost;
    private int foodCost;

    public Skill(int cID, int sID,String des,int stat, int energyCost, int foodCost){
        description = des;
        this.cID = cID;
        id = sID;
        this.stat = stat;
        usage = 1;
        this.energyCost = energyCost;
        this.foodCost = foodCost;
    }

    public int getCourseID(){ return cID; }

    public void setCourseID(int cID){ this.cID = cID; }

    public int getID(){ return id; }

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

    public void setUsage(int amount){ usage = amount; }

    public void increaseUsage() { usage++; }

    public void decreaseUsage() { usage--; }

    public int getEnergyCost() { return energyCost; }

    public int getFoodCost() { return foodCost; }

    public void setEnergyCost(int energyCost) { this.energyCost = energyCost; }

    public void setFoodCost(int foodCost) { this.foodCost = foodCost; }

    public Skill copySkill(){
        Skill newSkill = new Skill(cID, id, description, stat, energyCost, foodCost);
        newSkill.setUsage(usage);
        return newSkill;
    }
}
