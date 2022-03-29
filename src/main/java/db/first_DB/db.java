package db.first_DB;

import java.sql.SQLException;

public interface db <T>{
    void readDB() throws SQLException;
    void writeDB(T t);
    void closeConnection() throws SQLException;
}
