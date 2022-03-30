package db.anagrafica;

import db.first_DB.DBConstant;
import utils.Log;

import java.sql.*;

public class DBCreator extends Thread{

    static Log L = Log.getInstance();
    private Connection conn;
    private Statement statement;

    public void run()  {
        conn = startNewConnection();

        String sql = "CREATE SCHEMA `dipartimento` ;";

        try {
            statement = conn.createStatement();

            statement.executeUpdate(sql);
            L.info("Database creato");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                this.closeAll();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }

    private void closeAll() throws SQLException {
            if (statement != null) statement.close();
            if (conn != null) conn.close();
    }

    public Connection startNewConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(DBConstant.getDBNEW(), DBConstant.getDBUSR(), DBConstant.getDBPSW());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
