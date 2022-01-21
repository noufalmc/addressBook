package corejava;
/*
@Author : Noufal MC
@Date   : 20/01/2022
 This Class Implements the Operations of the Address Book
* */
import java.util.*;
public class Operation
{
    //instance variable declaration Hash map
    public static HashMap<String,Person> addressBook=new HashMap();
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
                firstName = sc.nextLine();
            if(checkPresntOrNot(firstName)) {
                System.out.println("Enter the LastName");
                lastName = sc.nextLine();
                System.out.println("Enter the Address");
                address = sc.nextLine();
                System.out.println("Enter the City");
                city = sc.nextLine();
                System.out.println("Enter the State");
                state = sc.nextLine();
                System.out.println("Enter the Email");
                email = sc.nextLine();
                System.out.println("Enter the Mobile");
                mobile = sc.nextLine();
                System.out.println("Enter the Pincode");
                zip = sc.nextInt();
                Person p = new Person(firstName, lastName, address, email, city, state, mobile, zip);
                addressBook.put(firstName, p);
            }
            else
            {
                System.out.println("Contact is Already exist!!!");
            }
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

        sc.nextLine();
        System.out.println("Enter the first name");
        String name=sc.nextLine();
        if(!checkPresntOrNot(name))
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
                    addressBook.get(name).setFirstName(firstName);
                    break;

                case 2:
                    sc.nextLine();
                    System.out.println("Enter the lastName");
                    lastName=sc.nextLine();
                    System.out.println("UPADTED LAST NAME "+lastName);
                    addressBook.get(name).setLastName(lastName);
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Enter the Address");
                    address=sc.nextLine();
                    System.out.println("UPADTED Adress"+address);
                    addressBook.get(name).setAddress(address);
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Enter the City");
                    city=sc.nextLine();
                    addressBook.get(name).setCity(city);
                    System.out.println("UPADTED CITY "+city);
                    break;
                case 5:
                    sc.nextLine();
                    System.out.println("Enter the Email");
                    email=sc.nextLine();
                    addressBook.get(name).setEmail(email);
                    System.out.println("UPADTED EMAIL "+email);
                    break;
                case 6:
                    sc.nextLine();
                    System.out.println("Enter the Mobile");
                    mobile=sc.nextLine();
                    addressBook.get(name).setPhoneNumber(mobile);
                    System.out.println("UPADTED MOBILE "+mobile);
                    break;
                case 7:
                    sc.nextLine();
                    System.out.println("Enter the Pincode");
                    zip=sc.nextInt();
                    addressBook.get(name).setZip(zip);
                    System.out.println("UPADTED PINCODE "+zip);
            }
        }
        else
        {
            System.out.println("Contact Not Found");
        }
    }


    /**
     * method is used to remove contact from address book
     * user can searh their name by using firstname

    * */
    public void deleteContacts()
    {
        sc.nextLine();
        System.out.println("Enter the first name");
        String name=sc.nextLine();
        if(!checkPresntOrNot(name))
        {
            addressBook.remove(name);
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
            if(addressBook.size()>0) {
                for (Person key : addressBook.values()) {
                    System.out.println("Fisrt Name=" + key.getFirstName() + "\n");
                    System.out.println("last Name=" + key.getLastName() + "\n");
                    System.out.println("Address=" + key.getAddress() + "\n");
                    System.out.println("City=" + key.getCity() + "\n");
                    System.out.println("State=" + key.getState() + "\n");
                    System.out.println("Mobile=" + key.getPhoneNumber() + "\n");
                    System.out.println("email=" + key.getEmail() + "\n");
                    System.out.println("Zip=" + key.getZip() + "\n");
                }
            }
            else
            {
                System.out.println("No data Found");
            }

        }
    /**
     * method check the given contact exist or not
     * if present it will return true
     * otherwise return false
     * */
    public  boolean checkPresntOrNot(String firstName)
    {
        if(addressBook.containsKey(firstName))
        {
            return  false;
        }
        else
        {
            return true;
        }
    }
}
