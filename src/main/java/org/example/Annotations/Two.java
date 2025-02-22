package org.example.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для указания двух значений.
 * Может быть применена только к классам.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Two {
    /**
     * Первое значение.
     *
     * @return Первое значение.
     */
    String first();

    /**
     * Второе значение.
     *
     * @return Второе значение.
     */
    int second();
}