package corejava;
/**
 * @uthor : Noufal
 * Date   :21/01/2022
 * Create Multiple Addressbook for store contacts
 *
**/
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;
import java.io.IOException;
import static java.util.stream.Collectors.groupingBy;

public class AddressBook {
    private String bookName;//Decleration for bookname
    private ArrayList<Person> addressBook;//Decleration of Contactlist
    public static String txtFile="C:\\Users\\DELL\\IdeaProjects\\AddressBook\\files\\addressBook.txt";
    public static String csvFile="C:\\Users\\DELL\\IdeaProjects\\AddressBook\\files\\addressBook.csv";
    public static String jsonFile="C:\\Users\\DELL\\IdeaProjects\\AddressBook\\files\\addressBook.json";
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
    public void operations(AddressBook book) throws IOException,ParseException {
        while (true) {
            System.out.println("Enter Your Choice\n" +
                    "[1] Add Contact\n" +
                    "[2] Display contact\n" +
                    "[3] Edit Contact\n" +
                    "[4] Delete Contact\n" +
                    "[5] Back To Main Menu\n"+
                    "[6] Sort By Contact");
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
                case 6:
                    System.out.println("Enter Option wants to Sort\n" +
                            "[1] Name" +
                            "[2] State" +
                            "[3] City" +
                            "[4] Pincode");
                    int sortOption=sc.nextInt();

                    sortBy(sortOption);
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }

    private void sortBy(int option) {
        List<Person> sortByName=new ArrayList<>();
        switch (option)
        {
            case 1:
                sortByName=addressBook.stream().sorted(Comparator.comparing(Person::getFirstName))
                        .collect(Collectors.toList());
                System.out.println("Sorted Array is");
                sortByName.forEach(i->System.out.println(i.getFirstName()));
                break;
            case 2:
                sortByName=addressBook.stream().sorted(Comparator.comparing(Person::getState))
                        .collect(Collectors.toList());
                System.out.println("Sorted Array is");
                sortByName.forEach(i->System.out.println(i.getFirstName()+"="+i.getState()));
                break;
            case 3:
                sortByName=addressBook.stream().sorted(Comparator.comparing(Person::getCity))
                        .collect(Collectors.toList());
                System.out.println("Sorted Array is");
                sortByName.forEach(i->System.out.println(i.getFirstName()+"="+i.getCity()));
                break;
            case 4:
                sortByName=addressBook.stream().sorted(Comparator.comparing(Person::getZip))
                        .collect(Collectors.toList());

                System.out.println("Sorted Array is");
                sortByName.forEach(i->System.out.println(i.getFirstName()+'='+i.getZip()));
                break;

        }


    }

    /**
     * method used add contact into address book
     * take input from user
     * save into contact book
     */
    public void addcontact() throws IOException {
    //variable declaration
    String firstName, lastName, address, city, state, email;
    int zip;
    long phoneNumber;
    //input
        System.out.println("Enter First Name");
        firstName =sc.next();
        System.out.println("Enter Last Name");
        lastName =sc.next();
        if(existOrNot(firstName + lastName))
        {
            System.out.println("The Contact already Exist!!!!!");
            return;
        }
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
        fileWriter();
        String csv=firstName+"-"+lastName+"-"+city+"-"+state+"-"+zip+"-"+email;
        writeCsv(csv);
        writeJson(csv);
        System.out.println("Added Contact Successfully");// contact added
}
    /**
     * This method display Contact arrayList
     */
    public  void displayContact() throws IOException, ParseException {
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
        System.out.println("Read from File");
        BufferedReader br = new BufferedReader(new FileReader(txtFile));

        try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            br.close();
        }
        System.out.println("Read From Csv");
        try {
            // Create an object of filereader
            // class with CSV file as a parameter.
            FileReader fileReader=new FileReader(csvFile);
            //Create CSV Reader
            CSVReader csvReader=new CSVReader(fileReader);
            String line;
            BufferedReader br1 = new BufferedReader(new FileReader(csvFile));
            while ((line = br1.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(",");    // use comma as separator
                System.out.println("Employee [First Name=" + employee[0] + ", Last Name=" + employee[1] + ", Designation=" + employee[2] + ", Contact=" + employee[3] + ", Salary= " + employee[4] + ", City= " + employee[5] +"]");
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("Read From JSON");
        try {
            JSONParser jp = new JSONParser();
            Object obj = jp.parse(new FileReader(jsonFile));
            JSONObject jsonObj = (JSONObject) obj;
            System.out.println("First Name= " + (String) jsonObj.get("First_Name"));
            System.out.println("Last Name = " + (String) jsonObj.get("Last_Name"));
            System.out.println("City = " + (String) jsonObj.get("City"));
            System.out.println("State= " + (String) jsonObj.get("State"));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Write into Json
     *  @param data
     *  @throws IOException
     */
    public void writeJson(String data) throws IOException {
        FileWriter fw=new FileWriter(jsonFile);
        String[] array=data.split("-");
        //Creating a JSONObject object
        JSONObject jsonObject = new JSONObject();
        //Inserting key-value pairs into the json object
        jsonObject.put("First_Name",array[0]);
        jsonObject.put("Last_Name", array[1]);
        jsonObject.put("State",array[3]);
        jsonObject.put("City",array[2]);
        jsonObject.put("Zip",array[4]);
        jsonObject.put("Email",array[5]);
        try {
            fw.write(jsonObject.toJSONString());
            fw.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    /**
     * The  write into csv file
     * appendable
     * @param string
     * @throws IOException
     */
    public void  writeCsv(String string) throws IOException
    {
        CSVWriter writer = new CSVWriter(new FileWriter(csvFile, true));
        String[] data=string.split("-");
        writer.writeNext(data);
        writer.close();
    }
    /**
     * method to update contact in Address Book
     * user can input their name
     * user can select their contacts by using first name
     * show menu to choose which field needs to be change
     * it shows the updated value
     *
     */
    public void editContact() throws IOException {
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
            fileWriter();
        }
        else
        {
            System.out.println("Contact Not Found");
        }
    }
    public void fileWriter() throws IOException {
        StringBuffer addressBookTxtFile = new StringBuffer();
        FileWriter fw=new FileWriter(txtFile);
        BufferedWriter bw=new BufferedWriter(fw);
        addressBook.forEach(i-> {
            String txt = i.toString();
            addressBookTxtFile.append(txt);
        });
        try {
            Files.write(Path.of(txtFile),addressBookTxtFile.toString().getBytes()); //Read File
        } catch (Exception e) {
            System.out.println(e);
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
    public boolean existOrNot(String name)
    {
        Person stream=addressBook.stream().filter(
                contact -> name.equals(contact.getFirstName()+contact.getLastName())).findAny().orElse(null);
        if(stream==null)
        {
            return false;
        }
        return true;
    }

    /**
     * Method is used for Search The Contact by city
     * @param city
     * Take Inputs From User
     * Print the result list
     */
    public void searchByCity(String city)
    {
        List<Person> streamList=addressBook.stream().filter(contact ->city.equals(contact.getCity())).collect(Collectors.toList());
        streamList.forEach(i->System.out.println(i.getFirstName()+' '+i.getLastName()));
    }

    /**
     * Method display the macthich state persons
     * take input from user state name
     * if matches then creates a list
     * then print list
     * @param state
     */
    public void searchByState(String state)
    {
        List<Person> streamList=addressBook.stream().filter(contact -> state.equals(contact.getState())).collect(Collectors.toList());
        streamList.forEach(i->System.out.println(i.getFirstName()+' '+i.getLastName()));
    }

    /**
     * Group the city
     * By using groupingby method
     * @return
     */
    public Map<String,List<Person>> getMapCity()
    {
      return addressBook.stream().collect(groupingBy(contact -> contact.getCity()));

    }

    /**
     * Grouping the states
     * by using groupingby method
     * @return
     */
    public Map<String,List<Person>> getMapState()
    {
        return addressBook.stream().collect(groupingBy(contact -> contact.getState()));
    }


}
