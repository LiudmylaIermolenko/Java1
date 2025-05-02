package org.asd.Home_Work._30_04;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

// Своё исключение
class EvenNumberException extends Exception {
    public EvenNumberException(String message) {
        super(message);
    }
}

public class ExceptionTasks {
    public static void main(String[] args) {

        System.out.println("=== ЗАДАЧА 1: Чётное число ===");
        try {
            CheckNumber.checkOdd(10);// четное — выбросит исключение
        } catch (EvenNumberException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        try {
            CheckNumber.checkOdd(7);// нечетное — всё хорошо
        } catch (EvenNumberException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        System.out.println("\n=== ЗАДАЧА 2: Парсинг и деление ===");
        ParseDivide.parseAndDivide("abc");
        ParseDivide.parseAndDivide("0");
        ParseDivide.parseAndDivide("100");

        System.out.println("\n=== ЗАДАЧА 3: Перевброс исключения ===");
        try {
            ThrowExample.riskyMethod("abc");
        }catch (IllegalArgumentException e){
            e.printStackTrace();// тут будет видно оба исключения
        }

        System.out.println("\n=== ЗАДАЧА 4: Запись ошибки в файл ===");
        ExceptionToFile.writeExceptionToFile();

        System.out.println("\n=== ЗАДАЧА 5: Поймать Throwable ===");
        // Вызывай только один из них за раз — чтобы избежать падения среды!
        //CatchEverything.testOutOfMemory();
        CatchEverything.testStackOverflow(); // поочерёдно тестируй, не одновременно

        System.out.println("\n=== ЗАДАЧА 6: AutoCloseable с вероятным исключением ===");
        try (MyResource res = new MyResource("TestResource")) {
            System.out.println("Работа с ресурсом...");
        } catch (Exception e) {
            System.out.println("Поймано исключение при закрытии: " + e.getMessage());
        }
    }

    //1. Метод, который принимает int и выбрасывает исключение, если число чётное.
    public static class CheckNumber {
        public static void checkOdd(int number) throws EvenNumberException {
            if (number % 2 == 0) {
                throw new EvenNumberException("Number is even: " + number);
            }
            System.out.println("Number is odd: " + number);
        }
    }

    //2. Напишите метод, который парсит строку в число и делит 100 на это число.
    // Обработайте отдельно NumberFormatException и ArithmeticException

    public static class ParseDivide {
        public static void parseAndDivide(String s) {
            try {
                int number = Integer.parseInt(s);// Пытаемся преобразовать строку в число
                int result = 100 / number;
                System.out.println("result: " + result);
            } catch (NumberFormatException e) {//если строка — не число, Например: "abc"
                System.out.println("String is not number -> " + e.getMessage());
            } catch (ArithmeticException e) {//если число = 0
                System.out.println("divide for null -> " + e.getMessage());
            }
        }
    }

    //3. Создайте метод, который ловит одно исключение (например, NumberFormatException) и выбрасывает
    // новое (например, IllegalArgumentException), передавайте оригинальное как cause.
    // Проверьте, что в стектрейсе будут оба исключения.

    public static class ThrowExample {
        public static void riskyMethod(String str) {
            try {
                Integer.parseInt(str);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Falsch input", e);// передаём оригинальное как cause
            }
        }
    }

    //4. Перехватите любое исключение и
    // направьте его стектрейс в текстовый файл через PrintWriter.

    public static class ExceptionToFile {
        public static void writeExceptionToFile() {
            try {
                int a = 10 / 0; // вызовет ArithmeticException
            } catch (Exception e) {//ловим эту ошибку и сохраняем её в переменную e
                try (PrintWriter writer = new PrintWriter("error_log.txt")) {//специальный блок try-with-resources, он сам закроет файл, даже если произойдёт ошибка.
                    e.printStackTrace(writer);//печатаем информацию об ошибке e в файл (вместо того, чтобы выводить её на экран).
                    System.out.println("Стектрейс записан в файл error_log.txt");
                } catch (FileNotFoundException fileEx) {
                    System.out.println("Ошибка при записи в файл: " + fileEx.getMessage());//ловим ещё одну ошибку — связанную с файлами
                }
            }
        }
    }
    //5.Попробуйте написать метод, который перехватывает не только Exception, но и Error (например, OutOfMemoryError) с помощью catch (Throwable t). Чтобы вызвать OutOfMemory попробуйте создать очень большой массив.
    // Попробуйте также инициировать StackOverflowError и поймать его.
    //(Поймать Throwable, вызвать OutOfMemoryError и StackOverflowError:)

    public static class CatchEverything {
        public static void testOutOfMemory() {
            try {
                int[] bigArray = new int[Integer.MAX_VALUE];// OutOfMemory
            } catch (Throwable t) {
                System.out.println("Поймано: " + t.getClass().getSimpleName());
                t.printStackTrace();
            }
        }

        public static void testStackOverflow() {
            try {
                recurse(10000);// ограниченная глубина, но может вызвать переполнение
            } catch (Throwable t) {
                System.out.println("Поймано: " + t.getClass().getSimpleName());
                t.printStackTrace();
            }
        }

        public static void recurse(int count) {
            if (count == 0) return;
            recurse(count - 1);//вызывать: recurse(10000); — вместо бесконечного recurse();.
        }
    }

    //6.Создайте класс своего ресурса который реализует AutoCloseable,
    // который в close() выбрасывает исключение с вероятностью 50%.
    //Попробуй поработать с ним в блоке try-with-resources и корректно обработать ситуацию.
//AutoCloseable ресурс, который выбрасывает исключение с вероятностью 50%

    public static class MyResource implements AutoCloseable {
        private final String name;

        public MyResource(String name) {
            this.name = name;
            System.out.println("Открыт ресурс: " + name);
        }

        @Override
        public void close() throws Exception {
            System.out.println("Закрытие ресурса: " + name);
            if (Math.random() < 0.5) {
                throw new Exception("Ошибка при закрытии ресурса: " + name);
            } else {
                System.out.println("Ресурс закрыт без ошибок: " + name);
            }
        }
    }
}



