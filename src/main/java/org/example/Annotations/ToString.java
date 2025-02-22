package org.example.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для управления выводом полей в методе toString.
 * Может быть применена к классам и полям.
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ToString {
    /**
     * Указывает, должно ли поле быть включено в вывод.
     *
     * @return "YES", если поле должно быть включено, иначе "NO".
     */
    String value() default "YES";
}