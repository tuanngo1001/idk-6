package idk6.csexperience.business;

import idk6.csexperience.objects.CombatSkills;
import idk6.csexperience.objects.Game;
import idk6.csexperience.objects.Player;
import idk6.csexperience.objects.Skill;

public class Combat {
    private Game coreGame;
    private int timer;
    private Player user;
    private int progressBar;
    private String rating;
    private CombatSkills skillsList;

    public Combat(){
        this.coreGame = Game.getCoreGame();
        user = coreGame.getPlayer();
        timer = 90;
        progressBar = 0;
        rating = "F";
        skillsList = user.getStats().getSkillsList();
    }

    private void decreaseTime(){ timer -= 10; }

    private void useSkill(Skill s){ }

    public void DoCombat(){
        while (timer > 0){

            decreaseTime();
        }
    }
}
