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
        rp.read("application.properties");
        try {
            Class.forName(rp.getDbdriver()).newInstance();
            conn = DriverManager.getConnection(rp.getDburl(), rp.getUser(), rp.getPsw());
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
                for (int i = 1; i <= md.getColumnCount(); i++)
                    System.out.print(rs.getString(i) +"\t\t");

                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
