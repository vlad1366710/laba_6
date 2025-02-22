package org.example.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для указания кэшируемых данных.
 * Может быть применена только к классам.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    /**
     * Массив имен кэшей.
     *
     * @return Массив имен кэшей.
     */
    String[] value() default {};
}