package db.olympic;

import employees.DBOperator;
import employees.Scanner_Singleton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CommandLine implements Runnable {

    DBOps dbo = new DBOps();
    Scanner sc = Scanner_Singleton.getInstance();



    @Override
    public void run() {

        int x;
        do{
            System.out.println("\nScegli l'operazione: \n" +
                    "1 - Mostra tutti\n" +
                    "2 - Inserisci nuovo\n" +
                    "3 - Modifica\n" +
                    "4 - Elimina\n" +
                    "5 - Cerca\n" +
                    "6 - Cerca in base all'altezza\n" +
                    "-1 - esci");
            x = sc.nextInt();
            switch (x){
                case 1:
                    dbo.findAll();
                    break;
                case 2:
                    Athlete a = new Athlete();
                    dbo.insert(this.askQuestions(a));
                    break;
                case 3:
                    Athlete b = new Athlete();
                    System.out.println("Inserisci l'id dell'atleta da modificare");
                    b.setId(sc.nextInt());

                    b= this.askQuestions(b);

                   dbo.update(b);
                    break;
                case 4:
                   // dbo.delete();
                    break;
                case 5:
                    System.out.println("Inserisci l'id\n");
                    dbo.findbykey(sc.nextInt());
                    break;
                case 6:
                    System.out.println("Inserisci l'altezza:\n");
                    List<Athlete> athletes = dbo.findAll(sc.nextDouble());
                    this.printList(athletes);
                    break;
                case -1: System.exit(0);
            }
        } while(x!= -1);

    }

    private Athlete askQuestions (Athlete a){
        System.out.println("Inserisci nome");
        a.setName(sc.nextLine());

        System.out.println("Inserisci nazione");
        a.setNation(sc.nextLine());

        System.out.println("Inserisci data di nascita dd/MM/yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");        /////////////
        try {
            Date date = sdf.parse(sc.nextLine());
            a.setBirthday(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Inserisci altezza");
        a.setHeight(sc.nextDouble());

        return a;
    }

    private void printList(List<Athlete> x){
        for(Athlete a:x)
            a.toString();
    }
}
