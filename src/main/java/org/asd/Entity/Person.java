package org.asd.Entity;

public class Person {
    private String firstName;
    private String lastName;
    private String patronymic;
    private int postalCode;
    private String settlement;

    public Person(String firstName, String lastName, String patronymic, int postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.postalCode = postalCode;
    }

    public Person(String firstName, String settlement) {
        this.firstName = firstName;
        this.settlement = settlement;
    }

//    public Person() {
//
//    }

    public String getFirstName() {
        return firstName;
    }

    public String getSettlement() {
        return settlement;
    }

    public Person setSettlement(String settlement) {
        this.settlement = settlement;
        return this;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Person setPatronymic(String patronymic) {
        this.patronymic = patronymic;
        return this;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public Person setPostalCode(String postalCode) {
        this.postalCode = Integer.parseInt(postalCode);
        return this;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + patronymic +
                " Address: " + postalCode +
                " " + settlement;
    }
}
