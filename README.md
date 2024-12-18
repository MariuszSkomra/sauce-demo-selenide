# About

Automated tests project executed on [Sauce Demo](https://www.saucedemo.com/) page.

Tests are written in Java 11 with [Selenide](https://selenide.org/) and [JUnit5](https://junit.org/junit5/) usage.

Tests are executed on Chrome browser in headless mode.

# How to run tests

Use command:

```
mvn test
```

To disable headless mode use command:

```
mvn test -D"selenide.headless=false"
```

or change `selenide.headless` property in `selenide.properties` to `false`.

# How to generate Allure report

Install Allure according to [documentation](https://allurereport.org/docs/install/).

To generate report:

```bash
allure generate
```

To open report:

```bash
allure open
```
