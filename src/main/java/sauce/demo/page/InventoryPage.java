package sauce.demo.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class InventoryPage {

    public final SelenideElement shoppingCart = Selenide.$("#shopping_cart_container");
    public final SelenideElement sortBy = Selenide.$("[data-test=product-sort-container]");
    private final ElementsCollection inventoryItems = Selenide.$$("[data-test=inventory-item]");
    public final ElementsCollection inventoryItemNames = Selenide.$$(".inventory_item_name");
    public final SelenideElement shippingCartBadge = Selenide.$(".shopping_cart_badge");

    public void selectItem(String itemName) {
        inventoryItems.findBy(Condition.text(itemName)).$("button").click();
    }
}
