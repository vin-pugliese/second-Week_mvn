package db.first_DB;

import java.sql.SQLException;

public class DBRunner {
    public static void main(String[] args) throws SQLException {

        DbAccess dba = new DbAccess();

        //stampa *from db.studente
        dba.readDB();
        System.out.println("-----------------------------------------------");

        //aggiunge uno studente
        dba.addStudente();
        System.out.println("-----------------------------------------------");

        //stampa *from db.studente
        dba.readDB();



    }
}
