package sauce.demo.inventory;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sauce.demo.BaseTest;
import sauce.demo.page.CartPage;
import sauce.demo.page.InventoryPage;
import sauce.demo.page.LoginPage;
import sauce.demo.page.checkout.CheckoutOverviewPage;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.exactTexts;

public class AddToCartTest extends BaseTest {

    private final List<String> itemsToAdd = List.of("Sauce Labs Onesie", "Sauce Labs Backpack");
    private final LoginPage loginPage = Selenide.page(LoginPage.class);
    private final InventoryPage inventoryPage = Selenide.page(InventoryPage.class);

    @BeforeEach
    public void setup() {
        loginPage
                .open()
                .loginAs("standard_user", "secret_sauce");

        itemsToAdd.forEach(inventoryPage::selectItem);
    }

    @AfterEach
    public void cleanup() {
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    public void shouldShowNumberOfItemsInCart() {
        inventoryPage.shippingCartBadge.shouldHave(Condition.exactText("2"));
    }

    @Test
    public void selectedItemsShouldBeInCart() {
        // when
        inventoryPage.shoppingCart.click();

        // then
        Selenide.page(CartPage.class).inventoryItemNames.shouldHave(exactTexts(itemsToAdd));
    }

    @Test
    public void selectedItemsShouldBeInCheckoutOverview() {
        // given
        CheckoutOverviewPage checkoutOverviewPage = Selenide.page(CheckoutOverviewPage.class);

        // when
        checkoutOverviewPage.open();

        // then
        checkoutOverviewPage.inventoryItemNames.shouldHave(exactTexts(itemsToAdd));
    }
}
