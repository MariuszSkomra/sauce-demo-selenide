package sauce.demo;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

public class CartPage {

    public final ElementsCollection inventoryItemNames = Selenide.$$(".inventory_item_name");
}
