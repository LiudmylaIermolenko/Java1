package org.asd.Lesson_03_04_2025;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class MainMeasurements {
    public static void main(String[] args) {
       // задание 1:
        // У Вас есть список List> measurements, где каждый список - это измерения температуры за день.
        //В день не более 10 измерений и температура
        //колеблется от -30 до +30. Найдите 3 самых низких измерения и 3 самых высоких за все дни
        List<List<Integer>> measurements = List.of(
                List.of(-5, 10, 15, -10, 20),
                List.of(25, -30, 5, 0, 12),
                List.of(-15, -20, 30, 28, -25)
        );
        System.out.println("getMinTemp(measurements) = " + getMinTemp(measurements));
        System.out.println("getMaxTemp(measurements) = " + getMaxTemp(measurements));

        //Задание 2:
        //Список заменить на List>>, где Map<Номер дня, List<Значения температуры>>.
        // Вернуть первые 3 дня, где средняя температура превышает 0 градусов
        List<Map<Integer, List<Integer>>> measurements1 = List.of(
                Map.of(1, List.of(-5, 10, 15, -10, 20)),
                Map.of(2, List.of(25, -30, 5, 0, 12)),
                Map.of(3, List.of(-15, -20, 30, 28, -25)),
                Map.of(4, List.of(5, 10, 15, 20, 25)),
                Map.of(5, List.of(-10, -5, 0, 5, 10))
        );

        List<Integer> result = getFirst3Days(measurements1);
        System.out.println(result);

    }

    public static List<Integer> getMinTemp(List<List<Integer>> measurements){
        return measurements.stream()
                .flatMap(List::stream)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .toList();
    }
    public static List<Integer> getMaxTemp(List<List<Integer>> measurements){
        return measurements.stream().flatMap(List::stream)
                .sorted()
                .limit(3)
                .toList();
    }
    private static List<Integer> getFirst3Days(List<Map<Integer, List<Integer>>> measurements1) {
        return measurements1.stream()
                .flatMap(map -> map.entrySet().stream())
                .filter(entry -> entry.getValue().stream().mapToInt(Integer::intValue).average().orElse(0) > 0)
                .map(Map.Entry::getKey)
                .limit(3)
                .toList();
    }

}

//Список заменить на List<Map<Integer, List<Integer>>>,
// где Map<Номер дня, List<Значения температуры>>. Вернуть первые 3 дня,
// где средняя температура превышает 0 градусов

//flatMap(map -> map.entrySet().stream()) —
// превращает List<Map<Integer, List<Integer>>> в поток Map.Entry<Integer,
// List<Integer>>.
//
//filter(entry -> entry.getValue().stream().mapToInt(Integer::intValue).average().orElse(0) > 0)
//Превращает список температур в поток чисел.
//Вычисляет среднее значение.
//Фильтрует дни, где средняя температура выше 0.
//
//map(Map.Entry::getKey) — извлекает номер дня.
//
//limit(3) — берет только первые 3 подходящих дня.
//
//toList() — собирает результат в список.

//задание 1:
//  У Вас есть список List> measurements, где каждый список - это измерения температуры за день.
//  В день не более 10 измерений и температура колеблется от -30 до +30. Найдите 3 самых низких измерения
//  и 3 самых высоких за все дни
//Задание 2:
//Список заменить на List>>, где Map<Номер дня, List<Значения температуры>>. Вернуть первые 3 дня, где средняя
// температура превышает 0 градусов