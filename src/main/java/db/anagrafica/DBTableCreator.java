package db.anagrafica;

import db.first_DB.DBConstant;
import utils.Log;

import java.sql.*;

public class DBTableCreator extends Thread {

    static Log L = Log.getInstance();
    private Connection conn;
    private Statement statement;
    private PreparedStatement ps;
    private ResultSet rs;


    public void run()  {
        conn = this.startConnection();
        try {
            String sql = "CREATE TABLE `dipartimento`.`anagrafica` (" +
                    "  `idPersona` INT NOT NULL," +
                    "  `name` VARCHAR(45) NOT NULL," +
                    " `lastname` VARCHAR(20) NOT NULL, " +
                    " `age` INT NOT NULL, " +
                    " `city` VARCHAR(20) NOT NULL, " +
                    " `cap` VARCHAR(5) NOT NULL, " +
                    "  PRIMARY KEY (`idPersona`));";


            statement = conn.createStatement();
            statement.executeUpdate(sql);
            L.info("tabella creata");


        } catch (
                SQLException e) {
            L.info("-----------tabella NON creata----------");
            e.printStackTrace();
        } finally {
            try {
                this.closeAll();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public Connection startConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(DBConstant.getDBURL(), DBConstant.getDBUSR(), DBConstant.getDBPSW());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return conn;
    }

    private void closeAll() throws SQLException {
        if (statement != null) statement.close();
        if (rs != null) rs.close();
        if (ps != null) ps.close();
        if (conn != null) conn.close();
    }
}
