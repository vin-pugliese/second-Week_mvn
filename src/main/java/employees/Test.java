package employees;

import employees.Gui_Manager;
import employees.TableCreator;

public class Test {


    public static void main(String[] args) {
        TableCreator tc = new TableCreator();
        Gui_Manager g = new Gui_Manager();

        Thread t = new Thread(tc);
        t.setPriority(1);

        tc.run();
        g.run();


    }
}
