package org.example;

import org.example.Annotations.Invoke;

/**
 * Пример класса с аннотированным методом.
 */
public class Example {

    @Invoke
    public void myAnnotatedMethod() {
        System.out.println("Этот метод аннотирован @Invoke.");
    }
}