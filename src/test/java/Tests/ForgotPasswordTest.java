package Tests;

import Pages.ForgotPasswordPage;
import Pages.RegisterPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseTest {

    @BeforeMethod
    public void navigateToForgotPasswordPage() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickForgotPasswordLink();
    }

    @Test
    public void testSendCode() throws InterruptedException {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        // Provide Email
        Thread.sleep(1000);
        forgotPasswordPage.enterEmail("v.amaraweera@natpower.com");

        // Click Send Code
        Thread.sleep(1000);
        forgotPasswordPage.clickSendCodeButton();

        Thread.sleep(1000);

        // Navigate to the verification code page
        driver.navigate().to("https://natpower-gis-dev-application.azurewebsites.net/auth/verify-code?email=v.amaraweera@natpower.com");

        Thread.sleep(1000);

        // Get the title of the page
        String actualValue = driver.getTitle();
        String expectedValue = "Nat Power";

        // Assertion to check if the title matches
        Assert.assertEquals(actualValue, expectedValue, "Test case failed: Page title does not match!");

        System.out.println("Test case Pass: Navigate to the Verification Code page");
    }

    @Test
    public void testEmailEmptyErrorMessage() throws InterruptedException {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        //Don't provide Email

        // Click Send Code
        Thread.sleep(1000);
        forgotPasswordPage.clickSendCodeButton();

        Thread.sleep(1000);

        // Verify error message
        String errorMessage = forgotPasswordPage.getErrorMessageEmptyEmail();
        Assert.assertEquals(errorMessage, "email is a required field", "Test case failed: Error message did not match expected value.");

        System.out.println("Test case Pass: Correct error message is displayed.");
    }

    @Test
    public void testEmailInvalidErrorMessage() throws InterruptedException {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        //Enter invalid email
        Thread.sleep(1000);
        forgotPasswordPage.enterEmail("v.amarawee");

        // Click Send Code
        Thread.sleep(1000);
        forgotPasswordPage.clickSendCodeButton();

        Thread.sleep(1000);

        // Verify error message
        String errorMessage = forgotPasswordPage.getErrorMessageInvalidEmail();
        Assert.assertEquals(errorMessage, "email must be a valid email", "Test case failed: Error message did not match expected value.");

        System.out.println("Test case Pass: Correct error message is displayed.");
    }

    @Test
    public void testEmailIncorrectErrorMessage() throws InterruptedException {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        //Enter invalid email
        Thread.sleep(1000);
        forgotPasswordPage.enterEmail("john@natpoer.com");

        // Click Send Code
        Thread.sleep(1000);
        forgotPasswordPage.clickSendCodeButton();

        Thread.sleep(1000);

        // Verify error message
        String errorMessage = forgotPasswordPage.getErrorMessageIncorrectEmail();
        Assert.assertEquals(errorMessage, "Send code eror", "Test case failed: Error message did not match expected value.");

        System.out.println("Test case Pass: Correct error message is displayed.");
    }

    @Test
    public void testButtonChangeToReSendCode() throws InterruptedException {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        // Enter incorrect email
        Thread.sleep(1000);
        forgotPasswordPage.enterEmail("incorrectemail@example.com");

        // Click Send Code
        Thread.sleep(1000);
        forgotPasswordPage.clickSendCodeButton();

        Thread.sleep(1000);

        // Verify if the Re-send Code button is visible
        boolean isReSendCodeButtonVisible = forgotPasswordPage.isReSendCodeButtonVisible();
        Assert.assertTrue(isReSendCodeButtonVisible, "Test case failed: Re-send Code button is not visible.");

        System.out.println("Test case Pass: Re-send Code button is displayed.");

        // Click Re-send Code button
        forgotPasswordPage.clickReSendCodeButton();

        System.out.println("Re-send Code button was clicked successfully.");
    }

    @Test
    public void testReSendCode() throws InterruptedException {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        // Enter incorrect email
        Thread.sleep(1000);
        forgotPasswordPage.enterEmail("incorrectemail@example.com");

        // Click Send Code
        Thread.sleep(1000);
        forgotPasswordPage.clickSendCodeButton();

        Thread.sleep(1000);

        // Verify if the Re-send Code button is visible
        boolean isReSendCodeButtonVisible = forgotPasswordPage.isReSendCodeButtonVisible();
        Assert.assertTrue(isReSendCodeButtonVisible, "Test case failed: Re-send Code button is not visible.");

        System.out.println("Test case Pass: Re-send Code button is displayed.");

        // Clear the email field
        forgotPasswordPage.clearEmailField();

        // Enter correct email
        Thread.sleep(1000);
        forgotPasswordPage.enterEmail("j.smith@natpower.com");

        // Click Re-send Code
        Thread.sleep(1000);
        forgotPasswordPage.clickReSendCodeButton();

        System.out.println("Re-send Code button was clicked successfully.");
    }

}


