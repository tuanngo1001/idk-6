package idk6.csexperience.objects;

import android.os.Parcel;
import android.os.Parcelable;

/*
 Game Class

 Acts as a singleton class, meaning that our app will have only one game object at a time.

 Benefit: the core game object is now in one place and doesn't need to based around
          via "parcelable".
 */

public class Game{
    private static Game coreGame;
    private Calendar calendar;
    private Player player;

    // Constructor is private
    private Game() {
        calendar = new Calendar();
        player = new Player();
    }

    /*  getCoreGame()
        This is our getter for the coreGame object. Use this whenever you want the coreGame.

        For more info see: https://refactoring.guru/design-patterns/singleton
     */
    public static Game getCoreGame(){
       if(coreGame == null){
           coreGame = new Game();
       }

       return coreGame;
    }

    /* destroyGame()
       Use this to clear the current "running" game instance.
       Useful during testing
     */
    public static void destoryGame(){
        coreGame = null;
    }

    public void setName(String name){
        player.setName(name);
    }

    public Player getPlayer() {
        return player;
    }

    public Calendar getCalendar() { return calendar; }

}