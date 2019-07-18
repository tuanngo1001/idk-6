package idk6.csexperience.business;

import idk6.csexperience.objects.Calendar;
import idk6.csexperience.objects.Game;

public class AdjustCalendar {
    private int AFTERNOON = 1;
    private int EVENING = 2;

    private int day;
    private int period;
    private String event;
    private Calendar calendar;

    public AdjustCalendar(Game ourGame){
        this.calendar = ourGame.getCalendar();
        this.day = calendar.getDay();
        this.period = calendar.getPeriod();
        this.event = calendar.getEvent();
    }

    public void nextDay(){
        day++;
        calendar.setDay(day);
    }

    public void nextPeriod() {
        if(period == 2)
            nextDay();
        period = (period % 2) + 1;
        calendar.setPeriod(period);
    }

    /*
    public void nextPeriod(){
        if(period == EVENING){
            nextDay();
            period = AFTERNOON;
            //transition to next day
        }else if(period == AFTERNOON){
            period = EVENING;
        }else{
            period = AFTERNOON;
        }
        calendar.setPeriod(period);
    }
    */
    public void addImportantEvent(int date, String event){
        calendar.getImportantDates().put(date,event);
    }


    public void deleteImportantEvent(int date){
        calendar.getImportantDates().remove(date);
    }

    public String getEvent(int date){
        return calendar.getImportantDates().get(date);
    }

    //ADDINNG FOR TESTING AdjustCalendar

    public Calendar getCalendar(){
        return this.calendar;
    }
}
