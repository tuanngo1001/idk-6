package idk6.csexperience.business;

import org.junit.Test;
import static org.junit.Assert.*;
import idk6.csexperience.objects.Game;

public class AdjustPlayerStatsTest {
    @Test
    public void testEatSleepPlay0(){
        System.out.println("Starting testAdjustPlayerStat: eat, sleep, play function when all the" +
                " stat is set to 0");

        Game.destoryGame();
        AdjustPlayerStats adjuster = new AdjustPlayerStats(Game.getCoreGame());
        adjuster.setAllToZero();
        adjuster.eat();
        assertEquals("Food should be 50 after eat",50,adjuster.getFood());

        adjuster.sleep();
        assertEquals("Energy should be 50 after sleep",50,adjuster.getEnergy());
        assertEquals("Food should be 30 after sleep",30,adjuster.getFood());

        adjuster.play();
        assertEquals("Happiness should be 50 after play",50,adjuster.getHappiness());

        System.out.println("Finished testAdjustPlayerStat: eat, sleep, play function when all the" +
                " stat is set to 0\n");
    }
    @Test
    public void testEatSleepPlayDefault(){
        System.out.println("Starting testAdjustPlayerStat: eat, sleep, play function when all the" +
                " stat is set to default");

        Game.destoryGame();
        AdjustPlayerStats adjuster = new AdjustPlayerStats(Game.getCoreGame());
        adjuster.eat();
        assertEquals("Food should be 100 after eat",100,adjuster.getFood());

        adjuster.sleep();
        assertEquals("Energy should be 100 after sleep",100,adjuster.getEnergy());
        assertEquals("Food should be 80 after sleep",80,adjuster.getFood());

        adjuster.play();
        assertEquals("Happiness should be 100 after play",100,adjuster.getHappiness());

        System.out.println("Finished testAdjustPlayerStat: eat, sleep, play function when all the" +
                " stat is set to default\n");
    }
    @Test
    public void testNightOut(){
        System.out.println("Starting testAdjustPlayerStat: nightOut, superSleep, groceryHaul " +
                "function when all the stat is set to 0");

        Game.destoryGame();
        AdjustPlayerStats adjuster = new AdjustPlayerStats(Game.getCoreGame());
        adjuster.setAllToZero();

        adjuster.nightOut();
        assertEquals("Happiness Should be 80 after nightOut",80,adjuster.getHappiness());
        assertEquals("Energy should be 0",0,adjuster.getEnergy());

        adjuster.superSleep();
        assertEquals("Energy should be 100",100,adjuster.getEnergy());
        assertEquals("Food should be 0",0,adjuster.getFood());

        System.out.println("Finished testAdjustPlayerStat: nightOut, superSleep, groceryHaul " +
                "function when all the stat is set to 0\n");
    }

