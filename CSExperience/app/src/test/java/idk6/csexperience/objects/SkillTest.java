package idk6.csexperience.objects;

import org.junit.Test;

import static org.junit.Assert.*;

import idk6.csexperience.objects.Skill;

public class SkillTest {

    @Test
    public void testSkillTest1(){
        System.out.println("Starting testSkill");

        Skill s = new Skill(0,0,"skill 1",10);
        assertNotNull("Should not be Null",s);

        s.upgradeStat(10);
        assertEquals("The new stat should be increased by 10",20,s.getStat());

        s.reduceStat(5);
        assertEquals("The new stat should be reduced by 5",15,s.getStat());

        System.out.println("Finished testSkill\n");
    }
}
