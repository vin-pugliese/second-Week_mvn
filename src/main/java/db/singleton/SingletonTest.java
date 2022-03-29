package db.singleton;

import java.sql.SQLException;

public class SingletonTest {
    public static void main(String[] args) throws SQLException {

        DbOperator_Singleton db = DbOperator_Singleton.getInstance();

        String query = "INSERT INTO `db`.`fornitori` (`idFornitori`, `name`, `indirizzo`, `citta`) VALUES ('15', 'asd', 'Via nn', 'Salerno');";


        db.startConnection();
        db.getPreparedStatement(query);

        db.closeConnection();
    }
}
