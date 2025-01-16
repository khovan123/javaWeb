package model;

public class Employee {
    
    private Name name;
    private Address address;
    
    public Employee() {
    }
    
    public Employee(String firstName, String lastName, String city, String street, int ZIP) {
        this.name = new Name(firstName, lastName);
        this.address = new Address(city, street, ZIP);
    }
    
    public Name getName() {
        return name;
    }
    
    public void setName(Name name) {
        this.name = name;
    }
    
    public Address getAddress() {
        return address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    
}
