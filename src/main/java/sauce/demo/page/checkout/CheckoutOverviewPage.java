package sauce.demo.page.checkout;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

public class CheckoutOverviewPage {

    public final ElementsCollection inventoryItemNames = Selenide.$$(".inventory_item_name");

    public void open() {
        Selenide.open(Configuration.baseUrl + "/checkout-step-two.html");
    }
}
