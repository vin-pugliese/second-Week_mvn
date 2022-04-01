package marketDB;

import marketDB.bean.Client;
import utils.DBUtils;

import java.io.IOException;
import java.sql.SQLException;


public class Client_CRUD extends DBUtils implements Ops<Client>{


    @Override
    public void insert(Client x) {
        try {
            conn = this.startConnection("market.properties");
            rp.read("market.properties");

            ps = conn.prepareStatement(rp.getProperties().getProperty("insertClient"));

            ps.setString(1, x.getFirstName());
            ps.setString(2, x.getLastName());
            ps.setInt(3, x.getAge());

            if (ps.executeUpdate() != 0) L.info("Aggiunto " + x.getFirstName());
            else L.info("non aggiunto");

            ps.clearParameters();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
    }

    @Override
    public void update(Client x) {
        try {
            conn = this.startConnection("market.properties");
            rp.read("market.properties");

            ps = conn.prepareStatement(rp.getProperties().getProperty("updateClient"));

            ps.setInt(4, x.getId());
            ps.setString(1, x.getFirstName());
            ps.setString(2, x.getLastName());
            ps.setInt(3, x.getAge());


            if (ps.executeUpdate() != 0) L.info("Cliente id:" + x.getId() + " modificato");
            else L.info("Cliente id:" + x.getId() + " non modificato");

            ps.clearParameters();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
    }

    @Override
    public void delete(Client x) {
        try {
            conn = this.startConnection("market.properties");
            rp.read("market.properties");

            ps = conn.prepareStatement(rp.getProperties().getProperty("deleteClient"));

            ps.setInt(1, x.getId());

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
    public void findByKey(int id) {
        try {
            conn = this.startConnection("market.properties");
            rp.read("market.properties");

            ps = conn.prepareStatement(rp.getProperties().getProperty("findbykeyClient"));

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
            conn = this.startConnection("market.properties");
            rp.read("market.properties");

            statement = conn.createStatement();

            rs = statement.executeQuery(rp.getProperties().getProperty("selectClient"));

            this.printer(rs);
        } catch (IOException | SQLException e) {
            e.getMessage();
        } finally {
            this.closeAll();
        }
    }
}
