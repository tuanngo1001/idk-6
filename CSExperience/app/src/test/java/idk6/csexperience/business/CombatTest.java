package idk6.csexperience.business;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import idk6.csexperience.business.Combat;
import idk6.csexperience.objects.Player;

public class CombatTest {
    private Combat combat;

    @Before
    public void initial(){
        combat = new Combat(0);
    }

    @Test
    public void testTimeRemaining(){
        System.out.println("Starting testTimeRemaining: ");
        combat.decreaseTime(20);
        assertEquals("Time remaining should be 70",70,combat.getTimeRemaining());

        System.out.println("Finished testTimeRemaining.\n");
    }

    @Test
    public void testGetSkills(){
        System.out.println("Starting testGetSkills:");
        Player testUser = new Player();
        testUser.getStats().acquireAllSkills();
        combat.setUser(testUser);
        combat.getUsableSkill();
        assertEquals("Skills number should be 3",3,combat.getSkillsList().length);
        System.out.println("Finished testGetSkills.\n");
    }

    @Test
    public void testUseSkill(){
        System.out.println("Starting testUseSkill:");

        Player testUser = new Player();
        testUser.getStats().acquireAllSkills();
        combat.setUser(testUser);

        combat.getUsableSkill();
        combat.useSkill(0);

        System.out.println("Finished testUseSkill\n");
    }
}
