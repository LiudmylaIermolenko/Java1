package org.asd.Entity;

public class Address {
    private String street;
    private int houseNumber;
    private Person owner;

    public Address(String street, int houseNumber, Person owner) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.owner = owner;
    }

    public Address() {
    }

    public Person getOwner() {
        return owner;
    }

    public Address setOwner(Person owner) {
        this.owner = owner;
        return this;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public Address setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    @Override
    public String toString() {
        return String.format("Street: %s, House %d, Owner: %s (%s)",
                street, houseNumber, owner.getFirstName(), owner.getSettlement());
    }
}
