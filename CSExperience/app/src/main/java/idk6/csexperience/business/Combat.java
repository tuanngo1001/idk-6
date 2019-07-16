package idk6.csexperience.business;

import idk6.csexperience.objects.Game;
import idk6.csexperience.objects.Player;
import idk6.csexperience.objects.PlayerStats;
import idk6.csexperience.objects.Skill;

public class Combat {
    private static final int EXAM_TIME = 100;
    private static final int MAX_SKILLS = 3;

    private PlayerStats stats;
    private int energy;     // Health stats
    private int food;
    private int minSkillCost;

    private Game coreGame;
    private int cID;
    private int timer;
    private int progressGrade;
    private Player user;

    private Skill[] skillsList;

    public Combat(int cID){
        this.cID = cID;
        coreGame = Game.getCoreGame();
        user = coreGame.getPlayer();
        timer = EXAM_TIME;
        progressGrade = 0;
        skillsList = new Skill[MAX_SKILLS];

        stats = coreGame.getPlayer().getStats();
        energy = stats.getEnergy();
        food = stats.getFood();
    }

    public void decreaseTime(int amt){ timer -= amt; }

    public Skill[] getUsableSkill(){
        Skill[][] playerSkills = user.getStats().getSkillsList();
        for (int i = 0; i < MAX_SKILLS; i++)
            if (playerSkills[cID][i] != null)
                skillsList[i] = playerSkills[cID][i];
            else break;
        //minSkillCost = skillsList[0].getTimeCost();
        return skillsList;
    }

    public void useSkill(int skillNo) {
        Skill s = skillsList[skillNo];
        s.decreaseUsage();
        progressGrade += s.getStat();
        if (skillCost(s.getEnergyCost(), s.getFoodCost())){
            System.out.println();
            //End the Combat
        }
        decreaseTime(s.getTimeCost());
    }

    private boolean skillCost(int eCost, int fCost){
        energy -= eCost;
        if (energy < 0) {
            energy = 0;
            return false;
        }
        food -= fCost;
        if (food < 0){
            food = 0;
            return false;
        }
        return true;
    }

    private boolean timeCheck(){
        if (timer <= 0 || timer < minSkillCost) {
            return false;
        }
        return true;
    }

    public void setcID(int cID) { this.cID = cID; }

    public int getTimeRemaining() {
        return timer;
    }

    public void setUser(Player user) { this.user = user; }

    public Skill[] getSkillsList(){ return skillsList; }

    public int getSkillUses(int skillID){
        return skillsList[skillID].getUsage();
    }

    public PlayerStats getStats(){ return stats; }

    public int getProgressGrade() { return progressGrade; }
}
