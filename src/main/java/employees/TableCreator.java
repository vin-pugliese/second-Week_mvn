package employees;

import utils.DBUtils;
import utils.Log;
import utils.ReadProperties;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator implements Runnable{

    static Log L = Log.getInstance();
    private Connection conn;
    private Statement statement;
    private ReadProperties rp = new ReadProperties();
    private DBUtils dbu = new DBUtils();

    public void run() {
        try {
            rp.read("sql.properties");
            conn = dbu.startConnection();

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


    private void closeAll() {
        try {
            if (statement != null) statement.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
