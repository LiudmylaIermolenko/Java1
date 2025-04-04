package org.asd.Home_Work;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task_01 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("List: " + numbers);
//Фильтрация списка чисел
//1. Используя Stream API, оставьте только четные числа и выведите их на экран.
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        //Преобразование списка строк
//Дан список строк: ["apple", "banana", "cherry", "date"].
//Преобразуйте все строки в верхний регистр и выведите результат.
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        words.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        //Подсчет количества элементов
//Дан список чисел: [3, 5, 7, 9, 11, 15, 18, 21].
//Подсчитайте, сколько в списке чисел больше 10, используя Stream API.
        List<Integer> numbers1 = Arrays.asList(3, 5, 7, 9, 11, 15, 18, 21);
        long count = numbers1.stream()
                .filter(n -> n > 10)
                .count();
        System.out.println(count);

        //Объединение строк в одну
//Дан список строк: ["Java", "Stream", "API", "Example"].
//Объедините все строки в одну, используя запятую в качестве разделителя (Java, Stream, API, Example).
        List<String> words1 = Arrays.asList("Java", "Stream", "API", "Example");
        String result = words1.stream()
                .collect(Collectors.joining(", "));
        System.out.println(result);

        //Поиск максимального значения
//Дан список чисел: [23, 45, 12, 67, 34, 89, 90, 56].
//Найдите максимальное значение с помощью Stream API.
        List<Integer> numbers2 = Arrays.asList(23, 45, 12, 67, 34, 89, 90, 56);
        int max = numbers2.stream()
                .max(Integer::compareTo)
                .orElseThrow();
        System.out.println(max);

        //Группировка по длине строк
//Дан список строк: ["one", "three", "five", "seven", "eight", "ten"].
//Сгруппируйте строки по их длине и выведите результат в виде Map>.
        List<String> words3 = Arrays.asList("one", "three", "five", "seven", "eight", "ten");
        Map<Integer, List<String>> grouped = words3.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(grouped);

        //Поиск второго по величине числа
//Дан список чисел: [10, 5, 8, 20, 15, 25, 30].
//Найдите второе по величине число, используя Stream API.
        List<Integer> numbers3 = Arrays.asList(10, 5, 8, 20, 15, 25, 30);
        int secondMax = numbers3.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                .findFirst()
                .orElseThrow();
        System.out.println(secondMax);

        //Частотный анализ символов в строке
//Дана строка "stream api in java".
//Подсчитайте, сколько раз встречается каждый символ (игнорируя пробелы), и выведите результат в виде Map.
        String text1 = "stream api in java";
        Map<Character, Long> frequency = text1.replace(" ", "").chars()//строка станет: "streamapiinjava"
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(frequency);

        //Даны два списка:
//List list1 = Arrays.asList("a", "b", "c");
//List list2 = Arrays.asList("d", "e", "f");
//Объедините их в один список с помощью Stream API.
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<String> list2 = Arrays.asList("d", "e", "f");

        List<String> mergedList = Stream.concat(list1.stream(), list2.stream())
                .collect(Collectors.toList());
        System.out.println(mergedList);

        //Поиск самого длинного слова
//Дан список строк: ["elephant", "cat", "butterfly", "dog", "dolphin"].
//Найдите самое длинное слово, используя Stream API.
        List<String> words4 = Arrays.asList("elephant", "cat", "butterfly", "dog", "dolphin");
        String longestWord = words4.stream()
                .max(Comparator.comparingInt(String::length))
                .orElseThrow();
        System.out.println(longestWord);

    }
}

//Дз (обязательные задания):
//Фильтрация списка чисел
//Дан список целых чисел: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10].
//Используя Stream API, оставьте только четные числа и выведите их на экран.
//
//
//
//Преобразование списка строк
//Дан список строк: ["apple", "banana", "cherry", "date"].
//Преобразуйте все строки в верхний регистр и выведите результат.
//
//
//
//Подсчет количества элементов
//Дан список чисел: [3, 5, 7, 9, 11, 15, 18, 21].
//Подсчитайте, сколько в списке чисел больше 10, используя Stream API.
//
//
//
//Объединение строк в одну
//Дан список строк: ["Java", "Stream", "API", "Example"].
//Объедините все строки в одну, используя запятую в качестве разделителя (Java, Stream, API, Example).
//
//
//
//Поиск максимального значения
//Дан список чисел: [23, 45, 12, 67, 34, 89, 90, 56].
//Найдите максимальное значение с помощью Stream API.
//
//
//Дз (дополнительные задания):

//Группировка по длине строк
//Дан список строк: ["one", "three", "five", "seven", "eight", "ten"].
//Сгруппируйте строки по их длине и выведите результат в виде Map>.
//
//
//
//Поиск второго по величине числа
//Дан список чисел: [10, 5, 8, 20, 15, 25, 30].
//Найдите второе по величине число, используя Stream API.
//
//
//
//Частотный анализ символов в строке
//Дана строка "stream api in java".
//Подсчитайте, сколько раз встречается каждый символ (игнорируя пробелы), и выведите результат в виде Map.
//
//
//
//Даны два списка:
//List list1 = Arrays.asList("a", "b", "c");
//List list2 = Arrays.asList("d", "e", "f");
//Объедините их в один список с помощью Stream API.
//
//
//
//Поиск самого длинного слова
//Дан список строк: ["elephant", "cat", "butterfly", "dog", "dolphin"].
//Найдите самое длинное слово, используя Stream API.
