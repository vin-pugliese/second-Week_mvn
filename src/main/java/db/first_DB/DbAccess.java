package db.first_DB;

import db.first_DB.beans.Studente;

import java.sql.*;

public class DbAccess implements db<ResultSet> {
    private Connection conn;
    private Statement statement;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public void readDB() throws SQLException {

        try {
            conn = startConnection();

            statement = conn.createStatement();

            rs = statement.executeQuery("SELECT * FROM studente");

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

    @Override       //TODO: 28/03/2022
    public void writeDB(ResultSet resultSet) {}


    public void createTablePersona() throws SQLException {
        try {
            conn = startConnection();

            String sql = "CREATE TABLE `db`.`persona` (" +
                    "  `idPersona` INT NOT NULL," +
                    "  `name` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`idPersona`));";

            statement = conn.createStatement();
            statement.executeUpdate(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }
    }

    public void addStudente() throws SQLException {
        Connection conn = startConnection();

        Studente s = new Studente();
        s.setName("vincenzooooo");
        s.setLastname("Puglieseeeeeee");
        s.setEmail("email@email.comcom");
        s.setId(1643);
        s.setAge(25);
        s.setEnabled(1);

        try {
            ps = conn.prepareStatement("INSERT INTO studente(idStudente, name, lastname, email, enabled, age) values(?,?,?,?,?,?)");
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getLastname());
            ps.setString(4, s.getEmail());
            ps.setInt(5, s.getEnabled());
            ps.setInt(6, s.getAge());

            if (ps.executeUpdate() != 0) System.out.println("Added the following: " + s.toString());
            else System.out.println("Failed");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }
    }

/**
     * @method closeConnection
     * chiude tutte le connessione aperte
     * @throws SQLException
*/

    @Override
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



