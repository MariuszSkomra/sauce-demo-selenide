package sauce.demo;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

    @BeforeAll
    public void globalSetup() {
        SelenideLogger.addListener("AllureReporter", new AllureSelenide());
    }
}
