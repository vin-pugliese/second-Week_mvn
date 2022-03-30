package utils;

import java.io.IOException;
import java.sql.*;


public class DBUtils {

    static Log L = Log.getInstance();
    ReadProperties rp = new ReadProperties();

    /**
     * Constructor
     */
    public DBUtils(){}

    /**
     * @return la connessione
     * @throws IOException
     * @method startConnection
     * Inizializza una nuova connessione leggendo i parametri dal file 'application.properties'
     */
    public Connection startConnection() throws IOException {
        Connection conn = null;
        rp.read();
        try {
            Class.forName(rp.getProperties().getProperty("db.driverUrl")).newInstance();
            conn = DriverManager.getConnection(rp.getProperties().getProperty("db.url"), rp.getProperties().getProperty("db.username"), rp.getProperties().getProperty("db.password"));
            L.info("Connection with database established");
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * @method printer
     * stampa tutti i dati contenuti nel ResulSet passato come parametro
     * @param rs
     */
    public void printer(ResultSet rs) {
        try {
            ResultSetMetaData md = rs.getMetaData();

            while (rs.next()) {
                System.out.println("");
                for (int i = 1; i <= md.getColumnCount(); i++)
                    L.info(rs.getString(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
