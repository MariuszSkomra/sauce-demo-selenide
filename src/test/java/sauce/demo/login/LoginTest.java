package sauce.demo.login;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sauce.demo.BaseTest;
import sauce.demo.page.InventoryPage;
import sauce.demo.page.LoginPage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;

public class LoginTest extends BaseTest {

    private final LoginPage loginPage = Selenide.page(LoginPage.class);
    private final InventoryPage inventoryPage = Selenide.page(InventoryPage.class);

    @BeforeEach
    public void setup() {
        loginPage.open();
    }

    @Test
    public void shouldLoginWithCorrectCredentials() {
        // when
        loginPage.loginAs("standard_user", "secret_sauce");

        // then
        inventoryPage.shoppingCart.shouldBe(visible);
    }

    @Test
    public void shouldDisplayErrorWhenCredentialsAreIncorrect() {
        // when
        loginPage.loginAs("admin", "admin");

        // then
        loginPage.errorMessage.shouldHave(exactText(
                "Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    public void shouldDisplayErrorWhenUserIsLockedOut() {
        // when
        loginPage.loginAs("locked_out_user", "secret_sauce");

        // then
        loginPage.errorMessage.shouldHave(
                exactText("Epic sadface: Sorry, this user has been locked out."));
    }

    @Test
    public void shouldLoginAsUserWithPerformanceGlitch() {
        // when
        loginPage.loginAs("performance_glitch_user", "secret_sauce");

        // then
        inventoryPage.shoppingCart.shouldBe(visible);
    }
}
