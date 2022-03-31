package employees;

import java.util.Scanner;

public class Gui_Manager implements Runnable{

    DBOperator dbo = new DBOperator();
    Scanner sc = new Scanner(System.in);


    @Override
    public void run() {

        int x;
        do{
            System.out.println("\nScegli l'operazione: \n" +
                    "1 - Mostra tutti\n" +
                    "2 - Inserisci nuovo\n" +
                    "3 - Modifica\n" +
                    "4 - Elimina\n" +
                    "-1 - esci");
            x = sc.nextInt();
            switch (x){
                case 1:
                    dbo.showAll();
                    break;
                case 2:
                    dbo.insert();
                    break;
                case 3:
                    dbo.update();
                    break;
                case 4:
                    dbo.delete();
                    break;
                case -1: System.exit(0);
            }
        } while(x!= -1);

    }
}
