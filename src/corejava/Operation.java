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
        Person p=new Person(firstName,lastName,address,email,city,state,mobile,zip);
        addressBook.add(p);
    }
    public void editContacts()
    {

        if(contactIsPresent())
        {
            System.out.println("Which fields want to be edit");
            System.out.println("[1] First Name");
            System.out.println("[2] Last Name");
            System.out.println("[3] Address");
            System.out.println("[4] City");
            System.out.println("[5] Email");
            System.out.println("[6] Mobile");
            System.out.println("[7] Pincode");
            int editField=sc.nextInt();
            switch (editField)
            {
                case 1:
                    sc.nextLine();
                    System.out.println("Enter the FirstName");
                    firstName=sc.nextLine();
                    System.out.println("UPADTED FIRST NAME"+firstName);
                    addressBook.get(0).setFirstName(firstName);
                    break;

                case 2:
                    sc.nextLine();
                    System.out.println("Enter the lastName");
                    lastName=sc.nextLine();
                    System.out.println("UPADTED LAST NAME "+lastName);
                    addressBook.get(0).setLastName(lastName);
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Enter the Address");
                    address=sc.nextLine();
                    System.out.println("UPADTED Adress"+address);
                    addressBook.get(0).setAddress(address);
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Enter the City");
                    city=sc.nextLine();
                    addressBook.get(0).setCity(city);
                    System.out.println("UPADTED CITY "+city);
                    break;
                case 5:
                    sc.nextLine();
                    System.out.println("Enter the Email");
                    email=sc.nextLine();
                    addressBook.get(0).setEmail(email);
                    System.out.println("UPADTED EMAIL "+email);
                    break;
                case 6:
                    sc.nextLine();
                    System.out.println("Enter the Mobile");
                    mobile=sc.nextLine();
                    addressBook.get(0).setPhoneNumber(mobile);
                    System.out.println("UPADTED MOBILE "+mobile);
                    break;
                case 7:
                    sc.nextLine();
                    System.out.println("Enter the Pincode");
                    zip=sc.nextInt();
                    addressBook.get(0).setZip(zip);
                    System.out.println("UPADTED PINCODE "+zip);
            }
        }
        else
        {
            System.out.println("Contact Not Found");
        }
    }
    public boolean contactIsPresent()
    {
        String firstName;
        sc.nextLine();
        System.out.println("Enter The First Name");
        firstName=sc.nextLine();
        System.out.println("First name is "+addressBook.get(0).getFirstName());
        if(addressBook.get(0).getFirstName().equals(firstName))
        {
            return true;
        }

            return false;

    }
}
