package sauce.demo.page;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class LoginPage {

    public final SelenideElement errorMessage = Selenide.$(".error-message-container");
    private final SelenideElement usernameInput = Selenide.$("#user-name");
    private final SelenideElement passwordInput = Selenide.$("#password");
    private final SelenideElement loginButton = Selenide.$("#login-button");

    public LoginPage open() {
        Selenide.open(Configuration.baseUrl);
        return this;
    }

    public void loginAs(String username, String password) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.click();
    }
}
