package idk6.csexperience.business;

import idk6.csexperience.objects.CombatSkills;
import idk6.csexperience.objects.Game;
import idk6.csexperience.objects.Player;
import idk6.csexperience.objects.PlayerStats;
import idk6.csexperience.objects.Skill;

public class Combat {
    private PlayerStats stats;
    private int energy;     // Health stats
    private int food;
    private int happiness;

    private Game coreGame;
    private int cID;
    private int timer;
    private Player user;

    private Skill[] skillsList;

    public Combat(int cID){
        this.cID = cID;
        coreGame = Game.getCoreGame();
        user = coreGame.getPlayer();
        timer = 90;
        skillsList = new Skill[3];

        stats = coreGame.getPlayer().getStats();
        energy = stats.getEnergy();
        food = stats.getFood();
        happiness = stats.getHappiness();
    }

    private void decreaseTime(){ timer -= 10; }

    public Skill[] getUsableSkill(int cID){
        Skill[][] playerSkills = user.getStats().getSkillsList();
        for (int i = 0; i < 3; i++)
            skillsList[i] = playerSkills[cID][i];
        return skillsList;
    }

    public void useSkill(int skillNo){
        Skill s = skillsList[skillNo];
        s.decreaseUsage();
        if (skillCost(s.getEnergyCost(),s.getFoodCost()))
            System.out.println();
            //End Game
        decreaseTime();
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
}
