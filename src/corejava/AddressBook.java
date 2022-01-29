package corejava;
/**
 * @uthor : Noufal
 * Date   :21/01/2022
 * Create Multiple Addressbook for store contacts
 *
**/
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
public class AddressBook {
    private String bookName;//Decleration for bookname
    private ArrayList<Person> addressBook;//Decleration of Contactlist
    int options;
    Scanner sc = new Scanner(System.in);

    public AddressBook(String addressBookName) {
        this.addressBook = new ArrayList<>();
        this.bookName = addressBookName;
    }


    public String getBookName() {
        return this.bookName;
    }

    /**
     * Operation function provoide operation Menu
     * @param book
     */
    public void operations(AddressBook book) {
        while (true) {
            System.out.println("Enter Your Choice\n" +
                    "[1] Add Contact" +
                    "[2] Display contact" +
                    "[3] Edit Contact" +
                    "[4] Delete Contact" +
                    "[5] Back To Main Menu");
            options = sc.nextInt();
            switch (options) {
                case 1:
                    addcontact();
                    break;
                case 2:
                    displayContact();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContacts();
                    break;
                case 5:
                    System.out.println("Thank You For Using "+getBookName());
                    return;
                default:
                    System.exit(0);
                    break;
            }
        }
    }

    /**
     * method used add contact into address book
     * take input from user
     * save into contact book
     */
    public void addcontact()
{
    //variable declaration
    String firstName, lastName, address, city, state, email;
    int zip;
    long phoneNumber;
    //input
        System.out.println("Enter First Name");
    firstName =sc.next();
        System.out.println("Enter Last Name");
    lastName =sc.next();
        System.out.println("Enter Address");
    address =sc.next();
        System.out.println("Enter City");
    city =sc.next();
        System.out.println("Enter State");
    state =sc.next();
        System.out.println("Enter ZipCode");
    zip =sc.nextInt();
        System.out.println("Enter Email");
    email =sc.next();
        System.out.println("Enter Phone Number");
    phoneNumber =sc.nextLong();
    Person contact = new Person(firstName, lastName, address,email, city, state,phoneNumber,zip);
        System.out.println("Contact created!!!"); //contact created
        addressBook.add(contact);
        System.out.println("Added Contact Successfully");// contact added
}

    /**
     * This method display Contact arrayList
     */
    public  void displayContact()
    {
        for (int i=0;i<addressBook.size();i++)
        {
            System.out.println("FirstName = "+addressBook.get(i).getFirstName());
            System.out.println("LastName = "+addressBook.get(i).getLastName());
            System.out.println("Address = "+addressBook.get(i).getAddress());
            System.out.println("City = "+addressBook.get(i).getCity());
            System.out.println("State = "+addressBook.get(i).getState());
            System.out.println("Zipcode = "+addressBook.get(i).getZip());
            System.out.println("Email = "+addressBook.get(i).getEmail());
            System.out.println("Phone = "+addressBook.get(i).getPhoneNumber());
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
    public void editContact()
    {
        //variable declaration
        String firstName, lastName, address, city, state, email;
        int zip;
        long phoneNumber;
        sc.nextLine();
        System.out.println("Enter the first name");
        String name=sc.nextLine();
        int presentOrNot=checkPresntOrNot(name);
        if(presentOrNot>-1)
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
                    addressBook.get(presentOrNot).setFirstName(firstName);
                    break;

                case 2:
                    sc.nextLine();
                    System.out.println("Enter the lastName");
                    lastName=sc.nextLine();
                    System.out.println("UPADTED LAST NAME "+lastName);
                    addressBook.get(presentOrNot).setLastName(lastName);
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Enter the Address");
                    address=sc.nextLine();
                    System.out.println("UPADTED Adress"+address);
                    addressBook.get(presentOrNot).setAddress(address);
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Enter the City");
                    city=sc.nextLine();
                    addressBook.get(presentOrNot).setCity(city);
                    System.out.println("UPADTED CITY "+city);
                    break;
                case 5:
                    sc.nextLine();
                    System.out.println("Enter the Email");
                    email=sc.nextLine();
                    addressBook.get(presentOrNot).setEmail(email);
                    System.out.println("UPADTED EMAIL "+email);
                    break;
                case 6:
                    sc.nextLine();
                    System.out.println("Enter the Mobile");
                    phoneNumber=sc.nextLong();
                    addressBook.get(presentOrNot).setPhoneNumber(phoneNumber);
                    System.out.println("UPADTED MOBILE "+phoneNumber);
                    break;
                case 7:
                    sc.nextLine();
                    System.out.println("Enter the Pincode");
                    zip=sc.nextInt();
                    addressBook.get(presentOrNot).setZip(zip);
                    System.out.println("UPADTED PINCODE "+zip);
            }
        }
        else
        {
            System.out.println("Contact Not Found");
        }
    }
    /**
     * method check the given contact exist or not
     * if present it will return true
     * otherwise return false
     * */
    public  int checkPresntOrNot(String firstName)
    {
        int counter=0,i;
        for ( i=0;i<addressBook.size();i++)
        {
            if(Objects.equals(firstName,addressBook.get(i).getFirstName()))
            {
                counter=1;
                break;
            }
        }
        if(counter==1)
        {
            return i;
        }
        return -1;
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
        int presentOrNot=checkPresntOrNot(name);
        if(presentOrNot>-1)
        {
            addressBook.remove(presentOrNot);
            System.out.println("Item Removed");
        }
        else
        {
            System.out.println("Item Not found");
        }
    }
}
