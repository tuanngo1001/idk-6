package idk6.csexperience.objects;

import org.junit.Test;

import idk6.csexperience.objects.Game;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void testGamePlayer1(){
        Game gamePlayer;
        System.out.println("Starting testGame");
        Game.destoryGame();
        gamePlayer = Game.getCoreGame();
        gamePlayer.setPlayerName("playerName");
        assertNotNull(gamePlayer);
        assertTrue("playerName".equals(gamePlayer.getPlayer().getName()));

        System.out.println("Finished testGame\n");
    }
}
