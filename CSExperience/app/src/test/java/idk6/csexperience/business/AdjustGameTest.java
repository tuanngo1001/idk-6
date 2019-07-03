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
        System.out.println("Starting testAdjustGame Creating");
        //IMPLEMENTING the testGame with:
        //Name of the game
        String gameName = "gameName";
        testGame = Game.getCoreGame();
        testGame.setName(gameName);
        adjustGame = new AdjustGame(testGame);

        assertNotNull("Game should not be Null", testGame);
        assertNotNull("AdjustGame should not be Null", adjustGame);

        System.out.println("Finishing testAdjustGame Creating\n");

    }
    //ADDING TEST FOR JOB==============================================================
    @Test
    public void testWaiterWaitress(){
        System.out.println("Starting testWaiterWaitress");
        Game testGame1 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame1);
        testGame1.getPlayer().getStats().setEnergy(0);
        testGame1.getPlayer().getStats().setHappiness(0);
        testGame1.getPlayer().getStats().setFood(0);
        AdjustGame adjustGame1 = new AdjustGame(testGame1);
        assertNotNull("AdjustGame should not be Null", adjustGame1);
        assertFalse("Cannot do Waitress with low level status",
                    adjustGame1.waiterWaitress());

        Game testGame2 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame2);
        testGame2.getPlayer().getStats().setEnergy(100);
        testGame2.getPlayer().getStats().setHappiness(100);
        testGame2.getPlayer().getStats().setFood(100);
        AdjustGame adjustGame2= new AdjustGame(testGame2);
        assertNotNull("AdjustGame should not be Null", adjustGame2);
        assertTrue("Should be able to do Waitress with full level status",
                    adjustGame2.waiterWaitress());
        System.out.println("Finishing testWaiterWaitress");
    }
    @Test
    public void testCashier(){
        System.out.println("Starting testCahsier");
        Game testGame1 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame1);
        testGame1.getPlayer().getStats().setEnergy(0);
        testGame1.getPlayer().getStats().setHappiness(0);
        testGame1.getPlayer().getStats().setFood(0);
        AdjustGame adjustGame1 = new AdjustGame(testGame1);
        assertNotNull("AdjustGame should not be Null", adjustGame1);
        assertFalse("Cannot do Cashier with low level status",
                adjustGame1.cashier());

        Game testGame2 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame2);
        testGame2.getPlayer().getStats().setEnergy(100);
        testGame2.getPlayer().getStats().setHappiness(100);
        testGame2.getPlayer().getStats().setFood(100);
        AdjustGame adjustGame2= new AdjustGame(testGame2);
        assertNotNull("AdjustGame should not be Null", adjustGame2);
        assertTrue("Should be able to do Cashier with full level status",
                adjustGame2.cashier());
        System.out.println("Finishing testCahsier");
    }
    @Test
    public void testDelivery(){
        System.out.println("Starting testDelivery");
        Game testGame1 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame1);
        testGame1.getPlayer().getStats().setEnergy(0);
        testGame1.getPlayer().getStats().setHappiness(0);
        testGame1.getPlayer().getStats().setFood(0);
        AdjustGame adjustGame1 = new AdjustGame(testGame1);
        assertNotNull("AdjustGame should not be Null", adjustGame1);
        assertFalse("Cannot do Waitress with low level status",
                adjustGame1.delivery());

        Game testGame2 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame2);
        testGame2.getPlayer().getStats().setEnergy(100);
        testGame2.getPlayer().getStats().setHappiness(100);
        testGame2.getPlayer().getStats().setFood(100);
        AdjustGame adjustGame2= new AdjustGame(testGame2);
        assertNotNull("AdjustGame should not be Null", adjustGame2);
        assertTrue("Should be able to do Waitress with full level status",
                adjustGame2.delivery());
        System.out.println("Finishing testDelivery");
    }
    //=================================================================================
}
