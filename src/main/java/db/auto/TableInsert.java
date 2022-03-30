package db.auto;

import utils.Log;
import utils.ReadProperties;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class TableInsert implements Runnable{

    static Log L = Log.getInstance();
    private Connection conn = null;
    private ReadProperties rp = new ReadProperties();
    private PreparedStatement ps;


    public void run() {

        try {
            conn = this.startConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Scanner sc = new Scanner(System.in);
            for(int i=0; i<6; i++) {
                ps = conn.prepareStatement("INSERT INTO auto (`idAuto`, `marchio`, `nazione`, `fatturato`, `dipendenti`) VALUES (default, ?,?,?,?);", Statement.RETURN_GENERATED_KEYS);



                System.out.println("Inserisci marchio");
                ps.setString(2, sc.nextLine());
                System.out.println("nInserisci nazione");
                ps.setString(3, sc.nextLine());
                System.out.println("Inserisci fatturatoo");
                ps.setInt(4, sc.nextInt());
                System.out.println("Inserisci dipendenti");
                ps.setString(5, sc.nextLine());


                if (ps.executeUpdate() != 0) L.info("Aggiunto ");
                else L.info("non aggiunto");
            }
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

    public Connection startConnection() throws IOException {
        Connection conn = null;
        rp.read();
        try {
            Class.forName(rp.getProperties().getProperty("db.driverUrl")).newInstance();
            conn = DriverManager.getConnection(rp.getProperties().getProperty("db.url"), rp.getProperties().getProperty("db.username"), rp.getProperties().getProperty("db.password"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
