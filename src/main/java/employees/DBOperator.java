package employees;

import utils.DBUtils;
import utils.Log;
import utils.ReadProperties;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class DBOperator {

    static Log L = Log.getInstance();
    private Connection conn = null;
    private PreparedStatement ps = null;
    DBUtils dbu = new DBUtils();
    ReadProperties rp = new ReadProperties();



    public void insert() {

        try {
            conn = dbu.startConnection();
            rp.read("sql.properties");

            ps = conn.prepareStatement(rp.getProperties().getProperty("insert"));
            CommandLineUtility c = CommandLineUtility.getInstance();
            for(int i=0; i<1; i++) {
                System.out.println("Inserisci nome");
                ps.setString(1, c.stringFromCommand());

                System.out.println("nInserisci cognome");
                ps.setString(2, c.stringFromCommand());
            }

            if (ps.executeUpdate() != 0) L.info("Aggiunto ");
            else L.info("non aggiunto");

            ps.clearParameters();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
    }

    public void update() {
        try {
            conn = dbu.startConnection();
            rp.read("sql.properties");
            CommandLineUtility c = CommandLineUtility.getInstance();
            ps = conn.prepareStatement(rp.getProperties().getProperty("update"));

            System.out.println("Inserire l'id dell'impiegato da modificare");
            ps.setInt(3, c.intFromCommand());

            System.out.println("Inserire nuovo nome");
            ps.setString(1, c.stringFromCommand());

            System.out.println("Inserire nuovo cognome");
            ps.setString(2, c.stringFromCommand());

            if (ps.executeUpdate() != 0) L.info("Aggiunto ");
            else L.info("non aggiunto");

            ps.clearParameters();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
    }

    public void delete() {
        try {
            conn = dbu.startConnection();
            rp.read("sql.properties");
            CommandLineUtility c = CommandLineUtility.getInstance();
            ps = conn.prepareStatement(rp.getProperties().getProperty("delete"));

            System.out.println("Inserire l'id dell'impiegato da eliminare");
            ps.setInt(1, c.intFromCommand());

            if (ps.executeUpdate() != 0) L.info("Aggiunto ");
            else L.info("non aggiunto");

            ps.clearParameters();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }

    }

    public void showAll(){
        ResultSet rs = null;
        Statement statement = null;
        try {
            conn = dbu.startConnection();
            rp.read("sql.properties");

            statement = conn.createStatement();

            rs = statement.executeQuery(rp.getProperties().getProperty("select"));

            dbu.printer(rs);
        } catch (IOException | SQLException e) {
            e.getMessage();
        } finally {
            this.closeAll();
        }
    }

    private void closeAll() {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
