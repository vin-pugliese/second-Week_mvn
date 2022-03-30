package multithreading;

import utils.Log;

public class NumberPrinterAsRunnable implements Runnable {
    static Log L = Log.getInstance();
    int min, max;

    public NumberPrinterAsRunnable(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public void run() {
        for(int i=0; i<max; i++)
            L.info("runnable " + String.valueOf(i));
    }
}
