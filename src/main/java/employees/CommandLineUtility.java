package employees;

import db.singleton.DbOperator_Singleton;

import java.util.Scanner;

public class CommandLineUtility {
   Scanner sc = new Scanner(System.in);
   public static CommandLineUtility instance;

   private CommandLineUtility(){}

    public static CommandLineUtility getInstance() {
        if (instance == null)
            synchronized (DbOperator_Singleton.class) {
                instance = new CommandLineUtility();
            }
        return instance;
    }

        public String stringFromCommand(){
        return sc.nextLine();
    }

    public int intFromCommand(){
        return sc.nextInt();
    }
}
