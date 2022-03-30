package db.auto;


import utils.DBUtils;
import utils.Log;
import utils.ReadProperties;

import java.io.IOException;
import java.sql.*;

public class TableCreator implements Runnable {

    static Log L = Log.getInstance();
    private Connection conn;
    private Statement statement;
    private ReadProperties rp = new ReadProperties();
    private DBUtils dbu = new DBUtils();

    public void run() {
        try {
            conn = dbu.startConnection();

            String sql = "CREATE TABLE IF NOT EXISTS `db`.`auto` (" +
                    "  `idAuto` INT NOT NULL AUTO_INCREMENT," +
                    "  `marchio` VARCHAR(45) NOT NULL," +
                    " `nazione` VARCHAR(20) NOT NULL, " +
                    " `fatturato` INT NOT NULL, " +
                    " `dipendenti` INT NOT NULL, " +
                    "  PRIMARY KEY (`idAuto`)); ";


            statement = conn.createStatement();
            statement.executeUpdate(sql);
            L.info("tabella creata");


        } catch (SQLException | IOException e) {
            L.info("-----------tabella NON creata----------");
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
    }


    private void closeAll() {
        try {
            if (statement != null) statement.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}



