package idk6.csexperience.objects;

import java.util.HashMap;

public class Calendar {
    public static final int AFTERNOON = 1;
    public static final int EVENING = 2;

    private int day;
    private int period;
    private String event;
    private HashMap<Integer,String> importantDates;


    public Calendar(){
        this.day = 1;
        this.period = 1;
        this.event = "";
        this.importantDates = new HashMap<Integer,String>();
    }

    public int getDay(){
        return day;
    }

    public void setDay(int newDay){
        this.day = newDay;
    }

    public int getPeriod() {
        return period;
    }

    public String getPeriodString() {
        if (period == 1) {
            return "Afternoon";
        }
        else {
            return "Evening";
        }
    }



    public void setPeriod(int period) {
        this.period = period;
    }

    public String getEvent(){
        return event;
    }

    public void setEvent(String newEvent){
        this.event = newEvent;
    }

    public HashMap<Integer,String> getImportantDates(){
        return importantDates;
    }


}
