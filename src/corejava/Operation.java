package corejava;
/*
@Author : Noufal MC
@Date   : 20/01/2022
 This Class Implements the Operations of the Address Book
* */
import java.util.*;
public class Operation
{
    //instance variable declaration
    public static ArrayList<Person> addressBook=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    String lastName,address,email,city,mobile,firstName,state;
    int zip;
    /*
    * Add contacts In address Book
    * This Function Called In runner class
    * */
    public  void addContacts()
    {
        sc.nextLine();
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
    /**
     * method to update contact in Address Book
     * user can input their name
     * user can select their contacts by using first name
     * show menu to choose which field needs to be change
     * it shows the updated value
     *
     */
    public void editContacts()
    {

        int status=contactIsPresent();
        if(status!=0)
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
                    addressBook.get(status).setFirstName(firstName);
                    break;

                case 2:
                    sc.nextLine();
                    System.out.println("Enter the lastName");
                    lastName=sc.nextLine();
                    System.out.println("UPADTED LAST NAME "+lastName);
                    addressBook.get(status).setLastName(lastName);
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Enter the Address");
                    address=sc.nextLine();
                    System.out.println("UPADTED Adress"+address);
                    addressBook.get(status).setAddress(address);
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Enter the City");
                    city=sc.nextLine();
                    addressBook.get(status).setCity(city);
                    System.out.println("UPADTED CITY "+city);
                    break;
                case 5:
                    sc.nextLine();
                    System.out.println("Enter the Email");
                    email=sc.nextLine();
                    addressBook.get(status).setEmail(email);
                    System.out.println("UPADTED EMAIL "+email);
                    break;
                case 6:
                    sc.nextLine();
                    System.out.println("Enter the Mobile");
                    mobile=sc.nextLine();
                    addressBook.get(status).setPhoneNumber(mobile);
                    System.out.println("UPADTED MOBILE "+mobile);
                    break;
                case 7:
                    sc.nextLine();
                    System.out.println("Enter the Pincode");
                    zip=sc.nextInt();
                    addressBook.get(status).setZip(zip);
                    System.out.println("UPADTED PINCODE "+zip);
            }
        }
        else
        {
            System.out.println("Contact Not Found");
        }
    }
    /**
     * method to show the contact is  present or not
     * if contact is present returns the index value
     */
    public int contactIsPresent()
    {
        String firstName;
        sc.nextLine();
        System.out.println("Enter The First Name");
        firstName=sc.nextLine();
        for(int i=0;i<addressBook.size();i++) {
            if (addressBook.get(i).getFirstName().equals(firstName)) {
                return i;
            }
        }
        return 0;


    }
    /**
     * method is used to remove contact from address book
     * user can searh their name by using firstname

    * */
    public void deleteContacts()
    {
        int status=contactIsPresent();
        if(status!=0)
        {
            addressBook.remove(status);
            System.out.println("Item Removed");
        }
        else
        {
            System.out.println("Item Not found");
        }
    }
    /**
     * method to print address book
     * loop through address if there is any contact
     * display contact
     */
        public void display()
        {
            for(int i=0;i<addressBook.size();i++)
            {

                System.out.println("First Name " + addressBook.get(i).getFirstName());
                System.out.println("Last Name " + addressBook.get(i).getLastName());
                System.out.println("Address " + addressBook.get(i).getAddress());
                System.out.println("City " + addressBook.get(i).getCity());
                System.out.println("Email " + addressBook.get(i).getEmail());
                System.out.println("Pincode " +addressBook.get(i).getZip());
            }
            if(addressBook.isEmpty())
            {
                System.out.println("The List Is Empty");
            }
        }

}
