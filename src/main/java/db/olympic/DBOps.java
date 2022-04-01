package db.olympic;

import utils.DBUtils;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DBOps extends DBUtils implements baseRepo<Athlete> {

    //Scanner sc = new Scanner(System.in);

    public void createSchema(){

        try {
            conn = this.newSchemaConnection();
            statement = conn.createStatement();
            rp.read("athlete.properties");
            String sql = rp.getProperties().getProperty("newSchema");

            statement.executeUpdate(sql);
            L.info("Database creato");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {this.closeAll();}
    }


    @Override
    public void insert(Athlete x) {
        try {
            conn = this.startConnection("athlete.properties");
            rp.read("athlete.properties");

            ps = conn.prepareStatement(rp.getProperties().getProperty("insert"));

            ps.setString(1, x.getName());
            ps.setString(2, x.getNation());
            ps.setDate(3, getSQLDate(x.getBirthday()));
            ps.setDouble(4, x.getHeight());

            if (ps.executeUpdate() != 0) L.info("Aggiunto " +x.getName());
            else L.info("non aggiunto");

            ps.clearParameters();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Athlete x) {
        try {
            conn = this.startConnection("athlete.properties");
            rp.read("athlete.properties");

            ps = conn.prepareStatement(rp.getProperties().getProperty("update"));

            ps.setString(1, x.getName());
            ps.setString(2, x.getNation());
            ps.setDate(3, getSQLDate(x.getBirthday()));
            ps.setDouble(4, x.getHeight());
            ps.setInt(5, x.getId());

            if (ps.executeUpdate() != 0) L.info("Atleta id:" + x.getId() +" modificato");
            else L.info("Atleta id:" + x.getId() +" non modificato");

            ps.clearParameters();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }

    }

    @Override
    public void findbykey(int id) {
        try {
            conn = this.startConnection("athlete.properties");
            rp.read("athlete.properties");

            ps = conn.prepareStatement(rp.getProperties().getProperty("findbykey"));

            ps.setInt(1, id);

            rs = ps.executeQuery();
            this.printer(rs);

            ps.clearParameters();
            rs.close();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
    }

    @Override
    public void findAll() {
        try {
            conn = this.startConnection("athlete.properties");
            rp.read("athlete.properties");

            statement = conn.createStatement();

            rs = statement.executeQuery(rp.getProperties().getProperty("select"));

            this.printer(rs);
            rs.close();
        } catch (IOException | SQLException e) {
            e.getMessage();
        } finally {
            this.closeAll();
        }
    }

    @Override
    public List<Athlete> findAll(double height) {
        return null;
    }

    /**
     * @Method getSQLDate
     * casts a java.util.date into a SQL.date in order to execute CRUD operations
     * @param date
     * @return
     */
    private java.sql.Date getSQLDate(Date date){
        long timeInMilliSeconds = date.getTime();
        java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
        return date1;
    }
}
