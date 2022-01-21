package corejava;
/*
@Author : Noufal MC
@Date   : 20/01/2022
 This Class Implements the Operations of the Address Book
* */
import java.util.*;
public class Operation
{
    ArrayList<Person> addressBook=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    String lastName,address,email,city,mobile,firstName,state;
    int zip;
    /*
    * Add contacts In address Book
    * This Function Called In runner class
    * */
    public  void addContacts()
    {
        System.out.println("Enter the FirstName");
        firstName=sc.nextLine();
        System.out.println("Enter the LastName");
        lastName=sc.nextLine();
        System.out.println("Enter the Address");
        address=sc.nextLine();
        System.out.println("Enter the City");
        city=sc.nextLine();
        System.out.println("Enter the State");
        state=sc.nextLine();
        System.out.println("Enter the Email");
        email=sc.nextLine();
        System.out.println("Enter the Mobile");
        mobile=sc.nextLine();
        System.out.println("Enter the Pincode");
        zip=sc.nextInt();
        Person p=new Person(firstName,lastName,address,city,state,mobile,zip);
        addressBook.add(p);
    }
}
