package db.fornitori;

import java.sql.SQLException;

public class DbRunner {
    public static void main(String[] args) throws SQLException {
        DbOperator dbo = new DbOperator();

        dbo.createTableFornitori();
        dbo.readDB();
        dbo.populateFornitori();
        dbo.readDB();
    }
}
