package idk6.csexperience.objects;

import org.junit.Test;

import static org.junit.Assert.*;

import idk6.csexperience.objects.SkillLevel;

public class SkillLevelTest {
    @Test
    public void testSL1(){
        System.out.println("Starting testSkillLevel");
        SkillLevel sl = new SkillLevel();
        assertNotNull("Should not be Null",sl);
        assertEquals("The initial level should be 1",1,sl.getLevel());

        sl.levelUp();
        assertEquals("Should level up by 1",2,sl.getLevel());

        sl.levelDown();
        assertEquals("Should level down by 1",1,sl.getLevel());

        System.out.println("Finished testSkillLevel\n");

    }
}
