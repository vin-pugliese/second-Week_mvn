package employees;

import utils.DBUtils;
import java.io.IOException;
import java.sql.SQLException;


public class TableCreator extends DBUtils implements Runnable{

    public void run() {
        try {
            conn = this.startConnection();

            rp.read("sql.properties");
            String sql = rp.getProperties().getProperty("createTable");

            statement = conn.createStatement();
            statement.executeUpdate(sql);
            L.info("tabella creata");


        } catch (SQLException | IOException e) {
            L.info("-----------tabella NON creata----------");
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
    }

}
