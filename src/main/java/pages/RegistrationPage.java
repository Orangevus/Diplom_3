package pages;

import com.codeborne.selenide.SelenideElement;
import constants.TestData;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage {
    private SelenideElement nameFieldInput = $x(".//label[text()='Имя']/following-sibling::input");
    private SelenideElement emailFieldInput = $x(".//label[text()='Email']/following-sibling::input");
    private SelenideElement passwordFieldInput = $x(".//input[@name='Пароль']");
    private SelenideElement registrationButton = $x(".//button[(text()='Зарегистрироваться')]");
    private SelenideElement loginButton = $x(".//a[@href='/login' and contains(@class, 'Auth_link__1fOlj')]");
    private SelenideElement inputError = $x(".//p[contains(@class,'input__error')]");

    @Step("Заполнить поле Имя")
    public RegistrationPage setName(String userName) {
        nameFieldInput.shouldBe(visible).setValue(userName);
        nameFieldInput.shouldHave(exactValue(userName));
        return this;
    }

    @Step("Заполнить поле Email")
    public RegistrationPage setEmail(String email) {
        emailFieldInput.shouldBe(visible).setValue(email);
        emailFieldInput.shouldHave(exactValue(email));
        return this;
    }

    @Step("Заполнить поле Пароль")
    public RegistrationPage setPassword(String password) {
        passwordFieldInput.shouldBe(visible).setValue(password);
        passwordFieldInput.shouldHave(exactValue(password));
        return this;
    }

    @Step("Кликнуть на кнопку Зарегистрироваться")
    public RegistrationPage clickRegistrationButton() {
        registrationButton.shouldBe(visible).click();
        return this;
    }

    @Step("Кликнуть на кнопку Войти")
    public LoginPage clickLoginButton() {
        loginButton.shouldBe(visible).click();
        return new LoginPage().shouldBeDisplayed();
    }

    @Step("Проверить, что сработала ошибка валидации для поля пароль")
    public RegistrationPage shouldBeVisibleInputError() {
        inputError.shouldBe(visible).shouldHave(text(TestData.PASSWORD_INPUT_ERROR));
        return this;
    }
}