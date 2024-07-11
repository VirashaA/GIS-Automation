package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import utils.WebDriverManager;

public class RegisterTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get("https://natpower-gis-dev-application.azurewebsites.net/auth");
    }
}
