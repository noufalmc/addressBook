/**
 * @author :Noufal mc
 * date:22/01/22
 * Multiple address book system
 * */
package corejava;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static java.lang.System.exit;
class addressBookCollection
{
    HashMap<String,AddressBook>addressBook=new HashMap();
    public static Map<String, List<Person>> cityDictionary = new HashMap<>();
    public static Map<String, List<Person>> stateDictionary = new HashMap<>();
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
                    "[4] Search Person"+
                    "[5] Count The City\n"+
                    "[5] Count The State\n"+
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
               case 4:
                   searchByPesron();
                   break;
               case 5:
                   getCountCity();
                   break;
               case 6:
                   getCountState();
                   break;
               default:
                   exit(0);
                   break;
           }
        }

    }

    /**
     * Method is used for search the person by city or state
     * take input from user for option
     */
    private void searchByPesron()
    {

        System.out.println("Enter Your choice [1]City [2]State");
        int choice= sc.nextInt();
        switch (choice)
        {
            case 1:
                System.out.println("Enter City Name");
                String city=sc.next();
                for (AddressBook address:addressBook.values())
                {
                    address.searchByCity(city);
                }
                break;
            case 2:
                System.out.println("Enter State Name");
                String state=sc.next();
                for (AddressBook address:addressBook.values())
                {
                    address.searchByState(state);
                }
                break;
        }
    }

    public void addDiary()
    {

        System.out.println("Enter Diary Name");
        name=sc.next();
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
        else
        {
            System.out.println("Diary Name Not Found!!!!");
        }

    }
    public void displayAddressBook()
    {
        for (String key: addressBook.keySet()){
            System.out.println(key +" = "+addressBook.get(key)+"\n");
        }
    }

    /**
     * Count By City
     */
    public void getCountCity()
    {
        Map<String, List<Person>> dictMap = new HashMap<>();
        for (AddressBook book : addressBook.values()) {
            book.getMapCity().forEach((key, value) -> dictMap.merge(key, value,
                    (state, contact) -> {
                        state.addAll(contact);
                        return state;
                    }));
        }
        cityDictionary = dictMap;
        cityDictionary.forEach(
                ((key, value) -> System.out.println(key + " " + value + " Total count is: " + value.size())));
    }

    /**
     * Count By state
     */
    public void getCountState()
    {
        Map<String, List<Person>> dictMap = new HashMap<>();
        for (AddressBook book : addressBook.values()) {
            book.getMapCity().forEach((key, value) -> dictMap.merge(key, value,
                    (state, contact) -> {
                        state.addAll(contact);
                        return state;
                    }));
        }
        stateDictionary = dictMap;
        stateDictionary.forEach(
                ((key, value) -> System.out.println(key + " " + value + " Total count is: " + value.size())));
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
