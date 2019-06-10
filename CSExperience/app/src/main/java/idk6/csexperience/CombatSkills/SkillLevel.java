package idk6.csexperience.CombatSkills;

public class SkillLevel {
    private int level;

    public SkillLevel(){
        level = 1;
    }

    // Should we include the skill acquired here?
    public void levelUp(){
        if (level <= 10) {
            level++;
            if (level == 5)
                System.out.println("Acquire skill no 1.");

            else if (level == 10)
                System.out.println("Acquire skill no 2.");
        }
        else
            System.out.println("Player have reached maximum skill Level!");
    }

    public final int getLevel(){
        return level;
    }
}
