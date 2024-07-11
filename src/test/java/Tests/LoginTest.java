package Tests;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WebDriverManager;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get("https://natpower-gis-dev-application.azurewebsites.net/auth");
    }

    @Test
    public void testLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        // Provide email
        Thread.sleep(1000);
        loginPage.enterEmail("v.amaraweera@natpower.com");

        // Provide password
        Thread.sleep(1000);
        loginPage.enterPassword("Vir@123rasha*");

        // Click login
        Thread.sleep(1000);
        loginPage.clickLoginButton();

        Thread.sleep(1000);

        // Navigate to the home page
        driver.navigate().to("https://natpower-gis-dev-application.azurewebsites.net/");

        Thread.sleep(1000);

        // Get the title of the page
        String actualValue = driver.getTitle();
        String expectedValue = "Nat Power";

        // Assertion to check if the title matches
        Assert.assertEquals(actualValue, expectedValue, "Test case failed: Page title does not match!");

        System.out.println("Test case Pass: Navigate to the Home page");
    }

    @Test
    public void testLoginButtonDisabledWhenEmailIsEmpty() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        // Leave email field empty
        Thread.sleep(1000);

        // Provide password
        Thread.sleep(1000);
        loginPage.enterPassword("Vir@123rasha*");

        // Check if login button is disabled
        Thread.sleep(1000);
        boolean isLoginButtonEnabled = loginPage.isLoginButtonEnabled();

        // Assert that the login button is disabled
        Assert.assertFalse(isLoginButtonEnabled, "Test case failed: Login button should be disabled when email is empty!");

        System.out.println("Test case Pass: Login button is disabled when email is empty");
    }

    @Test
    public void testLoginButtonDisabledWhenPasswordIsEmpty() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        // Provide Email
        loginPage.enterEmail("v.amaraweera@natpower.com");
        Thread.sleep(1000);

        // Leave password field empty
        Thread.sleep(1000);

        // Check if login button is disabled
        Thread.sleep(1000);
        boolean isLoginButtonEnabled = loginPage.isLoginButtonEnabled();

        // Assert that the login button is disabled
        Assert.assertFalse(isLoginButtonEnabled, "Test case failed: Login button should be disabled when password is empty!");

        System.out.println("Test case Pass: Login button is disabled when password is empty");
    }

    @Test
    public void testLoginButtonDisabledWhenBothAreEmpty() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        // Leave email field empty
        Thread.sleep(1000);

        // Leave password field empty
        Thread.sleep(1000);

        // Check if login button is disabled
        Thread.sleep(1000);
        boolean isLoginButtonEnabled = loginPage.isLoginButtonEnabled();

        // Assert that the login button is disabled
        Assert.assertFalse(isLoginButtonEnabled, "Test case failed: Login button should be disabled when both email and password are empty!");

        System.out.println("Test case Pass: Login button is disabled when both email and password are empty");
    }

    @Test
    public void testIncorrectEmailShowsErrorMessage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        // Provide incorrect email
        loginPage.enterEmail("invalid@natpower.com");
        Thread.sleep(1000);

        // Provide correct password
        loginPage.enterPassword("Vir@123rasha*");
        Thread.sleep(1000);

        // Click login
        loginPage.clickLoginButton();
        Thread.sleep(1000);

        // Verify error message
        String errorMessage = loginPage.getErrorMessageIncorrectEmail();
        Assert.assertEquals(errorMessage, "Invalid email or password", "Test case failed: Error message did not match expected value.");

        System.out.println("Test case Pass: Correct error message is displayed for invalid email.");
    }

    @Test
    public void testIncorrectPasswordShowsErrorMessage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        // Provide correct email
        loginPage.enterEmail("v.amaraweera@natpower.com");
        Thread.sleep(1000);

        // Provide incorrect password
        loginPage.enterPassword("1234");
        Thread.sleep(1000);

        // Click login
        loginPage.clickLoginButton();
        Thread.sleep(1000);

        // Verify error message
        String errorMessage = loginPage.getErrorMessageIncorrectPassword();
        Assert.assertEquals(errorMessage, "Invalid email or password", "Test case failed: Error message did not match expected value.");

        System.out.println("Test case Pass: Correct error message is displayed for invalid email.");
    }

    @Test
    public void testIncorrectLoginShowsErrorMessage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        // Provide correct email
        loginPage.enterEmail("invalid@natpower.com");
        Thread.sleep(1000);

        // Provide incorrect password
        loginPage.enterPassword("1234");
        Thread.sleep(1000);

        // Click login
        loginPage.clickLoginButton();
        Thread.sleep(1000);

        // Verify error message
        String errorMessage = loginPage.getErrorMessageIncorrectLogin();
        Assert.assertEquals(errorMessage, "Invalid email or password", "Test case failed: Error message did not match expected value.");

        System.out.println("Test case Pass: Correct error message is displayed for invalid email.");
    }

    @Test
    public void testEmptyEmailErrorMessage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        // Enter a value into the email field
        loginPage.enterEmail("t");
        Thread.sleep(1000);

        // Clear the email field
        loginPage.clearEmail();
        Thread.sleep(1000);

        // Verify error message
        String errorMessage = loginPage.getErrorMessageEmptyEmail();
        Assert.assertEquals(errorMessage, "email is a required field", "Test case failed: Error message did not match expected value.");

        System.out.println("Test case Pass: Correct error message is displayed.");
    }

    @Test
    public void testEmailInvalidFieldErrorMessage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        // Enter a value into the email field
        loginPage.enterEmail("tem");
        Thread.sleep(1000);


        // Verify error message
        String errorMessage = loginPage.geterrorMessageInvalidEmail();
        Assert.assertEquals(errorMessage, "email must be a valid email", "Test case failed: Error message did not match expected value.");

        System.out.println("Test case Pass: Correct error message is displayed.");
    }

    @Test
    public void testRememberMeCheckBoxSelected() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        Thread.sleep(1000);

        // Check if the "Remember Me" checkbox is selected by default
        boolean isRememberMeChecked = loginPage.isRememberMeChecked();

        // Assert that the "Remember Me" checkbox is selected by default
        Assert.assertTrue(isRememberMeChecked, "Test case failed: Remember Me checkbox should be selected by default!");

        System.out.println("Test case Pass: Remember Me checkbox is selected by default.");
    }

    @Test
    public void testForgotPasswordLink() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        Thread.sleep(1000);

        // Click on the "Forgot Password" link
        loginPage.clickForgotPasswordLink();

        // Verify that the URL is correct
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://natpower-gis-dev-application.azurewebsites.net/auth/forgot-password", "Test case failed: Did not navigate to the Forgot Password page.");

        System.out.println("Test case Pass: Navigated to the Forgot Password page.");
    }

    @Test
    public void testRegisterTab() {
        LoginPage loginPage = new LoginPage(driver);

        // Click on the "Register" tab
        loginPage.clickRegisterTab();

        // Verify that the URL is correct
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://natpower-gis-dev-application.azurewebsites.net/auth", "Test case failed: Did not navigate to the Register page.");

        System.out.println("Test case Pass: Navigated to the Register page.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
