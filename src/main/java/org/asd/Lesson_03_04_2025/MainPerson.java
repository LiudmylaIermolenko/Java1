package org.asd.Lesson_03_04_2025;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class MainPerson {
    public static void main(String[] args) {
        Random random = new Random();
        List<List<Person>> enterprise = List.of(
                List.of(new Person(UUID.randomUUID().toString(), random.nextInt(1, 2000)), new Person(UUID.randomUUID().toString(), random.nextInt(1, 2000)), new Person(UUID.randomUUID().toString(), random.nextInt(1, 2000))),
                List.of(new Person(UUID.randomUUID().toString(), random.nextInt(1, 2000)), new Person(UUID.randomUUID().toString(), random.nextInt(1, 2000)), new Person(UUID.randomUUID().toString(), random.nextInt(1, 2000))),
                List.of(new Person(UUID.randomUUID().toString(), random.nextInt(1, 2000)), new Person(UUID.randomUUID().toString(), random.nextInt(1, 2000)), new Person(UUID.randomUUID().toString(), random.nextInt(1, 2000))),
                List.of(new Person(UUID.randomUUID().toString(), random.nextInt(1, 2000)), new Person(UUID.randomUUID().toString(), random.nextInt(1, 2000)), new Person(UUID.randomUUID().toString(), random.nextInt(1, 2000)))
        );
//Каждый вложенный список - отдельная компания в рамках холдинга.
// Верните имя сотрудника с самой высокой заплатой среди всех компаний
        String name = enterprise.stream()
                .flatMap(Collection::stream)
                .max((p1, p2) -> Math.max(p1.getSalary(), p2.getSalary()))
                .orElseThrow().getName();
    }
}
