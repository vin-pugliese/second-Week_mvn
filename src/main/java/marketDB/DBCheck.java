package marketDB;

import utils.DBUtils;

import java.io.IOException;
import java.sql.SQLException;

public class DBCheck extends DBUtils implements Runnable {
    @Override
    public void run() {
        try {
            //creating schema market
            conn = this.newSchemaConnection();
            statement = conn.createStatement();

            rp.read("market.properties");
            String sql = rp.getProperties().getProperty("createdb");

            statement.executeUpdate(sql);
            L.info("Database market creato");

            conn.close();
            statement.close();

            //creating table clienti
            conn = this.startConnection("market.properties");

            String sql2 = rp.getProperties().getProperty("createclienti");

            statement = conn.createStatement();
            statement.executeUpdate(sql2);
            L.info("tabella clienti creata");
            statement.close();

            //creating table ordini
            String sql3 = rp.getProperties().getProperty("createordini");

            statement = conn.createStatement();
            statement.executeUpdate(sql3);
            L.info("tabella ordini creata");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
    }
}
