package org.asd.Lesson_03_04_2025;

import org.asd.Entity.Person;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Дан список
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(1, 100));
            System.out.println("Список: " + list);
        }
//Задача 1: Верните самое большое число списка с помощью стрима
        //int maxNumber = list.stream().max(Integer::compareTo).orElse(0);
        int maxNumber = list.stream().max((a, b) -> a> b? a:b)
                .orElseThrow();
        System.out.println(maxNumber);

//Задача 2: Верните сумму самого большого и самого маленького числа списка
        int minNumber = list.stream().min(Integer::compareTo).orElse(0);
        int sumMaxMin = maxNumber + minNumber;
        System.out.println("sumMaxMin: " + sumMaxMin);

//Задача 3: Верните самое большое продублированное число. Если дубликатов нет, то верните 0
        int maxDuplicate = list.stream() //O(n*n)
                .filter(num -> Collections.frequency(list, num) > 1) // Оставляем только дубликаты
                .max(Integer::compareTo)
                .orElse(0);
        //return list.stream()
        //            .collect(Collectors.groupingBy(n -> n, Collectors.counting())) // Группируем числа и считаем количество
        //            .entrySet().stream()
        //            .filter(e -> e.getValue() > 1) // Оставляем только те, что встречаются больше одного раза
        //            .map(Map.Entry::getKey) // Берем сами числа
        //            .max(Integer::compareTo) // Ищем максимальное
        //            .orElse(0); // Если дубликатов нет, возвращаем 0

        //Set<Integer> set = new HashSet<>();  O(n)
        //int res3 = list.stream()
        //        .filter(n-> !set.add(n))
        //        .max(Integer::compareTo)
        //        .orElse(0);

        System.out.println("maxDuplicate: " + maxDuplicate);

        Optional<String> optional = Optional.empty();
        String s = null;
        if(s == null){

        }
        //Выбросить исключение
        optional.orElseThrow();
//Задать значение по-умолчанию
        optional.orElse("Lala");
//Проверить, есть ли внутри значение
        optional.isPresent();
//Проверить, нет ли внутри значения
        optional.isEmpty();
//Сделать что-то, если есть значение
        optional.ifPresent(System.out::println);
//Преобразовать
        optional.map(Double::parseDouble).orElse(2.0);
//Отфильтровать
        optional.filter(n-> n.contains(".")).orElse("");


    }
}
