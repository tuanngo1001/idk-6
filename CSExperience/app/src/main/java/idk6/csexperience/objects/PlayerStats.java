package idk6.csexperience.objects;

public class PlayerStats {
    private int energy;
    private int hunger;
    private int happiness;

    private int class1_skill;
    private int class2_skill;
    private int class3_skill;
    private int class4_skill;
    private int class5_skill;

    public PlayerStats(int num_classes) {
        energy = 100;
        hunger = 0;
        happiness = 100;

        class1_skill = 0;
        class2_skill = 0;
        class3_skill = 0;
        class4_skill = 0;
        class5_skill = 0;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int newHappiness) {
        happiness = newHappiness;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int newEnergy) {
        energy = newEnergy;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int newHunger) {
        hunger = newHunger;
    }
}
