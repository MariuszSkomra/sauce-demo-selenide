package sauce.demo;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class InventoryPage {

    public final SelenideElement shoppingCart = Selenide.$("#shopping_cart_container");
    public final SelenideElement sortBy = Selenide.$("[data-test=product_sort_container]");
    public final ElementsCollection inventoryItemNames = Selenide.$$(".inventory_item_name");
    public final SelenideElement shippingCartBadge = Selenide.$(".shopping_cart_badge");

    public void selectItem(String itemName) {
        Selenide.$x(String.format(
                        "//*[@class='inventory_item' and .//*[@class='inventory_item_name' and text()='%s']]//button",
                        itemName))
                .click();
    }
}
