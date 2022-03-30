package db.anagrafica;

import db.first_DB.DBConstant;
import utils.Log;

import java.sql.*;

public class DBInsert extends Thread {

    static Log L = Log.getInstance();
    private Connection conn = null;

    private PreparedStatement ps;


    public void run() {


        conn = this.startConnection();

        String sql = "INSERT INTO anagrafica (`idPersona`, `name`, `lastname`, `age`, `city`, `cap`) VALUES ('1', 'vincenzo', 'pugliese', '25', 'sala', '94036'); ";


        try {
            ps = conn.prepareStatement(sql);

            if (ps.executeUpdate() != 0) L.info("Aggiunto ");
            else L.info("non aggiunto");

            sql = "INSERT INTO anagrafica (`idPersona`, `name`, `lastname`, `age`, `city`, `cap`) VALUES ('2', 'giovanni', 'pugliese', '24', 'salerno', '84036');";

            ps = conn.prepareStatement(sql);
            if (ps.executeUpdate() != 0) L.info("Aggiunto ");
            else L.info("non aggiunto");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.closeAll();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    private void closeAll() throws SQLException {
        if (ps != null) ps.close();
        if (conn != null) conn.close();
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
}
