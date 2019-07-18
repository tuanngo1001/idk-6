package idk6.csexperience.business;

import idk6.csexperience.objects.Game;
import idk6.csexperience.objects.Player;
import idk6.csexperience.objects.PlayerStats;
import idk6.csexperience.objects.Skill;

public class Combat {
    private static final int EXAM_TIME = 100;
    private static final int MAX_SKILLS = 3;

    private PlayerStats stats;

    private Game coreGame;
    private int cID;
    private int timer;
    private int progressGrade;
    private Player user;
    private boolean midterm;

    private Skill[] skillsList;

    public Combat(int cID){
        if (cID <= 2) midterm = true;
        else midterm = false;

        this.cID = cID % 3;
        coreGame = Game.getCoreGame();
        user = coreGame.getPlayer();
        timer = EXAM_TIME;
        progressGrade = 0;
        skillsList = new Skill[MAX_SKILLS];

        stats = coreGame.getPlayer().getStats();
    }

    public void decreaseTime(int amt){ timer -= amt; }

    public void getUsableSkill(){
        Skill[][] playerSkills = user.getStats().getSkillsList();
        for (int i = 0; i < MAX_SKILLS; i++)
            if (playerSkills[cID][i] != null)
                skillsList[i] = playerSkills[cID][i].copySkill();
            else break;
        if (midterm)
            increaseMidtermSkill();
    }

    public void useSkill(int skillNo) {
        Skill s = skillsList[skillNo];
        s.decreaseUsage();
        progressGrade += s.getStat();
        skillCost(s.getEnergyCost(), s.getFoodCost());
        decreaseTime(s.getTimeCost());
    }

    private void skillCost(int eCost, int fCost){
        int energy = coreGame.getPlayer().getStats().getEnergy() - eCost;
        if (energy < 0)
            energy = 0;
        coreGame.getPlayer().getStats().setEnergy(energy);

        int food = coreGame.getPlayer().getStats().getFood() - fCost;
        if (food < 0)
            food = 0;
        coreGame.getPlayer().getStats().setFood(food);
    }

    public void setcID(int cID) { this.cID = cID; }

    public int getTimeRemaining() {
        return timer;
    }

    public void setUser(Player user) { this.user = user; }

    public Skill[] getSkillsList(){ return skillsList; }

    public int getSkillUses(int skillID){
        if (skillsList[skillID] != null)
            return skillsList[skillID].getUses();
        else return 0;
    }

    public PlayerStats getStats(){ return stats; }

    public int getProgressGrade() { return progressGrade; }

    public String getGrade(){
        String grade = "F";
        if(progressGrade > 50 && progressGrade <= 60){
            grade = "D";
        }else if(progressGrade > 60 && progressGrade <= 65){
            grade = "C";
        }else if(progressGrade > 65 && progressGrade <= 70) {
            grade = "C+";
        }else if(progressGrade > 70 && progressGrade <= 75) {
            grade = "B";
        }else if(progressGrade > 75 && progressGrade <= 80) {
            grade = "B+";
        }else if(progressGrade > 80 && progressGrade <= 90) {
            grade = "A";
        }else if(progressGrade > 90) {
            grade = "A+";
        }

        return grade;
    }

    public int getSkillStat(int skillID) {
        if (skillsList[skillID] != null)
            return skillsList[skillID].getStat();
        else return 0;
    }

    public int getSkillEnergyCost(int skillID){
        if (skillsList[skillID] != null)
            return skillsList[skillID].getEnergyCost();
        else return 0;
    }

    public int getSkillFoodCost(int skillID){
        if (skillsList[skillID] != null)
            return skillsList[skillID].getFoodCost();
        else return 0;
    }

    public void increaseMidtermSkill(){
        int knowledge = stats.getKnowledge(cID);
        if (knowledge > 1 && knowledge < 5) {
            skillsList[0].upgradeStat(13);
            skillsList[0].setTimeCost(30);
            skillsList[0].setEnergyCost(20);
            skillsList[0].setFoodCost(10);
        }
        else if (knowledge >= 5 && knowledge < 7){
            skillsList[0].upgradeStat(8);
            skillsList[0].setTimeCost(20);
            skillsList[0].setEnergyCost(15);
            skillsList[0].setFoodCost(8);

            skillsList[1].upgradeStat(2);
            skillsList[1].setTimeCost(25);
            skillsList[1].setEnergyCost(20);
            skillsList[1].setFoodCost(15);
        }
        else if (knowledge >= 7 && knowledge < 10) {
            skillsList[0].upgradeStat(2);
            skillsList[0].setTimeCost(18);
            skillsList[0].setEnergyCost(12);
            skillsList[0].setFoodCost(5);

            skillsList[1].upgradeStat(10);
            skillsList[1].setTimeCost(25);
            skillsList[1].setEnergyCost(20);
            skillsList[1].setFoodCost(15);
        }
    }
}
