package multithreading;

import utils.Log;

public class Test {



    public static void main(String[] args) throws InterruptedException {

       Log L = Log.getInstance();

        ThreadNumberPrinter t = new ThreadNumberPrinter(1,10);
        NumberPrinterAsRunnable n = new NumberPrinterAsRunnable(20,30);

        Thread tn = new Thread(n);
        tn.setName("Nostro thread");
        tn.start();

        //in questo caso currentThread prende il valore di tn
        Thread currentThread = Thread.currentThread();
        currentThread.setName("current-thread");
        currentThread.setPriority(1);
        currentThread.run();

        Thread.sleep(5000);

        t.start();
        //n.join();                     //non serve nel momento in cui si imposta la priorità
        n.run();

       // L.info("Fatto!");




        System.out.println("fatto!");

    }
}
