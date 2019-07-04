package idk6.csexperience.business;

import java.util.ArrayList;

import idk6.csexperience.objects.CombatSkills;
import idk6.csexperience.objects.Game;
import idk6.csexperience.objects.Player;
import idk6.csexperience.objects.Skill;

public class Combat {
    private Game coreGame;
    private int cID;
    private int timer;
    private Player user;
    private int progressBar;
    private String rating;
    private ArrayList<Skill> skillsList;

    public Combat(int cID){
        this.cID = cID;
        coreGame = Game.getCoreGame();
        user = coreGame.getPlayer();
        timer = 90;
        progressBar = 0;
        rating = "F";
        skillsList = new ArrayList<>();
    }

    private void decreaseTime(){ timer -= 10; }

    private void getUsableSkill(){
        ArrayList<Skill> playerSkills = user.getStats().getSkillsList();
        for (Skill s : playerSkills){
            if (s.getCourseID() == cID)
                skillsList.add(s.copySkill());
        }
    }

    private void useSkill(Skill s){ }

    public void DoCombat(){
        getUsableSkill();

        while (timer > 0){

            decreaseTime();
        }
    }
}
