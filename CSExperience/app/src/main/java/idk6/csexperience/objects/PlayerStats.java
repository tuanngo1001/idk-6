package idk6.csexperience.objects;

import android.os.Parcel;
import android.os.Parcelable;

public class PlayerStats implements Parcelable {
    private int energy;
    private int hunger;
    private int happiness;


    public PlayerStats(int num_classes) {
        energy = 100;
        hunger = 100;
        happiness = 100;

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
        return 0;// classKnowledge[courseId];
    }

    public void setCourseKnowledge(int courseId, int value){
        assert(courseId >= 0 && courseId <= 4);
        //classKnowledge[courseId] = value;
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