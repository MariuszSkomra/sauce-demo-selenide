package sauce.demo;

import static com.codeborne.selenide.CollectionCondition.exactTexts;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddToCartTest {

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
        // when
        Selenide.open("https://www.saucedemo.com/checkout-step-two.html");

        // then
        Selenide.page(CheckoutOverviewPage.class).inventoryItemNames
                .shouldHave(exactTexts(itemsToAdd));
    }
}
