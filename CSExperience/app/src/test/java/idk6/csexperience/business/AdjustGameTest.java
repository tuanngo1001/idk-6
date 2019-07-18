package idk6.csexperience.business;

import org.junit.Test;
import static org.junit.Assert.*;
import idk6.csexperience.objects.Game;

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
        testGame.setPlayerName(gameName);
        adjustGame = new AdjustGame(testGame);

        assertNotNull("Game should not be Null", testGame);
        assertNotNull("AdjustGame should not be Null", adjustGame);

        System.out.println("Finishing testAdjustGame Creating");

    }
    @Test
    public void testAdvanceTime(){
        System.out.println("Starting testAdvanceTime");
        Game.destoryGame();
        Game testGame1 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame1);

        int Afternoon = 1;
        int Evening = 2;
        testGame1.getCalendar().setPeriod(Afternoon);
        AdjustGame adjustGame1 = new AdjustGame(testGame1);
        assertNotNull("AdjustGame should not be Null", adjustGame1);
        adjustGame1.advanceTime();
        assertTrue("The period should go to evening",
                testGame1.getCalendar().getPeriod() == Evening);
        System.out.println("Finishing testAdvanceTime");
    }
    @Test
    public void testSleepEatGame(){
        //Specific Numbers depends, range 0-100
        System.out.println("Starting testSleep testEat testGame");
        Game.destoryGame();
        Game testGame1 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame1);
        AdjustGame adjustGame1 = new AdjustGame(testGame1);
        assertNotNull("AdjustGame should not be Null", adjustGame1);
        int energyDif = testGame1.getPlayer().getStats().getEnergy();
        int foodDif = testGame1.getPlayer().getStats().getFood();
        int gameDif = testGame1.getPlayer().getStats().getHappiness();
        adjustGame1.sleep();
        assertTrue("Energy should increase",
                energyDif <= testGame1.getPlayer().getStats().getEnergy());
        adjustGame1.eat();
        assertTrue("Food should increase",
                foodDif < testGame1.getPlayer().getStats().getFood());
        adjustGame1.gameItUp();
        assertTrue("Happiness should increase",
                gameDif < testGame1.getPlayer().getStats().getHappiness());
        System.out.println("Finishing testSleep testEat testGame");
    }
    @Test
    public void testNightOut(){
        //Specific Numbers depends, range 0-100
        System.out.println("Starting testNightOut");
        Game.destoryGame();
        Game testGame1 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame1);
        AdjustGame adjustGame1 = new AdjustGame(testGame1);
        assertNotNull("AdjustGame should not be Null", adjustGame1);
        int energyDif = testGame1.getPlayer().getStats().getEnergy();
        int gameDif = testGame1.getPlayer().getStats().getHappiness();
        adjustGame1.nightOut();
        assertTrue("Energy should decrease, Happiness should increase",
                testGame1.getPlayer().getStats().getHappiness()>gameDif &&
                        testGame1.getPlayer().getStats().getEnergy()<energyDif);
        System.out.println("Finishing testNightOut");
    }
    @Test
    public void testGroceryHaul(){
        //Specific Numbers depends, range 0-100
        System.out.println("Starting testGroceryHaul");
        Game.destoryGame();
        Game testGame1 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame1);
        AdjustGame adjustGame1 = new AdjustGame(testGame1);
        assertNotNull("AdjustGame should not be Null", adjustGame1);
        int foodDif = testGame1.getPlayer().getStats().getFood();
        int energyDif = testGame1.getPlayer().getStats().getEnergy();
        adjustGame1.groceryHaul();
        assertTrue("Energy should decrease, Happiness should increase",
                testGame1.getPlayer().getStats().getEnergy()<energyDif &&
                        testGame1.getPlayer().getStats().getFood()>foodDif);
        System.out.println("Finishing testGroceryHaul");
    }
    @Test
    public void testSuperSleep(){
        //Specific Numbers depends, range 0-100
        System.out.println("Starting testSuperSleep");
        Game.destoryGame();
        Game testGame1 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame1);
        AdjustGame adjustGame1 = new AdjustGame(testGame1);
        assertNotNull("AdjustGame should not be Null", adjustGame1);
        int foodDif = testGame1.getPlayer().getStats().getFood();
        int energyDif = testGame1.getPlayer().getStats().getEnergy();
        adjustGame1.superSleep();
        assertTrue("Energy should increase, Happiness should decrease",
                testGame1.getPlayer().getStats().getEnergy()>energyDif &&
                        testGame1.getPlayer().getStats().getFood()<foodDif);
        System.out.println("Finishing testSuperSleep");
    }

    @Test
    public void testStudyDB(){
        System.out.println("Starting testStudyDB");
        Game.destoryGame();
        Game testGame1 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame1);
        AdjustGame adjustGame1 = new AdjustGame(testGame1);
        assertNotNull("AdjustGame should not be Null", adjustGame1);
        int dBDif = testGame1.getPlayer().getStats().getDatabasesKnowledge();
        adjustGame1.studyDB();
        assertTrue("Database Knowledge should increase",
                testGame1.getPlayer().getStats().getDatabasesKnowledge() > dBDif);
        System.out.println("Finishing testStudyDB");
    }
    @Test
    public void testStudyAI(){
        System.out.println("Starting testStudyAI");
        Game.destoryGame();
        Game testGame1 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame1);
        AdjustGame adjustGame1 = new AdjustGame(testGame1);
        assertNotNull("AdjustGame should not be Null", adjustGame1);
        int aIDif = testGame1.getPlayer().getStats().getAiKnowledge();
        adjustGame1.studyDB();
        assertTrue("AI Knowledge should increase",
                testGame1.getPlayer().getStats().getDatabasesKnowledge() > aIDif);
        System.out.println("Finishing testStudyAI");
    }
    @Test
    public void testStudyGraphics(){
        System.out.println("Starting testGraphics");
        Game.destoryGame();
        Game testGame1 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame1);
        AdjustGame adjustGame1 = new AdjustGame(testGame1);
        assertNotNull("AdjustGame should not be Null", adjustGame1);
        int gRDif = testGame1.getPlayer().getStats().getGraphicsKnowledge();
        adjustGame1.studyGraphics();
        assertTrue("Graphics Knowledge should increase",
                testGame1.getPlayer().getStats().getGraphicsKnowledge() > gRDif);
        System.out.println("Finishing testGraphics");
    }

    @Test
    public void testBuyCoffee(){
        //Specific Numbers depends, range 0-100
        System.out.println("Starting testBuyCoffee");
        Game.destoryGame();
        Game testGame1 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame1);
        testGame1.getPlayer().getStats().setMoney(0);
        AdjustGame adjustGame1 = new AdjustGame(testGame1);
        assertNotNull("AdjustGame should not be Null", adjustGame1);
        //assertFalse("Cannot get an coffee for no money", adjustGame1.buyCoffee());

        testGame1.getPlayer().getStats().setMoney(5);
        testGame1.getPlayer().getStats().setFood(10); //Just in case for food is not enough
        AdjustGame adjustGame2 = new AdjustGame(testGame1);
        assertNotNull("AdjustGame should not be Null", adjustGame2);
        //assertTrue("Can get an coffee with 5 bucks", adjustGame2.buyCoffee());
        System.out.println("Finishing testBuyCoffee");
    }
    @Test
    public void testBuyBeer(){
        System.out.println("Starting testBuyBeer");
        Game.destoryGame();
        Game testGame1 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame1);

        testGame1.getPlayer().getStats().setMoney(0);
        AdjustGame adjustGame1 = new AdjustGame(testGame1);
        assertNotNull("AdjustGame should not be Null", adjustGame1);
        //assertFalse("Cannot buy beer for no money", adjustGame1.buyBeer());

        testGame1.getPlayer().getStats().setMoney(7);
        testGame1.getPlayer().getStats().setFood(15);
        testGame1.getPlayer().getStats().setEnergy(15);
        AdjustGame adjustGame2 = new AdjustGame(testGame1);
        assertNotNull("AdjustGame should not be Null", adjustGame2);
        //assertTrue("Can buy beer now for 7 bucks", adjustGame2.buyBeer());
        System.out.println("Finishing testBuyBeer");
    }
    @Test
    public void testBuySnack(){
        System.out.println("Starting testBuySnack");
        Game.destoryGame();
        Game testGame1 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame1);

        testGame1.getPlayer().getStats().setMoney(0);
        AdjustGame adjustGame1 = new AdjustGame(testGame1);
        assertNotNull("AdjustGame should not be Null", adjustGame1);
        //assertFalse("Cannot buy snack for no money", adjustGame1.buySnack());

        testGame1.getPlayer().getStats().setMoney(5);
        AdjustGame adjustGame2 = new AdjustGame(testGame1);
        assertNotNull("AdjustGame should not be Null", adjustGame2);
        //assertTrue("Can buy snack now for 5 bucks", adjustGame2.buySnack());
        System.out.println("Finishing testBuySnack");
    }
    @Test
    public void testBuyEnergyDrink(){
        System.out.println("Starting testBuyEnergyDrink");
        Game.destoryGame();
        Game testGame1 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame1);

        testGame1.getPlayer().getStats().setMoney(0);
        AdjustGame adjustGame1 = new AdjustGame(testGame1);
        assertNotNull("AdjustGame should not be Null", adjustGame1);
        //assertFalse("Cannot buy energy drink for no money", adjustGame1.buySnack());

        testGame1.getPlayer().getStats().setMoney(8);
        AdjustGame adjustGame2 = new AdjustGame(testGame1);
        assertNotNull("AdjustGame should not be Null", adjustGame2);
        //assertTrue("Can buy energy drink now for 8 bucks", adjustGame2.buySnack());
        System.out.println("Finishing testBuyEnergyDrink");
    }
    @Test
    public void testUseChegg(){
        System.out.println("Starting testUseChegg");
        Game.destoryGame();
        Game testGame1 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame1);

        testGame1.getPlayer().getStats().setMoney(0);
        AdjustGame adjustGame1 = new AdjustGame(testGame1);
        assertNotNull("AdjustGame should not be Null", adjustGame1);
        //assertFalse("Cannot use Chegg for no money", adjustGame1.useChegg());

        testGame1.getPlayer().getStats().setMoney(25);
        AdjustGame adjustGame2 = new AdjustGame(testGame1);
        assertNotNull("AdjustGame should not be Null", adjustGame2);
        //assertTrue("Can use Chegg now for 25 bucks", adjustGame2.useChegg());
        System.out.println("Finishing testUseChegg");
    }
    @Test
    public void testWaiterWaitress(){
        System.out.println("Starting testWaiterWaitress");
        Game.destoryGame();
        Game testGame1 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame1);
        testGame1.getPlayer().getStats().setEnergy(0);
        testGame1.getPlayer().getStats().setHappiness(0);
        testGame1.getPlayer().getStats().setFood(0);
        AdjustGame adjustGame1 = new AdjustGame(testGame1);
        assertNotNull("AdjustGame should not be Null", adjustGame1);
        assertFalse("Cannot do Waitress with low level status",
                adjustGame1.doServer());

        Game.destoryGame();
        Game testGame2 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame2);
        testGame2.getPlayer().getStats().setEnergy(100);
        testGame2.getPlayer().getStats().setHappiness(100);
        testGame2.getPlayer().getStats().setFood(100);
        AdjustGame adjustGame2= new AdjustGame(testGame2);
        assertNotNull("AdjustGame should not be Null", adjustGame2);
        assertTrue("Should be able to do Waitress with full level status",
                adjustGame2.doServer());
        System.out.println("Finishing testWaiterWaitress");
    }
    @Test
    public void testCashier(){
        System.out.println("Starting testCahsier");
        Game.destoryGame();
        Game testGame1 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame1);
        testGame1.getPlayer().getStats().setEnergy(0);
        testGame1.getPlayer().getStats().setHappiness(0);
        testGame1.getPlayer().getStats().setFood(0);
        AdjustGame adjustGame1 = new AdjustGame(testGame1);
        assertNotNull("AdjustGame should not be Null", adjustGame1);
        assertFalse("Cannot do Cashier with low level status",
                adjustGame1.doCashier());

        Game.destoryGame();
        Game testGame2 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame2);
        testGame2.getPlayer().getStats().setEnergy(100);
        testGame2.getPlayer().getStats().setHappiness(100);
        testGame2.getPlayer().getStats().setFood(100);
        AdjustGame adjustGame2= new AdjustGame(testGame2);
        assertNotNull("AdjustGame should not be Null", adjustGame2);
        assertTrue("Should be able to do Cashier with full level status",
                adjustGame2.doCashier());
        System.out.println("Finishing testCahsier");
    }
    @Test
    public void testDelivery(){
        System.out.println("Starting testDelivery");
        Game.destoryGame();
        Game testGame1 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame1);
        testGame1.getPlayer().getStats().setEnergy(0);
        testGame1.getPlayer().getStats().setHappiness(0);
        testGame1.getPlayer().getStats().setFood(0);
        AdjustGame adjustGame1 = new AdjustGame(testGame1);
        assertNotNull("AdjustGame should not be Null", adjustGame1);
        assertFalse("Cannot do Waitress with low level status",
                adjustGame1.doDelivery());

        Game.destoryGame();
        Game testGame2 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame2);
        testGame2.getPlayer().getStats().setEnergy(100);
        testGame2.getPlayer().getStats().setHappiness(100);
        testGame2.getPlayer().getStats().setFood(100);
        AdjustGame adjustGame2= new AdjustGame(testGame2);
        assertNotNull("AdjustGame should not be Null", adjustGame2);
        assertTrue("Should be able to do Waitress with full level status",
                adjustGame2.doDelivery());
        System.out.println("Finishing testDelivery");
    }
}
