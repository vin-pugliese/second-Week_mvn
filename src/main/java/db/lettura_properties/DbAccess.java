package db.lettura_properties;

/*
 * crea una tabella con 4 campi
 * marca tipo modello costo
 * fare un insert
 * un update parametrico
 *
 * utilizzare sia log che readproperties
 *
 *
 * */

import utils.ReadProperties;

import java.io.IOException;
import java.sql.*;

public class DbAccess {

    private Connection conn;
    private Statement statement;
    private PreparedStatement ps;
    private ResultSet rs;
    ReadProperties rp = new ReadProperties();


    /**
     * @method createTable
     * @throws SQLException
     */
    public void createTable() throws SQLException {
        try {
            conn = startConnection();

            statement = conn.createStatement();
            statement.executeUpdate(rp.getProperties().getProperty("createTable"));


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }
    }

    /**
     * @method insert
     * @throws SQLException
     */
    public void insert() throws SQLException {
        conn = startConnection();
        try {
            ps = conn.prepareStatement(rp.getProperties().getProperty("insert"));


            if (ps.executeUpdate() != 0) System.out.println("Added");
            else System.out.println("Failed");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }
    }

    /**
     * @method startConnection
     * @return connection
     */
    public Connection startConnection() {
        Connection conn = null;
        try {
            rp.read();


            Class.forName(rp.getProperties().getProperty("db.driverUrl")).newInstance();
            conn = DriverManager.getConnection(rp.getProperties().getProperty("db.url"), rp.getProperties().getProperty("db.username"), rp.getProperties().getProperty("db.password"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * @method closeConnection
     * @throws SQLException
     */
    private void closeConnection() throws SQLException {
        if (statement != null) statement.close();
        if (rs != null) rs.close();
        if (conn != null) conn.close();
        if (ps != null) ps.close();
    }
}
