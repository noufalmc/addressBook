package corejava;

import java.util.HashMap;
import java.util.Scanner;
import static java.lang.System.exit;
class addressBookCollection
{
    HashMap<String,AddressBook>addressBook=new HashMap();
    static Scanner sc=new Scanner(System.in);
    String name;
    public void menu()
    {
        int option;
        while(true)
        {
            System.out.println("***Enter Your choice***\n" +
                    "[1] Add Diary\n" +
                    "[2] Display Diary\n" +
                    "[3] Opearte with Diary\n" +
                    "[] Any Number Press For Exit\n");
            option=sc.nextInt();
           switch (option)
           {
               case 1:
                   addDiary();
                   break;
               case 2:
                   displayAddressBook();
                   break;
               case 3:
                   operateWithBook();
                   break;
               default:
                   exit(0);
                   break;
           }
        }

    }
    public void addDiary()
    {
        sc.nextLine();
        System.out.println("Enter Diary Name");
        name=sc.nextLine();
        if(existOrNot(name)) {
            AddressBook ad = new AddressBook(name);
            addressBook.put(name,ad);
            System.out.println("Added Diary Name");
        }
        else
        {
            System.out.println("Diary Name Already Exist");
        }
    }
    public boolean existOrNot(String name)
    {
      if(addressBook.containsKey(name))
      {
          return  false;
      }
      return true;
    }
    public void operateWithBook()
    {
        System.out.println("Enter The DiaryName");
        name= sc.next();
        if(!existOrNot(name))
        {
            addressBook.get(name).operations(addressBook.get(name));
        }

    }
    public void displayAddressBook()
    {
        for (String key: addressBook.keySet()){
            System.out.println(key +" = "+addressBook.get(key)+"\n");
        }
    }
}
public class ContactMain {
    public static  void main(String args[])
    {
        System.out.println("Welcome To Address Book!!!");
        addressBookCollection ad=new addressBookCollection();
        ad.menu();
    }
}
