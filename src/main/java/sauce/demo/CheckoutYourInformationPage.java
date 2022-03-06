package sauce.demo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class CheckoutYourInformationPage {

    public final SelenideElement errorMessage = Selenide.$(".error-message-container");
    private final SelenideElement firstNameInput = Selenide.$("#first-name");
    private final SelenideElement lastNameInput = Selenide.$("#last-name");
    private final SelenideElement postalCodeInput = Selenide.$("#postal-code");
    private final SelenideElement continueButton = Selenide.$("#continue");

    public void open() {
        Selenide.open(Configuration.baseUrl + "/checkout-step-one.html");
    }

    public void fillFormAndSubmit(String firstName, String lastName, String postalCode) {
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        postalCodeInput.setValue(postalCode);
        continueButton.click();
    }
}
