package marketDB;

import marketDB.bean.Order;
import utils.DBUtils;

import java.io.IOException;
import java.sql.SQLException;

public class Order_CRUD extends DBUtils implements Ops<Order> {


    @Override
    public void insert(Order x) {
        try {
            conn = this.startConnection("market.properties");
            rp.read("market.properties");

            ps = conn.prepareStatement(rp.getProperties().getProperty("insertOrder"));

            ps.setString(1, x.getNOrder());
            ps.setInt(2, x.getId_client());


            if (ps.executeUpdate() != 0) L.info("Aggiunto ordine" + x.getNOrder());
            else L.info("non aggiunto");

            ps.clearParameters();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
    }

    @Override
    public void update(Order x) {
        try {
            conn = this.startConnection("market.properties");
            rp.read("market.properties");

            ps = conn.prepareStatement(rp.getProperties().getProperty("updateOrder"));

            ps.setString(1, x.getNOrder());
            ps.setInt(2, x.getId_client());
            ps.setInt(3, x.getIdOrder());


            if (ps.executeUpdate() != 0) L.info("Cliente id:" + x.getNOrder() + " modificato");
            else L.info("Cliente id:" + x.getNOrder() + " non modificato");

            ps.clearParameters();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
    }

    @Override
    public void delete(Order x) {
        try {
            conn = this.startConnection("market.properties");
            rp.read("market.properties");

            ps = conn.prepareStatement(rp.getProperties().getProperty("deleteOrder"));

            ps.setInt(1, x.getIdOrder());

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
    public void findByKey(Order x) {
        try {
            conn = this.startConnection("market.properties");
            rp.read("market.properties");

            ps = conn.prepareStatement(rp.getProperties().getProperty("findbykeyOrder"));

            ps.setInt(1, x.getIdOrder());

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

            rs = statement.executeQuery(rp.getProperties().getProperty("selectOrder"));

            this.printer(rs);
        } catch (IOException | SQLException e) {
            e.getMessage();
        } finally {
            this.closeAll();
        }
    }

    public void findByForeignKey(Order x){
        try {
            conn = this.startConnection("market.properties");
            rp.read("market.properties");

            ps = conn.prepareStatement(rp.getProperties().getProperty("findbyFkey"));

            ps.setInt(1, x.getId_client() );

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

}

