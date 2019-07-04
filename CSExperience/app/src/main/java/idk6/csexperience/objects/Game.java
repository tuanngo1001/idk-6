package idk6.csexperience.objects;

/*
 Game Class

 Acts as a singleton class, meaning that our app will have only one game object at a time.

 Benefit: the core game object is now in one place and doesn't need to based around
          via "parcelable".
 */

import java.util.List;

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

    public void setPlayerName(String name){
        player.setName(name);
    }

    public void setPlayer(PlayerStats newPlayer) {
        Player p = new Player();
        p.setPlayerStats(newPlayer);
        player = p;
    }

    public void setCalendar(List<Integer> list) {
        Calendar c = new Calendar();
        c.setDay(list.get(0));
        c.setPeriod(list.get(1));
        calendar = c;
    }

    public Player getPlayer() {
        return player;
    }

    public Calendar getCalendar() { return this.calendar; }

}
