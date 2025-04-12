package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class AccountPage extends BasePage {
    private SelenideElement nameFieldInput = $x(".//label[text()='Имя']/following-sibling::input");
    private SelenideElement emailFieldInput = $x(".//label[text()='Логин']/following-sibling::input");
    private SelenideElement exitButton = $x(".//button[(text()='Выход')]");
    private SelenideElement accountText = $x(".//p[contains(@class, 'Account_text')]");

    @Step("Проверить, что в поле имя содержится {name}")
    public AccountPage checkName(String name) {
        nameFieldInput.shouldBe(visible).shouldHave(exactValue(name));
        return this;
    }

    @Step("Проверить, что в поле email содержится {email}")
    public AccountPage checkEmail(String email) {
        emailFieldInput.shouldBe(visible).shouldHave(exactValue(email));
        return this;
    }

    @Step("Кликнуть на кнопку Выход")
    public LoginPage clickExitButton() {
        exitButton.shouldBe(visible).click();
        return new LoginPage().shouldBeDisplayed();
    }

    @Override
    @Step("Проверить отображение страницы Личный кабинет")
    public AccountPage shouldBeDisplayed() {
        nameFieldInput.shouldBe(visible);
        emailFieldInput.shouldBe(visible);
        exitButton.shouldBe(visible);
        accountText.shouldBe(visible);
        return this;
    }
}
