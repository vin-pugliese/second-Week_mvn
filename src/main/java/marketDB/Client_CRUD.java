package marketDB;

import marketDB.bean.Client;
import utils.DBUtils;

import java.io.IOException;
import java.sql.SQLException;

public class Client_CRUD extends DBUtils implements Ops<Client>{


    @Override
    public void insert(Client x) {
        try {
            conn = this.startConnection("athlete.properties");
            rp.read("athlete.properties");

            ps = conn.prepareStatement(rp.getProperties().getProperty("insert"));

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

    }

    @Override
    public void delete(Client x) {

    }

    @Override
    public void findByKey(Client x) {

    }
}
