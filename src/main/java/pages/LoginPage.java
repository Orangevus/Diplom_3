package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage<LoginPage> {
    private SelenideElement emailFieldInput = $x(".//label[text()='Email']/following-sibling::input");
    private SelenideElement passwordFieldInput = $x(".//input[@name='Пароль']");
    private SelenideElement loginButton = $x(".//button[(text()='Войти')]");
    private SelenideElement titleHeader = $x(".//h2[text()='Вход']");

    @Step("Заполнить поле Email")
    public LoginPage setEmail(String email) {
        emailFieldInput.shouldBe(visible).setValue(email);
        emailFieldInput.shouldHave(exactValue(email));
        return this;
    }

    @Step("Заполнить поле Пароль")
    public LoginPage setPassword(String password) {
        passwordFieldInput.shouldBe(visible).setValue(password);
        passwordFieldInput.shouldHave(exactValue(password));
        return this;
    }

    @Step("Кликнуть на кнопку Войти")
    public ConstructorPage clickLoginButton() {
        loginButton.shouldBe(visible).click();
        return new ConstructorPage().shouldBeDisplayed();
    }

    @Override
    @Step("Проверить отображение страницы Логин")
    public LoginPage shouldBeDisplayed() {
        titleHeader.shouldBe(visible);
        emailFieldInput.shouldBe(visible);
        passwordFieldInput.shouldBe(visible);
        return this;
    }
}