    @Test
    public void testOutSleepHaul(){
        System.out.println("Starting testAdjustPlayerStat: nightOut, superSleep, groceryHaul " +
                "function when all the stat is set to default");

        Game.destoryGame();
        AdjustPlayerStats adjuster = new AdjustPlayerStats(Game.getCoreGame());

        adjuster.nightOut();
        assertEquals("Happiness Should be 100 after nightOut",100,adjuster.getHappiness());
        assertEquals("Energy should be 20",20,adjuster.getEnergy());

        adjuster.superSleep();
        assertEquals("Energy should be 100",100,adjuster.getEnergy());
        assertEquals("Food should be 20",20,adjuster.getFood());

        System.out.println("Finished testAdjustPlayerStat: nightOut, superSleep, groceryHaul " +
                "function when all the stat is set to default\n");
    }
    @Test
    public void testStudyAI(){
        System.out.println("Starting testAdjustPlayerStat: studyAI functions with the default stat");

        Game.destoryGame();
        AdjustPlayerStats adjuster = new AdjustPlayerStats(Game.getCoreGame());

        adjuster.studyAi();
        assertEquals("Happiness Should be 30",30,adjuster.getHappiness());
        assertEquals("Energy should be 35",35,adjuster.getEnergy());
        assertEquals("Food should be 42",42,adjuster.getFood());
        assertEquals("AI knowledge should 2",2,adjuster.getAiKnowledge());

        System.out.println("Finished testAdjustPlayerStat: studyAI functions with default stat\n");
    }
    @Test
    public void testStudyDatabases(){
        System.out.println("Starting testAdjustPlayerStat: studyDatabases functions with the default stat");

        Game.destoryGame();
        AdjustPlayerStats adjuster = new AdjustPlayerStats(Game.getCoreGame());

        adjuster.studyDatabases();
        assertEquals("Happiness Should be 30 after nightOut",30,adjuster.getHappiness());
        assertEquals("Energy should be 35",35,adjuster.getEnergy());
        assertEquals("Food should be 42",42,adjuster.getFood());
        assertEquals("Databases knowledge should 2",2,adjuster.getDatabasesKnowledge());

        System.out.println("Finished testAdjustPlayerStat: studyDatabases functions with default stat\n");
    }
    @Test
    public void testStudyGraphics(){
        System.out.println("Starting testAdjustPlayerStat: studyGraphics functions with the default stat");

        Game.destoryGame();
        AdjustPlayerStats adjuster = new AdjustPlayerStats(Game.getCoreGame());

        adjuster.studyGraphics();
        assertEquals("Happiness Should be 30 after nightOut",30,adjuster.getHappiness());
        assertEquals("Energy should be 35",35,adjuster.getEnergy());
        assertEquals("Food should be 42",42,adjuster.getFood());
        assertEquals("Graphics knowledge should 2",2,adjuster.getGraphicsKnowledge());

        System.out.println("Finished testAdjustPlayerStat: studyGraphics functions with default stat\n");
    }
    //ADDING TEST METHOD FOR JOBS===================================================================
    @Test
    public void testDoServer(){
        System.out.println("Starting testDoServer");
        Game.destoryGame();
        Game testGame1 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame1);
        testGame1.getPlayer().getStats().setEnergy(15);
        testGame1.getPlayer().getStats().setHappiness(20);
        testGame1.getPlayer().getStats().setFood(8);
        AdjustPlayerStats playerStats1 = new AdjustPlayerStats(testGame1);
        assertNotNull("AdjustGame should not be Null", playerStats1);
        assertTrue("Energy should be 15",playerStats1.getEnergy() == 15);
        assertTrue("Happiness should be 20", playerStats1.getHappiness() == 20);
        assertTrue("Food should be 8", playerStats1.getFood() == 8);
        assertTrue("Should be able to do Waitress",
                playerStats1.adjustServer());
        assertTrue("Energy should be 0",playerStats1.getEnergy() == 0);
        assertTrue("Happiness should be 0", playerStats1.getHappiness() == 0);
        assertTrue("Food should be 0", playerStats1.getFood() == 0);
        System.out.println("Finished testDoServer\n");
    }
    @Test
    public void testDoCashier(){
        System.out.println("Starting testDoCashier");
        Game.destoryGame();
        Game testGame1 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame1);
        testGame1.getPlayer().getStats().setEnergy(20);
        testGame1.getPlayer().getStats().setHappiness(15);
        testGame1.getPlayer().getStats().setFood(8);
        AdjustPlayerStats playerStats1 = new AdjustPlayerStats(testGame1);
        assertNotNull("AdjustGame should not be Null", playerStats1);
        assertTrue("Energy should be 20",playerStats1.getEnergy() == 20);
        assertTrue("Happiness should be 15", playerStats1.getHappiness() == 15);
        assertTrue("Food should be 8", playerStats1.getFood() == 8);
        assertTrue("Should be able to do Cashier",
                playerStats1.adjustServer());
        assertTrue("Energy should be 0",playerStats1.getEnergy() == 0);
        assertTrue("Happiness should be 0", playerStats1.getHappiness() == 0);
        assertTrue("Food should be 0", playerStats1.getFood() == 0);
        System.out.println("Finished testDoCashier\n");
    }
    @Test
    public void testDoDelivering(){
        System.out.println("Starting testDoDelivering");
        Game.destoryGame();
        Game testGame1 = Game.getCoreGame();
        assertNotNull("Game should not be Null", testGame1);
        testGame1.getPlayer().getStats().setEnergy(20);
        testGame1.getPlayer().getStats().setHappiness(8);
        testGame1.getPlayer().getStats().setFood(15);
        AdjustPlayerStats playerStats1 = new AdjustPlayerStats(testGame1);
        assertNotNull("AdjustGame should not be Null", playerStats1);
        assertTrue("Energy should be 20",playerStats1.getEnergy() == 20);
        assertTrue("Happiness should be 8", playerStats1.getHappiness() == 8);
        assertTrue("Food should be 15", playerStats1.getFood() == 15);
        assertTrue("Should be able to do Deliver",
                playerStats1.adjustDelivering());
        assertTrue("Energy should be 0",playerStats1.getEnergy() == 0);
        assertTrue("Happiness should be 0", playerStats1.getHappiness() == 0);
        assertTrue("Food should be 0", playerStats1.getFood() == 0);
        System.out.println("Finished testDoServer\n");
    }
}
