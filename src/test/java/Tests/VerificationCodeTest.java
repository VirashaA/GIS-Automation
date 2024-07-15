package Tests;

import Pages.ForgotPasswordPage;
import Pages.VerificationCodePage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerificationCodeTest extends BaseTest {

    @BeforeMethod
    public void navigateToForgotPasswordPage() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickForgotPasswordLink();
    }

    @Test
    public void testCodeEmptyErrorMessage() throws InterruptedException {
        VerificationCodePage verificationCodePage = new VerificationCodePage(driver);

        //Don't provide Code

        // Click Verify
        Thread.sleep(1000);
        verificationCodePage.clickVerifyButton();

        Thread.sleep(1000);

        // Verify error message
        String errorMessage = verificationCodePage.getErrorMessageEmptyCode();
        Assert.assertEquals(errorMessage, "code is a required field", "Test case failed: Error message did not match expected value.");

        System.out.println("Test case Pass: Correct error message is displayed.");
    }
}
