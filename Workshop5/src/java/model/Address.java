package model;

public class Address {

    private String street;
    private String city;
    private int ZIP;

    public Address() {
    }

    public Address(String city, String street, int ZIP) {
        this.city = city;
        this.street = street;
        this.ZIP = ZIP;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZIP() {
        return ZIP;
    }

    public void setZIP(int ZIP) {
        this.ZIP = ZIP;
    }

}
