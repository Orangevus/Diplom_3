import constants.TestData;
import drivers.DriverFactory;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.RegistrationPage;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationTests {
    private static final String EMAIL = TestData.LOGIN + new Random().nextInt() + TestData.MAIL;
    @BeforeClass
    public static void setUp() {
        DriverFactory.setUpDriver();
    }

    @Before
    public void prepareTest() {
        open("https://stellarburgers.nomoreparties.site/register");
    }

    @Test
    @DisplayName("Успешная регистрация  пользователя")
    @Description("Проверяем, что пользователь успешно создается")
    public void registrationUser() {
        new RegistrationPage().setName(TestData.NAME)
                .setEmail(EMAIL)
                .setPassword(TestData.PASSWORD)
                .clickRegistrationButton();
        new LoginPage().shouldBeDisplayed()
                .setEmail(EMAIL)
                .setPassword(TestData.PASSWORD)
                .clickLoginButton()
                .clickPersonalAccountButton();
        new AccountPage().shouldBeDisplayed()
                .checkName(TestData.NAME)
                .checkEmail(EMAIL);
    }

    @Test
    @DisplayName("Ошибка регистрации с некорректным паролем")
    @Description("Проверяем, что нельзя зарегистрироваться с паролем меньше 6 символов")
    public void registrationUserWithIncorrectPassword() {
        new RegistrationPage().setName(TestData.NAME)
                .setEmail(EMAIL)
                .setPassword(TestData.INCORRECT_PASSWORD)
                .clickRegistrationButton()
                .shouldBeVisibleInputError();
    }
}
