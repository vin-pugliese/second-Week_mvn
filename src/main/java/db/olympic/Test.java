package db.olympic;

import employees.Gui_Manager;
import employees.TableCreator;

public class Test {

    public static void main(String[] args) {
        DBCreator dc = new DBCreator();
        CommandLine c = new CommandLine();

        Thread t = new Thread(dc);
        t.setPriority(1);

        dc.run();
        c.run();
    }
}
