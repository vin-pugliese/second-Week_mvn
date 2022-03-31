package employees;

import employees.bean.Employee;
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
    private DBUtils dbu = new DBUtils();
    private ReadProperties rp = new ReadProperties();
    private Scanner sc = new Scanner(System.in);

    /**
     * @method insert
     * Adds a new row to db
     */
    @Logger(item = "We are into insert")
    public void insert() {

        try {
            conn = dbu.startConnection();
            rp.read("sql.properties");

            Employee e = new Employee();

            ps = conn.prepareStatement(rp.getProperties().getProperty("insert"));

            for (int i = 0; i < 1; i++) {
                System.out.println("Inserisci nome");
                e.setName(sc.nextLine());

                System.out.println("nInserisci cognome");
                e.setLastname(sc.nextLine());
            }
            ps.setString(1, e.getName());
            ps.setString(2, e.getLastname());


            if (ps.executeUpdate() != 0) L.info("Aggiunto ");
            else L.info("non aggiunto");

            //ps.clearParameters();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
    }

    /**
     * @method update
     * update a row in the table Employees via the given ID
     */
    public void update() {
        try {
            conn = dbu.startConnection();
            rp.read("sql.properties");

            ps = conn.prepareStatement(rp.getProperties().getProperty("update"));

                System.out.println("Inserire l'id dell'impiegato da modificare");
                ps.setInt(3, sc.nextInt());

            for (int i = 0; i < 1; i++) {
                System.out.println("Inserire nuovo nome");
                ps.setString(1, sc.nextLine());

                System.out.println("Inserire nuovo cognome");
                ps.setString(2, sc.nextLine());
            }

            if (ps.executeUpdate() != 0) L.info("Aggiunto ");
            else L.info("non aggiunto");

            //ps.clearParameters();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
    }

    /**
     * @method delete
     * deletes a row in the table Employees via the given ID
     */
    public void delete() {
        try {
            conn = dbu.startConnection();
            rp.read("sql.properties");

            ps = conn.prepareStatement(rp.getProperties().getProperty("delete"));

            System.out.println("Inserire l'id dell'impiegato da eliminare");
            ps.setInt(1, sc.nextInt());

            if (ps.executeUpdate() != 0) L.info("Eliminato ");
            else L.info("non Eliminato");

            ps.clearParameters();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }

    }

    /**
     * @method showAll
     * prints all the rows in the table Employees
     */
    public void showAll() {
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


    /**
     * @method closeAll
     * closes all connections - statements - preparedStaments
     */
    private void closeAll() {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
