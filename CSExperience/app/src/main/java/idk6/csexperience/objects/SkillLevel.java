package idk6.csexperience.objects;

public class SkillLevel {
    private int level;

    public SkillLevel(){
        level = 1;
    }

    // Should we include the skill acquired here?
    public void levelUp(){
        if (level <= 10)
            level++;
        else
            System.out.println("Player have reached maximum skill Level!");
    }

    public void levelDown(){
        if (level > 0)
            level--;
        else
            System.out.println("Cannot level down since player is in level 0!");
    }

    public final int getLevel(){
        return level;
    }

    public void setLevel(int newLevel){ level = newLevel; }
}
