package date;

import utils.Log;

import java.util.GregorianCalendar;

public class GregorianCalendarRunner {


    public static void main(String[] args) {
        Log L = Log.getInstance();
        GregorianCalendar actDate = new GregorianCalendar();
        L.info(String.valueOf(actDate.get(GregorianCalendar.MONTH)));

        GregorianCalendar data1 = new GregorianCalendar(2020, 10,23);
        GregorianCalendar data2 = new GregorianCalendar(2020, 10,22);

        if(data1.before(data2)) System.out.println("data1 viene prima");
        else if (data1.after(data2)) System.out.println("data1 viene dopo");
        else System.out.println("le date sono uguali");



    }
}
