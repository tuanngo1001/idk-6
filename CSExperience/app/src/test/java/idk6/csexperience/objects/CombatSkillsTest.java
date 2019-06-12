package idk6.csexperience.objects;

import org.junit.Test;

import static org.junit.Assert.*;

import idk6.csexperience.objects.CombatSkills;

public class CombatSkillsTest {
    @Test
    public void testCS1(){
        CombatSkills cs = new CombatSkills();
        assertNotNull("Should not be Null",cs);

        cs.addSkill(new Skill(0,0,"skill 1",10));
        assertEquals("The size should be 1",1,cs.getSize());

        cs.addSkill(new Skill(1,1,"Skill 2",20));
        cs.removeSkill(cs.getSkill(0));
        assertEquals("Should contain 1 skill",1,cs.getSize());

    }
}
