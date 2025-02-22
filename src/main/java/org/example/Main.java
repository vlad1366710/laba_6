package org.example;

import org.example.Annotations.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> handleLine();
                    case 2 -> handleInvoke();
                    case 3 -> handleDefault();
                    case 4 -> handleToString();
                    case 5 -> handleValidate();
                    case 6 -> handleTwo();
                    case 7 -> handleCache();
                    case 8 -> handleLine2();
                    case 0 -> {
                        System.out.println("Выход из программы.");
                        return;
                    }
                    default -> System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода. Пожалуйста, введите число от 0 до 8.");
                scanner.nextLine();
            }
            printEmptyLines();
        }
    }

    private static void printMenu() {
        System.out.println("Выберите задание:");
        System.out.println("1(1). К строке");
        System.out.println("2(2.1). @Invoke");
        System.out.println("3(2.2). @Default");
        System.out.println("4(2.3). @ToString");
        System.out.println("5(2.4). @Validate");
        System.out.println("6(2.5). @Two");
        System.out.println("7(2.6). @Cache");
        System.out.println("8(3.1). К строке2.");
        System.out.println("0. Выход");
        System.out.print("Ваш выбор: ");
    }

    private static void printEmptyLines() {
        System.out.println("\n\n\n");
    }

    private static void handleLine() {
        B b = new B();
        System.out.println(b);
    }

    private static void handleInvoke() {
        Example example = new Example();
        example.myAnnotatedMethod();

        Method[] methods = Example.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Invoke.class)) {
                System.out.println("Метод " + method.getName() + " аннотирован @Invoke.");
            }
        }
    }

    private static void handleDefault() {
        Class<MyClass> myClass = MyClass.class;
        if (myClass.isAnnotationPresent(Default.class)) {
            Default defaultAnnotation = myClass.getAnnotation(Default.class);
            System.out.println("Класс " + myClass.getName() + " аннотирован @Default с value: " + defaultAnnotation.value().getName());
        }

        Field[] fields = myClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Default.class)) {
                Default defaultAnnotation = field.getAnnotation(Default.class);
                System.out.println("Поле " + field.getName() + " аннотировано @Default с value: " + defaultAnnotation.value().getName());
            }
        }
    }

    private static void handleToString() {
        Class<Person> personClass = Person.class;
        if (personClass.isAnnotationPresent(ToString.class)) {
            ToString toStringAnnotation = personClass.getAnnotation(ToString.class);
            System.out.println("Класс " + personClass.getName() + " аннотирован @ToString с value: " + toStringAnnotation.value());
        }

        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ToString.class)) {
                ToString toStringAnnotation = field.getAnnotation(ToString.class);
                System.out.println("Поле " + field.getName() + " аннотировано @ToString с value: " + toStringAnnotation.value());
            }
        }
    }

    private static void handleValidate() {
        Class<User> userClass = User.class;
        if (userClass.isAnnotationPresent(Validate.class)) {
            Validate validateAnnotation = userClass.getAnnotation(Validate.class);
            System.out.println("Класс " + userClass.getName() + " аннотирован @Validate с value: ");
            for (Class<?> clazz : validateAnnotation.value()) {
                System.out.println(" - " + clazz.getName());
            }
        }
    }

    private static void handleTwo() {
        Class<ExampleClass> exampleClass = ExampleClass.class;
        if (exampleClass.isAnnotationPresent(Two.class)) {
            Two twoAnnotation = exampleClass.getAnnotation(Two.class);
            System.out.println("Класс " + exampleClass.getName() + " аннотирован @Two с first: " +
                    twoAnnotation.first() + ", second: " + twoAnnotation.second());
        }
    }

    private static void handleCache() {
        Class<CachedData> cachedDataClass = CachedData.class;
        if (cachedDataClass.isAnnotationPresent(Cache.class)) {
            Cache cacheAnnotation = cachedDataClass.getAnnotation(Cache.class);
            System.out.println("Класс " + cachedDataClass.getName() + " аннотирован @Cache с value: ");
            for (String value : cacheAnnotation.value()) {
                System.out.println(" - " + value);
            }
        }
    }

    private static void handleLine2() {
        A a = new A();
        System.out.println(a);
    }
}