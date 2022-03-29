package db.fornitori;

import db.first_DB.DBConstant;

import java.sql.*;

public class DbOperator {
    private Connection conn;
    private Statement statement;
    private PreparedStatement ps;
    private ResultSet rs;


    public void createTableFornitori() throws SQLException {
        try {
            conn = startConnection();

            String sql = "CREATE TABLE `db`.`fornitori` (" +
                    "  `idFornitori` INT NOT NULL," +
                    "  `name` VARCHAR(20) NOT NULL," +
                    " `indirizzo` VARCHAR(30) NOT NULL, "+
                    " `citta` VARCHAR(20) NOT NULL, " +
                    "  PRIMARY KEY (`idFornitori`));";

            statement = conn.createStatement();
            statement.executeUpdate(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }

    }

    public void populateFornitori() throws SQLException {

        conn = startConnection();

        String sql = "INSERT INTO db.fornitori VALUES ('001', 'Ladroni', 'Via Ostense', 'Roma'), ('002', 'Risparmietti', 'Viale Marconi', 'Roma'), " +
                " ('010', 'Teloporto', 'Via Roma', 'Milano');";

        try {
            ps = conn.prepareStatement(sql);

            if (ps.executeUpdate() != 0) System.out.println("Added");
            else System.out.println("Failed");

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
