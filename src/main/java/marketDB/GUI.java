package marketDB;

import marketDB.bean.Client;
import marketDB.bean.Order;

import java.util.Scanner;

public class GUI implements Runnable {

    Scanner sc = new Scanner(System.in);
    Client_CRUD cc = new Client_CRUD();
    Order_CRUD oc = new Order_CRUD();

    Client c = new Client();
    Order o = new Order();

    @Override
    public void run() {


        int x;
        do {
            System.out.println("\nScegli l'operazione: \n" +
                    "1 - Mostra tutti i clienti\n" +
                    "2 - Mostra tutti gli ordini\n" +
                    "3 - Modifica cliente\n" +
                    "4 - Modifica ordine\n" +
                    "5 - Inserisci cliente\n" +
                    "6 - Inserisci ordine\n" +
                    "7 - Trova cliente\n" +
                    "8 - Trova ordine\n" +
                    "9 - Trova clienti da ordini\n" +
                    "-1 - esci\n");
            x = sc.nextInt();
            switch (x) {
                case 1:
                    cc.findAll();
                    break;
                case 2:
                    oc.findAll();
                    break;
                case 3:
                    System.out.println("Inserisci l'id del cliente da modificare");
                    c.setId(sc.nextInt());
                    sc.nextLine();      //workaround that prevents scanner from skipping inputs

                    c = this.clientQuestions(c);

                    cc.update(c);
                    break;
                case 4:

                    System.out.println("Inserisci l'id dell'ordine da modificare\n");
                    o.setIdOrder(sc.nextInt());
                    o = this.orderQuestions(o);

                    oc.update(o);
                    break;
                case 5:
                    sc.nextLine();      //workaround that prevents scanner from skipping inputs
                    c = this.clientQuestions(c);
                    cc.insert(c);
                    break;
                case 6:

                    o = this.orderQuestions(o);
                    oc.insert(o);
                    break;
                case 7:
                    System.out.println("Inserisci l'id del cliente da cercare:\n");
                    cc.findByKey(sc.nextInt());
                    break;
                case 8:
                    System.out.println("Inserisci l'id dell'ordine da cercare:\n");
                    oc.findByKey(sc.nextInt());
                    break;
                case 9:
                    System.out.println("trova un cliente inserendo un id ordine:\n");
                    oc.findByForeignKey(sc.nextInt());
                    break;
                case -1:
                    System.exit(0);
            }
        } while (x != -1);

    }

    private Client clientQuestions(Client c) {
        //sc.nextLine();
        System.out.println("Inserisci nome");
        c.setFirstName(sc.nextLine());

        System.out.println("Inserisci cognome");
        c.setLastName(sc.nextLine());

        System.out.println("Inserisci l'età");
        c.setAge(sc.nextInt());

        return c;

    }

    private Order orderQuestions(Order o) {
        sc.nextLine();
        System.out.println("Inserisci numero ordine");
        o.setNOrder(sc.nextLine());

        System.out.println("Inserisci id cliente");
        o.setId_client(sc.nextInt());

        return o;
    }

}


