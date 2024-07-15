package Tests;

import Pages.LoginPage;
import Pages.RegisterPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @BeforeMethod
    public void navigateToRegisterPage() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickRegisterTab();
    }

    @Test
    public void testRegister() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);

        // Provide First Name
        Thread.sleep(1000);
        registerPage.enterFirstName("John");

        // Provide Last Name
        Thread.sleep(1000);
        registerPage.enterLastName("Smith");

        // Provide Email
        Thread.sleep(1000);
        registerPage.enterEmail("j.smith@natpower.com");

        // Provide Password
        Thread.sleep(1000);
        registerPage.enterPassword("1234");

        // Provide Confirm Password
        Thread.sleep(1000);
        registerPage.enterConfirmPassword("1234");

        // Click Register
        Thread.sleep(1000);
        registerPage.clickRegisterButton();

        Thread.sleep(1000);

        // Navigate to the email verification page
        driver.navigate().to("https://natpower-gis-dev-application.azurewebsites.net/auth/email-verification/");

        Thread.sleep(1000);

        // Get the title of the page
        String actualValue = driver.getTitle();
        String expectedValue = "Nat Power";

        // Assertion to check if the title matches
        Assert.assertEquals(actualValue, expectedValue, "Test case failed: Page title does not match!");

        System.out.println("Test case Pass: Navigate to the Email Verification page");
    }

    @Test
    public void testRegisterButtonDisabledForAllEmpty() {
        RegisterPage registerPage = new RegisterPage(driver);

        // Verify if the register button is disabled
        boolean isRegisterButtonEnabled = registerPage.isRegisterButtonEnabled();
        Assert.assertFalse(isRegisterButtonEnabled, "Test case failed: Register button should be disabled when required fields are empty!");

        System.out.println("Test case Pass: Register button is disabled when all required fields are empty.");
    }

    @Test
    public void testRegisterButtonDisabledForFirstNameEmpty() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);

        // Provide Last Name
        Thread.sleep(1000);
        registerPage.enterLastName("Smith");

        // Provide Email
        Thread.sleep(1000);
        registerPage.enterEmail("j.smith@natpower.com");

        // Provide Password
        Thread.sleep(1000);
        registerPage.enterPassword("1234");

        // Provide Confirm Password
        Thread.sleep(1000);
        registerPage.enterConfirmPassword("1234");

        // Verify if the register button is disabled
        boolean isRegisterButtonEnabled = registerPage.isRegisterButtonEnabled();
        Assert.assertFalse(isRegisterButtonEnabled, "Test case failed: Register button should be disabled when First Name is empty!");

        System.out.println("Test case Pass: Register button is disabled when First Name field is empty.");
    }

    @Test
    public void testRegisterButtonDisabledForLastNameEmpty() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);

        // Provide First Name
        Thread.sleep(1000);
        registerPage.enterFirstName("John");

        // Provide Email
        Thread.sleep(1000);
        registerPage.enterEmail("j.smith@natpower.com");

        // Provide Password
        Thread.sleep(1000);
        registerPage.enterPassword("1234");

        // Provide Confirm Password
        Thread.sleep(1000);
        registerPage.enterConfirmPassword("1234");

        // Verify if the register button is disabled
        boolean isRegisterButtonEnabled = registerPage.isRegisterButtonEnabled();
        Assert.assertFalse(isRegisterButtonEnabled, "Test case failed: Register button should be disabled when Last Name is empty!");

        System.out.println("Test case Pass: Register button is disabled when Last Name field is empty.");
    }

    @Test
    public void testRegisterButtonDisabledForEmailEmpty() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);

        // Provide First Name
        Thread.sleep(1000);
        registerPage.enterFirstName("John");

        // Provide Last Name
        Thread.sleep(1000);
        registerPage.enterLastName("Smith");

        // Provide Password
        Thread.sleep(1000);
        registerPage.enterPassword("1234");

        // Provide Confirm Password
        Thread.sleep(1000);
        registerPage.enterConfirmPassword("1234");

        // Verify if the register button is disabled
        boolean isRegisterButtonEnabled = registerPage.isRegisterButtonEnabled();
        Assert.assertFalse(isRegisterButtonEnabled, "Test case failed: Register button should be disabled when Email is empty!");

        System.out.println("Test case Pass: Register button is disabled when Email field is empty.");
    }

    @Test
    public void testRegisterButtonDisabledForPasswordEmpty() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);

        // Provide First Name
        Thread.sleep(1000);
        registerPage.enterFirstName("John");

        // Provide Last Name
        Thread.sleep(1000);
        registerPage.enterLastName("Smith");

        // Provide Email
        Thread.sleep(1000);
        registerPage.enterEmail("j.smith@natpower.com");

        // Provide Confirm Password
        Thread.sleep(1000);
        registerPage.enterConfirmPassword("1234");

        // Verify if the register button is disabled
        boolean isRegisterButtonEnabled = registerPage.isRegisterButtonEnabled();
        Assert.assertFalse(isRegisterButtonEnabled, "Test case failed: Register button should be disabled when Password is empty!");

        System.out.println("Test case Pass: Register button is disabled when Password field is empty.");
    }

    @Test
    public void testRegisterButtonDisabledForConfirmPasswordEmpty() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);

        // Provide First Name
        Thread.sleep(1000);
        registerPage.enterFirstName("John");

        // Provide Last Name
        Thread.sleep(1000);
        registerPage.enterLastName("Smith");

        // Provide Email
        Thread.sleep(1000);
        registerPage.enterEmail("j.smith@natpower.com");

        // Provide Password
        Thread.sleep(1000);
        registerPage.enterPassword("1234");

        // Verify if the register button is disabled
        boolean isRegisterButtonEnabled = registerPage.isRegisterButtonEnabled();
        Assert.assertFalse(isRegisterButtonEnabled, "Test case failed: Register button should be disabled when Confirm Password is empty!");

        System.out.println("Test case Pass: Register button is disabled when Confirm Password field is empty.");
    }

    @Test
    public void testEmailInvalidFieldErrorMessage() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);

        // Enter a value into the email field
        registerPage.enterEmail("tem");
        Thread.sleep(1000);

        // Verify error message
        String errorMessage = registerPage.geterrorMessageInvalidEmail();
        Assert.assertEquals(errorMessage, "email must be a valid email", "Test case failed: Error message did not match expected value.");

        System.out.println("Test case Pass: Correct error message is displayed.");
    }

    @Test
    public void testEmailDuplicateErrorMessage() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);

        // Provide First Name
        Thread.sleep(1000);
        registerPage.enterFirstName("John");

        // Provide Last Name
        Thread.sleep(1000);
        registerPage.enterLastName("Smith");

        // Provide Email
        Thread.sleep(1000);
        registerPage.enterEmail("v.amaraweera@natpower.com");

        // Provide Password
        Thread.sleep(1000);
        registerPage.enterPassword("1234");

        // Provide Confirm Password
        Thread.sleep(1000);
        registerPage.enterConfirmPassword("1234");

        // Click Register
        Thread.sleep(1000);
        registerPage.clickRegisterButton();

        Thread.sleep(1000);

        // Verify error message
        String errorMessage = registerPage.geterrorMessageDuplicateEmail();
        Assert.assertEquals(errorMessage, "Account existed", "Test case failed: Error message did not match expected value.");

        System.out.println("Test case Pass: Correct error message is displayed.");
    }

    @Test
    public void testRegisterButtonDisabledForDifferentPasswords() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);

        // Provide First Name
        Thread.sleep(1000);
        registerPage.enterFirstName("John");

        // Provide Last Name
        Thread.sleep(1000);
        registerPage.enterLastName("Smith");

        // Provide Email
        Thread.sleep(1000);
        registerPage.enterEmail("j.smith@natpower.com");

        // Provide Password
        Thread.sleep(1000);
        registerPage.enterPassword("1234");

        // Provide Confirm Password
        Thread.sleep(1000);
        registerPage.enterConfirmPassword("12345");

        // Verify error message
        String errorMessage = registerPage.geterrorMessageDifferentPasswords();
        Assert.assertEquals(errorMessage, "must match password", "Test case failed: Error message did not match expected value.");

        System.out.println("Test case Pass: Correct error message is displayed.");
    }

    @Test
    public void testLoginTab() {
        RegisterPage registerPage = new RegisterPage(driver);

        // Click on the "Login" tab
        registerPage.clickLoginTab();

        // Verify that the URL is correct
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://natpower-gis-dev-application.azurewebsites.net/auth", "Test case failed: Did not navigate to the Login page.");

        System.out.println("Test case Pass: Navigated to the Login page.");
    }
}
