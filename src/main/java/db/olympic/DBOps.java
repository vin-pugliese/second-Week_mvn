package db.olympic;

import db.olympic.Bean.Athlete;
import utils.DBUtils;

import java.io.IOException;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DBOps extends DBUtils implements baseRepo<Athlete> {

    //Scanner sc = new Scanner(System.in);


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

            if (ps.executeUpdate() != 0) L.info("Aggiunto " + x.getName());
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
        try {
            conn = this.startConnection("athlete.properties");
            rp.read("athlete.properties");

            ps = conn.prepareStatement(rp.getProperties().getProperty("delete"));

            ps.setInt(1, id);

            if (ps.executeUpdate() != 0) L.info("Eliminato ");
            else L.info("non Eliminato");

            ps.clearParameters();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
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

            if (ps.executeUpdate() != 0) L.info("Atleta id:" + x.getId() + " modificato");
            else L.info("Atleta id:" + x.getId() + " non modificato");

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
        List<Athlete> x = new ArrayList<Athlete>();
        try {
            conn = this.startConnection("athlete.properties");
            rp.read("athlete.properties");

            ps = conn.prepareStatement(rp.getProperties().getProperty("selecteight"));

            ps.setDouble(1, height);

            rs = ps.executeQuery();
            Athlete y = new Athlete();
            ResultSetMetaData md = rs.getMetaData();

            while (rs.next()) {
                y.setId(rs.getInt(1));
                y.setName(rs.getString(2));
                y.setNation(rs.getString(3));
                y.setBirthday(rs.getDate(4));
                y.setHeight(rs.getDouble(5));
                x.add(y);
            }
            ps.clearParameters();
            rs.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
        return x;
    }

    /**
     * @param date
     * @return
     * @Method getSQLDate
     * casts a java.util.date into a SQL.date in order to execute CRUD operations
     */
    private java.sql.Date getSQLDate(Date date) {
        long timeInMilliSeconds = date.getTime();
        java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
        return date1;
    }
}
