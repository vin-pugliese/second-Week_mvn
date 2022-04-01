package marketDB;

public class TestMarket {

    public static void main(String[] args) {
        DBCheck d = new DBCheck();
        GUI g = new GUI();

        Thread td = new Thread(d);
        td.setPriority(1);

        d.run();
        g.run();
    }

}
