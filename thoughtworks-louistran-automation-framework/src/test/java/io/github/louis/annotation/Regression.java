package io.github.louis.annotation;

import org.junit.jupiter.api.Tag;

import java.lang.annotation.*;

/**
 * @author louis
 */
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Tag("regression")
public @interface Regression {}
