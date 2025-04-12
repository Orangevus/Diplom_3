import drivers.DriverFactory;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.ConstructorPage;
import pages.LoginPage;
import pages.RecoverPasswordPage;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;

public class LoginTests {
    @BeforeClass
    public static void setUp() {
        DriverFactory.setUpDriver();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Description("Проверяем, что по кнопке «Войти в аккаунт» на главной осуществляется переход на страницу входа")
    public void openLoginPageFromHomePage() {
        open("https://stellarburgers.nomoreparties.site/");
        new ConstructorPage().clickButtonSignInAccount();
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Проверяем, что по кнопке «Личный кабинет» осуществляется переход на страницу входа")
    public void openLoginPageFromAccountPage() {
        open("https://stellarburgers.nomoreparties.site/");
        new ConstructorPage().clickPersonalAccountButton();
        new LoginPage().shouldBeDisplayed();
    }

    @Test
    @DisplayName("Вход через кнопку на форме регистрации")
    @Description("Проверяем, что на форме регистрации ...")
    public void openLoginPageFromRegistrationPage() {
        open("https://stellarburgers.nomoreparties.site/register");
        new RegistrationPage().clickLoginButton();
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Проверяем, что на форме восстановления пароля ...")
    public void openLoginPageFromRecoverPasswordPage() {
        open("https://stellarburgers.nomoreparties.site/forgot-password");
        new RecoverPasswordPage().clickLoginButton();
    }
}
