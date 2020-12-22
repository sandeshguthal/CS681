package edu.umb.cs681.hw12;

public final class Address {
    private final String city;
    private final String state;
    private final String street;
    private final int zipCode;
    public String toString(String city, String state, String street, int zipCode) {
        return city + " " + state + " " + street + " " + zipCode;
    }

    public Address(String city, String state, String street, int zipCode) {
        this.city = city;
        this.state = state;
        this.street = street;
        this.zipCode = zipCode;
    }


    public Address changeAddress(String city, String state, String street, int zipCode) {
        return new Address(city, state, street, zipCode);
    }

    
}
