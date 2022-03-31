package employees;

import db.singleton.DbOperator_Singleton;

import java.util.Scanner;

public class Scanner_Singleton {

    public static Scanner instance;

    public static Scanner getInstance(){
        if(instance == null)
            synchronized (DbOperator_Singleton.class) {
                instance = new Scanner(System.in);
            }
        return instance;
    }
}
