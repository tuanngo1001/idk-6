package idk6.csexperience.business;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class CombatTest {

    @Test
    public void testTimeRemaining(){
        System.out.println("Starting testTimeRemaining: ");
        Combat mockCombat = mock(Combat.class);
        int timeRemain = mockCombat.getTimeRemaining();
        mockCombat.decreaseTime(20);
        verify(mockCombat).decreaseTime(20);
        when(mockCombat.getTimeRemaining()).thenReturn(timeRemain-20);
        System.out.println("Finished testTimeRemaining.\n");
    }


    @Test
    public void testGetUsableSkill(){
        System.out.println("Starting testGetUsableSkills:");
        Combat mockCombat = mock(Combat.class);
        mockCombat.getUsableSkill();
        verify(mockCombat).getUsableSkill();
        System.out.println("Finished testGetUsableSkills.\n");
    }
    @Test
    public void testUseSkill(){
        System.out.println("Starting testUseSkills:");
        Combat mockCombat = mock(Combat.class);
        mockCombat.useSkill(1);
        verify(mockCombat).useSkill(1);
        System.out.println("Finished testUseSkills.\n");
    }

    @Test
    public void testGetGrade(){
        System.out.println("Starting testGetGrade:");
        Combat mockCombat = mock(Combat.class);
        int progressGrade = mockCombat.getProgressGrade();
        mockCombat.getGrade();
        verify(mockCombat).getGrade();
        verify(mockCombat).getProgressGrade();
        if(progressGrade > 50 && progressGrade <= 60){
            when(mockCombat.getGrade()).thenReturn("D");
        }else if(progressGrade > 60 && progressGrade <= 65){
            when(mockCombat.getGrade()).thenReturn("C");
        }else if(progressGrade > 65 && progressGrade <= 70) {
            when(mockCombat.getGrade()).thenReturn("C+");
        }else if(progressGrade > 70 && progressGrade <= 75) {
            when(mockCombat.getGrade()).thenReturn("B");
        }else if(progressGrade > 75 && progressGrade <= 80) {
            when(mockCombat.getGrade()).thenReturn("B+");
        }else if(progressGrade > 80 && progressGrade <= 90) {
            when(mockCombat.getGrade()).thenReturn("A");
        }else if(progressGrade > 90) {
            when(mockCombat.getGrade()).thenReturn("A+");
        }
        System.out.println("Finished testGetGrade.\n");
    }
    @Test
    public void testGetSkillUses(){
        System.out.println("Starting testGetSkillUses:");
        Combat mockCombat = mock(Combat.class);
        mockCombat.useSkill(1);
        verify(mockCombat).useSkill(1);
        //No skill ID is 10000
        when(mockCombat.getSkillUses(0)).thenReturn(0);
        System.out.println("Finished testUseSkills.\n");
    }
}
