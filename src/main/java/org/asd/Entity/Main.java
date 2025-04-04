package org.asd.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Vasya", "Almaty")
                .setFirstName("Vasya")
                .setPatronymic("Vasil'evich")
                .setPostalCode("12514");
        //etwas machen(registration), spater schreiben daten
        person
                //.setSettlement("Almaty");
                .setLastName("Vasilev");


        System.out.println("person = " + person);

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            personList.add(new Person("firstName" + UUID.randomUUID(),
                    "settlement" + UUID.randomUUID()));
            if (i % 3 == 0) {
                personList.add(new Person("Unknown", "settlement" + UUID.randomUUID()));
            }
        }

        //wernut Person with firstName = "Unknown" as new List//(O(n)
        List<Person> unknownList = new ArrayList<>();
        for (Person p : personList) {
            if (p.getFirstName().matches("Unknown.*")) { //.equals("Unknown")){
                unknownList.add(p);
            }
            //for (Person p : personList) {
            //Bolean b = getFirstName().equals("Unknown") & unknownList.add(p) : nul;
        }
        System.out.println(unknownList);

        List<Person> unknowns = personList.stream().filter(p -> p.getFirstName().matches("Unknown.*")).toList();//.equals("Unknown")

//wernut tolko Settlements6
        List<?> unknownList1 = personList
                .stream()
                .map(p -> p.getSettlement())
                .toList();
        System.out.println(unknownList);

        List<?> unknownsSettlements = personList
                .stream().filter(p -> p.getFirstName().matches("Unknown.*"))//.filter(n -> n.equals("Unknown"))
                .map(Person::getSettlement).toList();
        System.out.println("unknownsSettlements = " + unknownsSettlements);
        List<?> settlements = personList.stream().map(Person::getSettlement).toList();
        System.out.println("settlements = " + settlements);

        //Реализуйте класс Address, имеющий 3 поля (String street, int houseNumber, Person owner)
        //Создайте поток данных, принимающий List<Address>
        // и возвращающий номера домов на улице "Фруктовая"

//        List<Address> addresses = List.of(
//                new Address("Fruit Street", 12, new Person("John", "New York")),
//                new Address("Garden Avenue", 5, new Person("Emma", "Los Angeles")),
//                new Address("Fruit Street", 8, new Person("Liam", "Chicago")),
//                new Address("Central Avenue", 25, new Person("Sophia", "Houston")),
//                new Address("Forest Road", 14, new Person("James", "Phoenix")),
//                new Address("Fruit Street", 19, new Person("Olivia", "Philadelphia")),
//                new Address("Lake Street", 3, new Person("William", "San Antonio")),
//                new Address("Sunny Boulevard", 7, new Person("Charlotte", "San Diego")),
//                new Address("Fruit Street", 22, new Person("Benjamin", "Dallas")),
//                new Address("Park Lane", 10, new Person("Alexander", "San Jose"))
//        );

        List<Address> addresses = new ArrayList<>();
        Random random = new Random();
        for (Person p : personList){
            addresses.add((new Address("street" + UUID.randomUUID(),
                    random.nextInt(1, 100), p)));
        }
        List<?> numbers = addresses.stream()
                .sorted((a1, a2) -> a1.getHouseNumber() > a2.getHouseNumber() ? a1.getHouseNumber() : a2.getHouseNumber())
                .filter(a -> a.getStreet()
                        .equals("Fruit"))
                .map(a -> a.getHouseNumber())
                .toList();

        String streetRegex = "Fruit.*";
        List<?> houseNumbers = addresses.stream()
                //       .sorted(Comparator.comparingInt(Address::getHouseNumber))
                .sorted(((a1, a2) -> Math.max(a1.getHouseNumber(), a2.getHouseNumber())))
                .filter(a -> a.getStreet().matches(streetRegex))
                .peek(System.out::println)
                .map(Address::getHouseNumber)
                // .limit(3)
                // .skip(1)
                .toList();
        System.out.println("houseNumbers.stream().findFirst().orElseThrow() = " + houseNumbers.stream().findFirst().orElseThrow());
        System.out.println("houseNumbers = " + houseNumbers);

    }
}
