package Tests;

import Pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WebDriverManager;

public class RegisterTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get("https://natpower-gis-dev-application.azurewebsites.net/auth");

        // Navigate to the Register page by clicking the Register tab
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickRegisterTab();
    }

    @Test
    public void testRegisterButtonDisabledForAllEmpty() {
        RegisterPage registerPage = new RegisterPage(driver);

        // Verify if the register button is disabled
        boolean isRegisterButtonEnabled = registerPage.isRegisterButtonEnabled();
        Assert.assertFalse(isRegisterButtonEnabled, "Test case failed: Register button should be disabled when required fields are empty!");

        System.out.println("Test case Pass: Register button is disabled when all required fields are empty.");
    }
}
