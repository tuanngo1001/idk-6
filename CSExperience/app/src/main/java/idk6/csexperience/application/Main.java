package idk6.csexperience.application;

/*
    Stripped right out of the sample project also... I have zero shame
 */

public class Main
{
    private static String dbName="CSExperienceDB";

    public static void main(String[] args) {
    }

    public static void setDBPathName(final String name) {
        System.out.println("DATA BASE PATH NAME: " + name);
        try {
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        dbName = name;
    }

    public static String getDBPathName() {
        return dbName;
    }
}
