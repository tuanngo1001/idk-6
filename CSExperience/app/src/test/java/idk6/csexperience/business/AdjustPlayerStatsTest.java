package idk6.csexperience.business;

import org.junit.Test;

import static org.junit.Assert.*;

import idk6.csexperience.business.AdjustPlayerStats;

import idk6.csexperience.objects.Game;

public class AdjustPlayerStatsTest {

    @Test
    public void testAPS1(){
        System.out.println("Starting testAdjustPlayerStat: eat, sleep, play function when all the" +
                " stat is set to 0");

        AdjustPlayerStats adjuster = new AdjustPlayerStats(new Game("user"));
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
    public void testAPS2(){
        System.out.println("Starting testAdjustPlayerStat: eat, sleep, play function when all the" +
                " stat is set to default");

        AdjustPlayerStats adjuster = new AdjustPlayerStats(new Game("user"));
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
    public void testAPS3(){
        System.out.println("Starting testAdjustPlayerStat: nightOut, superSleep, groceryHaul " +
                "function when all the stat is set to 0");

        AdjustPlayerStats adjuster = new AdjustPlayerStats(new Game("user"));
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
    public void testAPS4(){
        System.out.println("Starting testAdjustPlayerStat: nightOut, superSleep, groceryHaul " +
                "function when all the stat is set to default");

        AdjustPlayerStats adjuster = new AdjustPlayerStats(new Game("user"));

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
    public void testAPS5(){
        System.out.println("Starting testAdjustPlayerStat: studyAI functions with the default stat");

        AdjustPlayerStats adjuster = new AdjustPlayerStats(new Game("user"));

        adjuster.studyAi();
        assertEquals("Happiness Should be 30",30,adjuster.getHappiness());
        assertEquals("Energy should be 35",35,adjuster.getEnergy());
        assertEquals("Food should be 42",42,adjuster.getFood());
        assertEquals("AI knowledge should 2",2,adjuster.getAiKnowledge());

        System.out.println("Finished testAdjustPlayerStat: studyAI functions with default stat\n");
    }

    @Test
    public void testAPS6(){
        System.out.println("Starting testAdjustPlayerStat: studyDatabases functions with the default stat");

        AdjustPlayerStats adjuster = new AdjustPlayerStats(new Game("user"));

        adjuster.studyDatabases();
        assertEquals("Happiness Should be 30 after nightOut",30,adjuster.getHappiness());
        assertEquals("Energy should be 35",35,adjuster.getEnergy());
        assertEquals("Food should be 42",42,adjuster.getFood());
        assertEquals("Databases knowledge should 2",2,adjuster.getDatabasesKnowledge());

        System.out.println("Finished testAdjustPlayerStat: studyDatabases functions with default stat\n");
    }

    @Test
    public void testAPS7(){
        System.out.println("Starting testAdjustPlayerStat: studyGraphics functions with the default stat");

        AdjustPlayerStats adjuster = new AdjustPlayerStats(new Game("user"));

        adjuster.studyGraphics();
        assertEquals("Happiness Should be 30 after nightOut",30,adjuster.getHappiness());
        assertEquals("Energy should be 35",35,adjuster.getEnergy());
        assertEquals("Food should be 42",42,adjuster.getFood());
        assertEquals("Graphics knowledge should 2",2,adjuster.getGraphicsKnowledge());

        System.out.println("Finished testAdjustPlayerStat: studyGraphics functions with default stat\n");
    }
}
