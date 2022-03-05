package sauce.demo;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class LoginPage {

    public final SelenideElement errorMessage = Selenide.$(".error-message-container");
    private final SelenideElement usernameInput = Selenide.$("#user-name");
    private final SelenideElement passwordInput = Selenide.$("#password");
    private final SelenideElement loginButton = Selenide.$("#login-button");

    public void open() {
        Selenide.open("https://www.saucedemo.com");
    }

    public void loginAs(String username, String password) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.click();
    }
}
