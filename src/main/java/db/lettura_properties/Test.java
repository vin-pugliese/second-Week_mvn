package db.lettura_properties;

import java.sql.SQLException;

public class Test {

    public static void main(String[] args) throws SQLException {
        DbAccess dba = new DbAccess();

        //dba.createTable();
        dba.insert();
    }
}
