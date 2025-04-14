import drivers.DriverFactory;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.ConstructorPage;

import static com.codeborne.selenide.Selenide.open;

@RunWith(Parameterized.class)
public class ConstructorTests {
    private String tabName;

    public ConstructorTests(String tabName) {
        this.tabName = tabName;
    }

    @BeforeClass
    public static void setUp() {
        DriverFactory.setUpDriver();
        open("https://stellarburgers.nomoreparties.site");
    }

    @Parameterized.Parameters
    public static Object[][] getTabName() {
        return new Object[][]{
                {"Соусы"},
                {"Начинки"},
                {"Булки"}
        };
    }

    @Test
    @DisplayName("Переход по разделам ингредиентов")
    @Description("Проверяем переход к разделам")
    public void checkTabs() {
        new ConstructorPage().shouldBeDisplayed()
                .clickIngredientTab(tabName);
    }
}
