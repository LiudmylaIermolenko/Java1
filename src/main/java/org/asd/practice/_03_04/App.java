package org.asd.practice._03_04;

import java.util.List;
import java.util.Optional;

public class App {

    public static void main(String[] args) {

        Student student1 = new Student("Petr", 23);
        Student student2 = new Student("Jone", 25);
        Student student3 = new Student("Alice", 19);

        student1.add(new Book("1001 night", 50.5));
        student2.add(new Book("Bооk 3", 100.5));
        student3.add(new Book("Book 3", 65.0));

        List<Student> students = List.of(student1, student2, student3);
        System.out.println("giveBooks(students) = " + giveBooks(students));

        //List<Book> book = student1.getBooks("ffff");
        Optional<Book> book = student1.getBook("1001 night");
        Book book1 = book.orElseThrow(() -> new IllegalArgumentException("Not faund"));

    }

    public static List<String> giveBooks(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getBooks().stream())
                .map(book -> book.getName())
                .distinct()
                .toList();
    }


}
