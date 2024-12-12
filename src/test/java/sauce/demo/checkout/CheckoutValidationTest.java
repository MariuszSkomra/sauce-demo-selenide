package sauce.demo.checkout;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sauce.demo.BaseTest;
import sauce.demo.TextReportAbility;
import sauce.demo.page.LoginPage;
import sauce.demo.page.checkout.CheckoutYourInformationPage;

import static com.codeborne.selenide.Condition.exactText;

public class CheckoutValidationTest extends BaseTest implements TextReportAbility {

    private final LoginPage loginPage = Selenide.page(LoginPage.class);
    private final CheckoutYourInformationPage checkoutYourInformationPage =
            Selenide.page(CheckoutYourInformationPage.class);

    @BeforeEach
    public void setup() {
        loginPage
                .open()
                .loginAs("standard_user", "secret_sauce");

        checkoutYourInformationPage.open();
    }

    @Test
    public void shouldNotBePossibleToCheckoutWithoutFirstName() {
        // when
        checkoutYourInformationPage.fillFormAndSubmit("", "Doe", "11-222");

        // then
        checkoutYourInformationPage.errorMessage
                .shouldHave(exactText("Error: First Name is required"));
    }

    @Test
    public void shouldNotBePossibleToCheckoutWithoutLastName() {
        // when
        checkoutYourInformationPage.fillFormAndSubmit("John", "", "11-222");

        // then
        checkoutYourInformationPage.errorMessage
                .shouldHave(exactText("Error: Last Name is required"));
    }

    @Test
    public void shouldNotBePossibleToCheckoutWithoutPostalCode() {
        // when
        checkoutYourInformationPage.fillFormAndSubmit("John", "Doe", "");

        // then
        checkoutYourInformationPage.errorMessage
                .shouldHave(exactText("Error: Postal Code is required"));
    }
}
