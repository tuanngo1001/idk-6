package idk6.csexperience.objects;

import android.os.Parcel;
import android.os.Parcelable;

public class Time implements Parcelable {
    private int day;
    private int period;

    // Time includes the day and the period within the day. There are two free periods per day,
    // and a sleep period
    public Time() {
        day = 1;
        period = 1;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int newDay) {
        day = newDay;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int newPeriod) {
        period = newPeriod;
    }

    protected Time(Parcel in) {
        day = in.readInt();
        period = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(day);
        dest.writeInt(period);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Time> CREATOR = new Parcelable.Creator<Time>() {
        @Override
        public Time createFromParcel(Parcel in) {
            return new Time(in);
        }

        @Override
        public Time[] newArray(int size) {
            return new Time[size];
        }
    };
}