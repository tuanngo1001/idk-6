package idk6.csexperience.business;

import org.junit.Test;
import static org.junit.Assert.*;
import idk6.csexperience.objects.Game;
import idk6.csexperience.business.AdjustGame;


public class AdjustGameTest {

    @Test
    public void testAdjustGame() {

        //TESTING FOR CREATION OF AdjustGame
        Game testGame;
        AdjustGame adjustGame;
        System.out.println("\nStarting test AdjustGame");
        //IMPLEMENTING the testGame with:
        //Name of the game
        String gameName = "gameName";
        testGame = new Game(gameName);
        adjustGame = new AdjustGame(testGame);

        assertNotNull("Game should not be Null", testGame);
        assertNotNull("AdjustGame should not be Null", adjustGame);

        System.out.println("\nEnding test AdjustGame");

    }
}
