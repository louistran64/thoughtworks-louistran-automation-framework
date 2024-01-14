package io.github.louis.annotation;

import io.github.louis.dto.BaseDto;
import io.github.louis.util.DataArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.*;


@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ArgumentsSource(DataArgumentsProvider.class)
public @interface DataSource {

    String id();

    String fileName();

    Class<? extends BaseDto> clazz();
}
