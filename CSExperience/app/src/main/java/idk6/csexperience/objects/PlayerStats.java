package idk6.csexperience.objects;

import android.os.Parcel;
import android.os.Parcelable;

public class PlayerStats implements Parcelable {
    private int energy;
    private int hunger;
    private int happiness;

    private SkillLevel[] levels;
    private CombatSkills skills;

    //all of the skills that a player can acquire
    private Skill[][] allSkill;

    private int[] classKnowledge = new int[5];


    public PlayerStats(int num_classes) {
        energy = 10;
        hunger = 10;
        happiness = 10;

        skills = new CombatSkills();

        levels = new SkillLevel[num_classes];
        for (int i = 0;i < num_classes; i++)
            levels[i] = new SkillLevel();

        allSkill = new Skill[5][2];

        allSkill[0][0] = (new Skill(1,11,"course 1 skill no 1", 100));
        allSkill[0][1] = (new Skill(1,12,"course 1 skill no 2", 200));
        allSkill[1][0] = (new Skill(2,21,"course 2 skill no 1", 100));
        allSkill[1][1] = (new Skill(2,22,"course 2 skill no 2", 200));
        allSkill[2][0] = (new Skill(3,31,"course 3 skill no 1", 100));
        allSkill[2][1] = (new Skill(3,32,"course 3 skill no 2", 200));
        allSkill[3][0] = (new Skill(4,41,"course 4 skill no 1", 100));
        allSkill[3][1] = (new Skill(4,42,"course 4 skill no 2", 200));
        allSkill[4][0] = (new Skill(5,51,"course 5 skill no 1", 100));
        allSkill[4][1] = (new Skill(5,52,"course 5 skill no 2", 200));

    }

    public SkillLevel getSkillLevel(int courseID){ return levels[courseID]; }

    public CombatSkills getSkillsList(){ return skills; }

    public void addSkill(Skill newSkill){
        skills.addSkill(newSkill);
    }

    public Skill getSkill(int id){ return skills.getSkill(id); }

    public Skill getNewSkill(int cID, int skillNo){ return allSkill[cID][skillNo]; }

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

    protected PlayerStats(Parcel in) {
        energy = in.readInt();
        hunger = in.readInt();
        happiness = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(energy);
        dest.writeInt(hunger);
        dest.writeInt(happiness);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<PlayerStats> CREATOR = new Parcelable.Creator<PlayerStats>() {
        @Override
        public PlayerStats createFromParcel(Parcel in) {
            return new PlayerStats(in);
        }

        @Override
        public PlayerStats[] newArray(int size) {
            return new PlayerStats[size];
        }
    };
}
