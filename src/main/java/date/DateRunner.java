package date;

import utils.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateRunner {

    public static void main(String[] args) {
        Log L = Log.getInstance();
        Date date = new Date();
        L.info(date.toString());

        DateFormat format = DateFormat.getDateInstance();
        L.info(format.format(date));


        DateFormat format2 = DateFormat.getDateInstance(DateFormat.FULL);
        L.info(format2.format(date));

        DateFormat format3 = DateFormat.getDateInstance(DateFormat.LONG);
        L.info(format3.format(date));

        DateFormat format4 = DateFormat.getDateInstance(DateFormat.MEDIUM);
        L.info(format4.format(date));

        DateFormat format5 = DateFormat.getDateInstance(DateFormat.SHORT);
        L.info(format5.format(date));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //eventualmente anche solo yy
        L.info(sdf.format(date));

        SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");
        L.info(sdf2.format(date));

        try{
            String nat ="25/12/2020";
            Date nate = sdf.parse(nat);
            L.info(nate.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ;

    }
}
