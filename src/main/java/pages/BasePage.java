package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public abstract class BasePage<Page> {
    private SelenideElement constructorButton = $x(".//a[@href='/' and contains(@class, 'AppHeader_header__link')]");
    private SelenideElement stellarBurgersLogo = $x(".//div[contains(@class, 'AppHeader_header__logo')]");
    private SelenideElement personalAccountButton = $x(".//a[@href='/account' and contains(@class, 'AppHeader_header__link')]");

    @Step("Кликнуть по кнопке Конструктор")
    public ConstructorPage clickConstructorButton() {
        constructorButton.shouldBe(visible).click();
        return new ConstructorPage().shouldBeDisplayed();
    }

    @Step("Кликнуть на логотип Stellar Burgers")
    public ConstructorPage clickStellarBurgersLogo() {
        stellarBurgersLogo.shouldBe(visible).click();
        return new ConstructorPage().shouldBeDisplayed();
    }

    @Step("Кликнуть на кнопку Личный кабинет")
    public AccountPage clickPersonalAccountButton() {
        personalAccountButton.shouldBe(visible).click();
        return new AccountPage();
    }

    public abstract Page shouldBeDisplayed();
}
