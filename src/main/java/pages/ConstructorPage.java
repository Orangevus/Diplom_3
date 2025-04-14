package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class ConstructorPage extends BasePage<ConstructorPage> {
    private SelenideElement buttonSignInAccount = $x(".//button[contains(@class, 'button_type_primary')]");
    private SelenideElement pageTitle = $x(".//h1");

    @Step("Кликнуть на кнопку {tabName}")
    public ConstructorPage clickIngredientTab(String tabName) {
        SelenideElement tab = $x(".//span[contains(@class, 'text') and text()='" + tabName + "']/parent::div");
        tab.shouldBe(visible).click();
        tab.shouldHave(attributeMatching("class", ".*current.*"));
        return this;
    }

    @Step("Кликнуть на кнопку Войти в аккаунт")
    public LoginPage clickButtonSignInAccount() {
        buttonSignInAccount.shouldBe(visible).click();
        return new LoginPage().shouldBeDisplayed();
    }

    @Override
    @Step("Проверить отображение главной страницы")
    public ConstructorPage shouldBeDisplayed() {
        buttonSignInAccount.shouldBe(visible);
        pageTitle.shouldBe(visible).shouldHave(text("Соберите бургер"));
        return this;
    }
}