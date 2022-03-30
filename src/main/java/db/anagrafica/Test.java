package db.anagrafica;

/*
 * creare un nuovo db nome DIPARTIMENTO
 * aggiungere tabella ANAGRAFICA(id, nome, cognome, eta, citta, cap)
 * Scrivere un programma JAVA che effettui
 * l’inserimento dei nominativi e stampi i record della tabella a video
 *Il programma deve utilizzare dei thread
 *
 * */

public class Test {

    public static void main(String[] args) throws InterruptedException {

        DBCreator dbc = new DBCreator();
        DBTableCreator dbt = new DBTableCreator();
        DBInsert dbi = new DBInsert();
        DBPrinter dbp = new DBPrinter();

        Thread creator = new Thread(dbc);
        creator.setPriority(1);
        creator.setName("creator");

        Thread tableCreator = new Thread(dbt);
        tableCreator.setPriority(2);
        tableCreator.setName("operator");


        Thread insert = new Thread(dbi);
        insert.setPriority(3);
        insert.setName("insert");

        Thread printer = new Thread(dbp);
        printer.setPriority(4);
        printer.setName("printer");


        creator.start();
        Thread.sleep(2000);
        tableCreator.start();
        insert.start();
        Thread.sleep(2000);
        printer.start();




    }
}
