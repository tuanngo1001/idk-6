package idk6.csexperience.objects;

public class CalendarEvent
{
    private String examName;
    private int examDate;
    private int examSlot;
    private boolean examIsMid;

    public CalendarEvent(final String name, final int date, final int slot, final boolean midOrFinal)
    {
        this.examName = name;
        this.examDate = date;
        this.examSlot = slot;
        this.examIsMid = midOrFinal;
    }

    public String getExamName()
    {
        return this.examName;
    }

    public int getExamDate()
    {
        return this.examDate;
    }

    public int getExamSlot()
    {
        return this.examSlot;
    }

    public boolean checkMid(){
        return examIsMid;
    }
}
