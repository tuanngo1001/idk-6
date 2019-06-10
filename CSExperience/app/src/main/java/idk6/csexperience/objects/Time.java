package idk6.csexperience.objects;

public class Time {
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
}
