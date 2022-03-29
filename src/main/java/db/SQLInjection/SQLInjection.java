package db.SQLInjection;

import db.first_DB.DBConstant;

import java.sql.*;

public class SQLInjection {
    private Connection conn;
    private Statement statement;
    private PreparedStatement ps;
    private ResultSet rs;


    public void step1() throws SQLException {
        try {
            conn = startConnection();

            statement = conn.createStatement();

            String username = "admin";
            String password = "admin";
            String query = "SELECT * FROM db.users where username = '"
                    + username + "' and password = '" + password + "'";
            ResultSet result = statement.executeQuery(query);


            if (result.next()) {
                System.out.println("id = " + result.getInt("id") + " | username = "
                        + result.getString("username") + " | password = " +
                        result.getString("password"));
            }else{
                System.out.println("Login not correct");
            }



        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }

    }


    public void readDB() throws SQLException {

        try {
            conn = startConnection();

            statement = conn.createStatement();

            rs = statement.executeQuery("SELECT * FROM fornitori");

            ResultSetMetaData md = rs.getMetaData();

            while (rs.next()) {
                System.out.println("");
                for (int i = 1; i <= md.getColumnCount(); i++)
                    System.out.println(rs.getString(i));
            }

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            this.closeConnection();
        }
    }

    /**
     * @method closeConnection
     * chiude tutte le connessione aperte
     * @throws SQLException
     */
    public void closeConnection() throws SQLException {
        if (statement != null) statement.close();
        if (rs != null) rs.close();
        if (conn != null) conn.close();
        if (ps != null) ps.close();
    }

    /**
     * @method startConnection
     * crea una nuova connessione al database
     * @return la connessione al db
     */
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
