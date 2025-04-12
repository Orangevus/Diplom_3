package drivers;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
    public static WebDriver setUpDriver() {
        String browser = System.getProperty("browser", "chrome");

        if (browser.equals("chrome")) {
            ChromeDriverManager.getInstance().setup();
            Configuration.browser = browser;
        }

        if (browser.equals("yandex")) {
            Configuration.browser = YandexWebdriverProvider.class.getName();
        }

        return null;
    }
}
