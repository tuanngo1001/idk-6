package idk6.csexperience.objects;

public class PlayerStats {
    private int energy;
    private int hunger;
    private int happiness;


    public PlayerStats(int num_classes) {
        energy = 10;
        hunger = 10;
        happiness = 10;

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
