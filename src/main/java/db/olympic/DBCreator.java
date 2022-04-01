package db.olympic;

import utils.DBUtils;

import java.io.IOException;
import java.sql.SQLException;

public class DBCreator extends DBUtils implements Runnable {

    @Override
    public void run() {
        try {
            conn = this.newSchemaConnection();
            statement = conn.createStatement();
            rp.read("athlete.properties");
            String sql = rp.getProperties().getProperty("newSchema");

            statement.executeUpdate(sql);
            L.info("Database creato");


            conn.close();
            statement.close();

            conn = this.startConnection("athlete.properties");

            String sql2 = rp.getProperties().getProperty("newTable");

            statement = conn.createStatement();
            statement.executeUpdate(sql2);
            L.info("tabella creato");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
    }

}
