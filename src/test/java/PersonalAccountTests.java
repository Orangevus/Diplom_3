import constants.TestData;
import drivers.DriverFactory;
import dto.User;
import dto.response.UserResponse;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.*;
import org.junit.runners.MethodSorters;
import pages.ConstructorPage;
import pages.LoginPage;
import api.CreateAndDeleteUser;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonalAccountTests {
    private static final User USER = new User(
            TestData.LOGIN + new Random().nextInt() + TestData.MAIL,
            TestData.PASSWORD,
            TestData.NAME
    );
    private static UserResponse response;

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = TestData.BASE_URI;
        DriverFactory.setUpDriver();
        response = CreateAndDeleteUser.createUser(USER, 200);
        open("https://stellarburgers.nomoreparties.site/login");
        new LoginPage().shouldBeDisplayed()
                .setEmail(USER.getEmail())
                .setPassword(USER.getPassword()).clickLoginButton();
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет»")
    @Description("Проверяем переход в личный кабинет")
    public void checkGoToPersonalAccount() {
        new ConstructorPage().clickPersonalAccountButton()
                .shouldBeDisplayed();
    }

    @Test
    @DisplayName("Переход по клику на «Конструктор» из личного кабинета")
    @Description("Проверяем переход по клику на конструктор")
    public void checkGoToConstructor() {
        new ConstructorPage().clickPersonalAccountButton()
                .shouldBeDisplayed()
                .clickConstructorButton();
    }

    @Test
    @DisplayName("Переход по клику на логотип Stellar Burgers из личного кабинета")
    @Description("Проверяем переход по клику на логотип")
    public void checkGoToLogoStellarBurgers() {
        new ConstructorPage().clickPersonalAccountButton()
                .shouldBeDisplayed()
                .clickStellarBurgersLogo();
    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    @Description("Проверяем выход из аккаунта")
    public void checkOutFromPersonalAccount() {
        new ConstructorPage().clickPersonalAccountButton()
                .shouldBeDisplayed()
                .clickExitButton();
    }

    @AfterClass
    public static void tearDown() {
        CreateAndDeleteUser.deleteUser(response.getAccessToken());
    }
}