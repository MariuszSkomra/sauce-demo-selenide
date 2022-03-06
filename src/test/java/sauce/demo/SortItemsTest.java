package sauce.demo;

import static com.codeborne.selenide.CollectionCondition.exactTexts;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortItemsTest {

    private final LoginPage loginPage = Selenide.page(LoginPage.class);
    private final InventoryPage inventoryPage = Selenide.page(InventoryPage.class);

    @BeforeEach
    public void setup() {
        loginPage
                .open()
                .loginAs("standard_user", "secret_sauce");
    }

    @Test
    public void shouldSortItemsByNameFromAToZ() {
        // when
        inventoryPage.sortBy.selectOption("Name (A to Z)");

        // then
        inventoryPage.inventoryItemNames.shouldHave(exactTexts(
                "Sauce Labs Backpack",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Fleece Jacket",
                "Sauce Labs Onesie",
                "Test.allTheThings() T-Shirt (Red)"
        ));
    }

    @Test
    public void shouldSortItemsByNameFromZToA() {
        // when
        inventoryPage.sortBy.selectOption("Name (Z to A)");

        // then
        inventoryPage.inventoryItemNames.shouldHave(exactTexts(
                "Test.allTheThings() T-Shirt (Red)",
                "Sauce Labs Onesie",
                "Sauce Labs Fleece Jacket",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Bike Light",
                "Sauce Labs Backpack"
        ));
    }

    @Test
    public void shouldSortItemsByPriceFromLowToHigh() {
        // when
        inventoryPage.sortBy.selectOption("Price (low to high)");

        // then
        inventoryPage.inventoryItemNames.shouldHave(exactTexts(
                "Sauce Labs Onesie",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt",
                "Test.allTheThings() T-Shirt (Red)",
                "Sauce Labs Backpack",
                "Sauce Labs Fleece Jacket"
        ));
    }

    @Test
    public void shouldSortItemsByPriceFromHighToLow() {
        // when
        inventoryPage.sortBy.selectOption("Price (high to low)");

        // then
        inventoryPage.inventoryItemNames.shouldHave(exactTexts(
                "Sauce Labs Fleece Jacket",
                "Sauce Labs Backpack",
                "Sauce Labs Bolt T-Shirt",
                "Test.allTheThings() T-Shirt (Red)",
                "Sauce Labs Bike Light",
                "Sauce Labs Onesie"
        ));
    }
}
