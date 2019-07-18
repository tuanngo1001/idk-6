package idk6.csexperience.application;


import idk6.csexperience.persistence.PlayerCustomizationPersistence;
import idk6.csexperience.persistence.ExamsPersistence;
import idk6.csexperience.persistence.PlayerStatsPersistence;
import idk6.csexperience.persistence.PlayerTimePersistence;
import idk6.csexperience.persistence.hsqldb.ExamsPersistenceHSQLDB;
import idk6.csexperience.persistence.hsqldb.PlayerStatsPersistenceHSQLDB;
import idk6.csexperience.persistence.hsqldb.PlayerTimePersistenceHSQLDB;

/*
    Services
    Purpose: Provide access to globally accessible databases
 */

public class Services {
    private static PlayerStatsPersistence playerStatsPersistence;
    private static ExamsPersistence playerExamsPersistence;
    private static PlayerTimePersistence playerTimePersistence;
    //private static PlayerCustomizationPersistence playerCustomizationPersistence;

    public static synchronized PlayerStatsPersistence getPlayerStatsPersistence(){
        if(playerStatsPersistence == null){
            playerStatsPersistence = new PlayerStatsPersistenceHSQLDB(Main.getDBPathName());
        }
        return playerStatsPersistence;
    }

    public static synchronized ExamsPersistence getPlayerExamsPersistence(){
        if(playerExamsPersistence == null){
            playerExamsPersistence = new ExamsPersistenceHSQLDB(Main.getDBPathName());
        }
        return playerExamsPersistence;
    }


    public static synchronized PlayerTimePersistence getPlayerTimePersistence(){
        if(playerTimePersistence == null){
            playerTimePersistence = new PlayerTimePersistenceHSQLDB(Main.getDBPathName());
        }
        return playerTimePersistence;
    }

    /* --------------------------------SOON---------------------------------------------------

    public static synchronized PlayerCustomizationPersistence getPlayerCustomizationPersistence(){
        if(playerCustomizationPersistence == null){
            playerCustomizationPersistence = new PlayerCustomizationPersistence(Main.getDBPathName());
        }
        return playerCustomizationPersistence;
    }

  --------------------------------------------------------------------------------------- */

}
