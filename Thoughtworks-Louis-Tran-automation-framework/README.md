# Exercise for candidates applying for the Quality Assurance and Testing roles at ThoughtWorks

## Installation Steps

In order to use the framework:

1. Use IntelliJ IDEA to run any desired tests. Alternatively, you can use the terminal to run the tests, for example `./gradlew test -Dbrowser=chormium -Dheadless=false` to run all the tests using the firefox browser in headed mode.
2. Build and browse the allure report using
```
./gradlew allureServe
```

## Languages and Frameworks

The project uses the following:
- *[Java 11](https://openjdk.java.net/projects/jdk/11/)* as the programming language.
- *[Playwright](https://playwright.dev/)* as the web browser automation framework using the Java binding.
- *[Univocity Parsers](https://www.univocity.com/pages/univocity_parsers_tutorial)* to parse and handle CSV files.
- *[JUnit 5](https://junit.org/junit5/)* as the testing framework.
- *[Lombok](https://projectlombok.org/)* to generate getters.
- *[Owner](http://owner.aeonbits.org/)* to minimize the code to handle properties file.
- *[Allure Report](https://qameta.io/allure-report/)* as the test reporting strategy.
- *[Gradle](https://gradle.org/)* as the Java build tool.
- *[IntelliJ IDEA](https://www.jetbrains.com/idea/)* as the IDE.

- ### Page Objects and Page Component Objects
  The project uses [*Page Objects* and *Page Component Objects*](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/) to capture the relevant behaviors of a web page. Check the [*ui*](./src/main/java/io/github/louis/ui) package for reference.

- ### Tests
  The project uses *JUnit 5* as the test runner. Check [this implementation](./src/test/java/io/github/louis/e2e/LoginTest.java) for reference.
