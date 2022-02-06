package corejava;
/*
@ Author : Noufal MC
@ Date   : 20/01/2022
  This class provide structure of the contact book
* */
public class Person {
    /*
    * Declaring Variable Required for Address Book
    * Used getter and setter
    * */
    private  String firstName,lastName,address,city,state,email;
    private  int zip;
    long phoneNumber;
    Person(String firstName,String lastName,String address,String email,String city,String state,long phoneNumber,int zip)
    {
       this.firstName=firstName;
       this.lastName=lastName;
       this.address=address;
       this.city=city;
       this.state=state;
       this.phoneNumber=phoneNumber;
       this.zip=zip;
       this.email=email;

    }
    public void setFirstName(String firstName)
    {
        this.firstName=firstName;
    }
    public String getFirstName()
    {
        return this.firstName;
    }
    public void setLastName(String lastName)
    {
        this.lastName=lastName;
    }
    public String getLastName()
    {
        return this.lastName;
    }
    public void setCity(String city)
    {
        this.city=city;
    }
    public String getCity()
    {
        return this.city;
    }
    public void setZip(int zip)
    {
        this.zip=zip;
    }
    public int getZip()
    {
        return this.zip;
    }
    public void setAddress(String address)
    {
        this.address=address;
    }
    public String getAddress()
    {
        return this.address;
    }
    public void setState(String state)
    {
        this.state=state;
    }
    public String getState()
    {
        return this.state;
    }
    public void  setPhoneNumber(long phoneNumber)
    {
        this.phoneNumber=phoneNumber;
    }
    public long getPhoneNumber()
    {
        return this.phoneNumber;
    }
    public  void setEmail(String email)
    {
        this.email=email;
    }
    public String getEmail()
    {
        return this.email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", email='" + email + '\'' +
                ", zip=" + zip +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
