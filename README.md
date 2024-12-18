# About

Automated tests project executed on [Sauce Demo](https://www.saucedemo.com/) page.

Tests are written in Java 11 with [Selenide](https://selenide.org/) and [JUnit5](https://junit.org/junit5/) usage.

Tests are executed on Chrome browser in headless mode.

# How to run tests

## locally

Use command:

```
mvn test
```

## on CI

Run `Run all tests` workflow.

# How to generate Allure report

## locally

Install Allure according to [documentation](https://allurereport.org/docs/install/).

To generate report:

```bash
allure generate
```

To open report:

```bash
allure open
```

## on CI

HTML report is being published on GitHub Pages under [link](https://mariuszskomra.github.io/sauce-demo-selenide/).