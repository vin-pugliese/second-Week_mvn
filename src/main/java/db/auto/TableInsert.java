package db.auto;

import utils.DBUtils;
import utils.Log;
import utils.ReadProperties;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class TableInsert implements Runnable{

    static Log L = Log.getInstance();
    private Connection conn = null;
    private ReadProperties rp = new ReadProperties();
    private PreparedStatement ps = null;
    DBUtils dbu = new DBUtils();


    public void run() {

        try {
            conn = dbu.startConnection();

            for(int i=0; i<1; i++) {

                ps = conn.prepareStatement("INSERT INTO auto (`marchio`, `nazione`, `fatturato`, `dipendenti`) VALUES (?,?,?,?);");
                Scanner sc = new Scanner(System.in);

                System.out.println("Inserisci marchio");
                ps.setString(1, sc.nextLine());

                System.out.println("nInserisci nazione");
                ps.setString(2, sc.nextLine());

                System.out.println("Inserisci fatturatoo");
                ps.setInt(3, sc.nextInt());

                System.out.println("Inserisci dipendenti");
                ps.setInt(4, sc.nextInt());


                if (ps.executeUpdate() != 0) L.info("Aggiunto ");
                else L.info("non aggiunto");

                ps.clearParameters();
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
    }

    private void closeAll()  {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

}


