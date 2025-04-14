package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class RecoverPasswordPage {
    private SelenideElement loginButton = $x(".//a[@href='/login' and contains(@class, 'Auth_link__1fOlj')]");

    @Step("Кликнуть на кнопку Войти")
    public LoginPage clickLoginButton() {
        loginButton.shouldBe(visible).click();
        return new LoginPage().shouldBeDisplayed();
    }
}