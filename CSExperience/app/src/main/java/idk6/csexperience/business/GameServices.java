package idk6.csexperience.business;

import java.util.List;

import idk6.csexperience.application.Services;
import idk6.csexperience.objects.Calendar;
import idk6.csexperience.objects.Game;
import idk6.csexperience.objects.Player;
import idk6.csexperience.objects.PlayerStats;
import idk6.csexperience.persistence.PlayerStatsPersistence;
import idk6.csexperience.persistence.PlayerTimePersistence;
import idk6.csexperience.persistence.hsqldb.PlayerStatsPersistenceHSQLDB;

public class GameServices {
    private PlayerStatsPersistence playerPersistence;
    private PlayerTimePersistence timePersistence;

    public GameServices() {
        playerPersistence = Services.getPlayerStatsPersistence();
        timePersistence = Services.getPlayerTimePersistence();
    }
    public boolean load(String PLAYER_ID) {
        try {
            Game.destoryGame();
            Game game = Game.getCoreGame();
            PlayerStats ps = playerPersistence.getPlayerStats(PLAYER_ID);
            List<Integer> cd = timePersistence.getDateTime(PLAYER_ID);
            game.setPlayer(ps);
            game.setCalendar(cd);
            game.getPlayer().setName(PLAYER_ID);

        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean save() {
        Game game = Game.getCoreGame();

        int day = game.getCalendar().getDay();
        int period = game.getCalendar().getPeriod();
        String PLAYER_ID = game.getPlayer().getName();

        if(playerPersistence.doesExist(PLAYER_ID)){
            playerPersistence.updatePlayerStats(PLAYER_ID, game.getPlayer().getStats());
            timePersistence.updateDateTime(PLAYER_ID, day, period);
            //UPDATE
        }
        else {
            playerPersistence.insertPlayer(PLAYER_ID, game.getPlayer().getStats());
            timePersistence.insertDateTime(PLAYER_ID, day, period);
            //insert
        }

        return true;

    }
}
