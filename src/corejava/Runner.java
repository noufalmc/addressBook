/*
@ Author : Noufal MC
@ Date   : 20/01/2022
  This class provide interface between
  main class and address book class
* */
package corejava;
import java.util.*;

public class Runner {
    static Scanner sc=new Scanner(System.in);
   private static final Operation op=new Operation();
    public static int choice=1;
    public static void menu()
    {
        while (choice<3)
        {
            System.out.println("Select the Choices\n" +
                    "[1] Add Contacts\n" + "[2] Edit Contacts\n"+
                    "[ ] Any press for exit");
            choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                    op.addContacts();
                    break;
                case 2:
                    op.editContacts();
                    break;
            }
        }
    }
}
