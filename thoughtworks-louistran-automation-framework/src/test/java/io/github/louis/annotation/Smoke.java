package io.github.louis.annotation;

import org.junit.jupiter.api.Tag;

import java.lang.annotation.*;

/**
 * @author louis
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Regression
@Tag("smoke")
public @interface Smoke {}
