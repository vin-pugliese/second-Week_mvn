package multithreading;

import utils.Log;

public class ThreadNumberPrinter extends Thread{

    static Log L = Log.getInstance();
    int min;
    int max;

    public ThreadNumberPrinter(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public void run(){
        for(int i=0; i<max; i++){
            L.info("threadprinter " +String.valueOf(i));
        }
    }
}
