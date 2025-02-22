package org.example.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для указания значения по умолчанию.
 * Может быть применена к классам и полям.
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Default {
    /**
     * Класс, представляющий значение по умолчанию.
     *
     * @return Класс значения по умолчанию.
     */
    Class<?> value();
}