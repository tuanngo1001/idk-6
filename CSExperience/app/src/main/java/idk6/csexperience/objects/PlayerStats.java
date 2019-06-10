package idk6.csexperience.objects;

public class PlayerStats {
    private int energy;
    private int hunger;
    private int happiness;

    private int[] classKnowledge = new int[5];


    public PlayerStats(int num_classes) {
        energy = 10;
        hunger = 10;
        happiness = 10;

        classKnowledge[0] = 1;
        classKnowledge[1] = 1;
        classKnowledge[2] = 1;
        classKnowledge[3] = 1;
        classKnowledge[4] = 1;
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

    public int getCourseKnowledge(int courseId){
        assert(courseId >= 0 && courseId <= 4);
        return classKnowledge[courseId];
    }

    public void setCourseKnowledge(int courseId, int value){
        assert(courseId >= 0 && courseId <= 4);
        classKnowledge[courseId] = value;
    }
}
