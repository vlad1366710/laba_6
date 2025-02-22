package org.example;

import org.example.Annotations.Validate;

/**
 * Пример класса с аннотацией @Validate.
 */
@Validate(value = {String.class, Integer.class})
public class User {
    private String username;
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}