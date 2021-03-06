package idk6.csexperience.objects;

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

        // skills that user has acquired during studying
        skills = new CombatSkills();

        // add all skill into a skills list
        allSkill = new CombatSkills();
        setupAllSkill();
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

    public int getKnowledge(int cID){
        if (cID == 0)
            return databasesKnowledge;
        else if (cID == 1)
            return aiKnowledge;
        else
            return graphicsKnowledge;
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
        upgradeSkill(0, this.databasesKnowledge);
    }

    public void setAiKnowledge(int aiKnowledge) {
        this.aiKnowledge = aiKnowledge;
        upgradeSkill(1, this.aiKnowledge);
    }

    public void setGraphicsKnowledge(int graphicsKnowledge) {
        this.graphicsKnowledge = graphicsKnowledge;
        upgradeSkill(2, this.graphicsKnowledge);
    }

    // pull out skills from skill list and add into the player skills or increase the player skill uses
    private void upgradeSkill(int cID, int knowledgeLevel){
        if (knowledgeLevel == 2)
            addSkill(allSkill.getSkill(cID,0));

        else if (knowledgeLevel == 3 || knowledgeLevel == 4) {
            if (skills.getSkill(cID, 0) != null)
                skills.getSkill(cID, 0).increaseUsage();
        }

        else if (knowledgeLevel == 5)
            addSkill(allSkill.getSkill(cID,1));

        else if (knowledgeLevel == 7) {
            if (skills.getSkill(cID, 1) != null)
                skills.getSkill(cID, 1).increaseUsage();
        }

        else if (knowledgeLevel == 10)
            addSkill(allSkill.getSkill(cID,2));
    }

    private void setupAllSkill(){
        allSkill.addSkill(new Skill(0,0,"course DB - Math skill", 10,10, 5,10));
        allSkill.addSkill(new Skill(0,1,"course DB - Logic skill", 20,15, 10,20));
        allSkill.addSkill(new Skill(0,2,"course DB - Code skill", 30,25,20,40));
        allSkill.addSkill(new Skill(1,0,"course AI - Math skill", 10,10,5,10));
        allSkill.addSkill(new Skill(1,1,"course AI - Logic skill", 20,15,10,20));
        allSkill.addSkill(new Skill(1,2,"course AI - Code skill", 30,25,20,40));
        allSkill.addSkill(new Skill(2,0,"course GP - Math skill", 10,10,5,10));
        allSkill.addSkill(new Skill(2,1,"course GP - Logic skill", 20,15,10,20));
        allSkill.addSkill(new Skill(2,2,"course GP - Code skill", 30,25,20,40));
    }

    @Override
    public String toString(){
        return "Stats:\n" + energy + ", " + food + ", " + happiness;
    }


}
