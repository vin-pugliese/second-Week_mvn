package db.first_DB;

public class DBConstant {
    private static final String DB_URL = "jdbc:mysql://localhost/db";
    private static final String DB_USR = "root";
    private static final String DB_PSW = "";

    public static String getDBURL(){
        return DB_URL;
    }

    public static String getDBUSR(){
        return DB_USR;
    }

    public static String getDBPSW(){
        return DB_PSW;
    }
}
