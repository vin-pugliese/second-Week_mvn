package db.auto;

public class Test {


    public static void main(String[] args) throws InterruptedException {

        TableCreator tc = new TableCreator();
        TableInsert ti = new TableInsert();

        tc.run();
        Thread.sleep(1000);
        ti.run();


    }

}
