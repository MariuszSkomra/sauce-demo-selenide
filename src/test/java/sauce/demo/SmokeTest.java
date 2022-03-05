package sauce.demo;

import static com.codeborne.selenide.Condition.visible;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

public class SmokeTest {

    @Test
    public void smokeTest(){
        // when
        Selenide.open("https://www.saucedemo.com");

        // then
        Selenide.$("#login-button").shouldBe(visible);
    }
}
