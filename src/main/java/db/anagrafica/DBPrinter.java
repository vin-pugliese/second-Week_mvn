package db.anagrafica;

import db.first_DB.DBConstant;
import utils.Log;

import java.sql.*;

public class DBPrinter extends Thread{

    private Connection conn;
    private Statement statement;
    private ResultSet rs;
    static Log L = Log.getInstance();

    public void run(){
    conn = startConnection();

        try {
        statement = conn.createStatement();

        rs = statement.executeQuery("SELECT * FROM anagrafica");

        ResultSetMetaData md = rs.getMetaData();

        while (rs.next()) {
            System.out.println("");
            for (int i = 1; i <= md.getColumnCount(); i++)
                L.info(rs.getString(i));
        }

    } catch (
    SQLException e) {
        e.getMessage();
    } finally {
            try {
                closeAll();
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
        if (conn != null) conn.close();
    }
}
