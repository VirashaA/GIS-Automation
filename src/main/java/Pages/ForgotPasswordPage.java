package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPasswordPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor to initialize the WebDriver
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for up to 10 seconds
    }

    // Locators
    By forgotPasswordLink = By.xpath("//a[@class='text-sm underline font-medium']");
    By emailField = By.name("email");
    By sendCodeButton = By.xpath("//button[@type='submit']");
    By errorMessageEmptyEmail = By.xpath("//span[contains(text(),'email is a required field')]");
    By errorMessageInvalidEmail = By.xpath("//span[contains(text(),'email must be a valid email')]");
    By errorMessageIncorrectEmail = By.xpath("//div[@class='absolute top-20 text-sm text-red-500']");
    By reSendCodeButton = By.xpath("//span[normalize-space()='Re-send Code']");

    // Method to click on the "Forgot Password" link
    public void clickForgotPasswordLink() {
        driver.findElement(forgotPasswordLink).click();
    }

    // Method to enter email
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    // Method to clear the email field
    public void clearEmailField() {
        driver.findElement(emailField).clear();
    }

    // Method to click on the send code button
    public void clickSendCodeButton() {
        driver.findElement(sendCodeButton).click();
    }

    // Method to click on the re-send code button
    public void clickReSendCodeButton() {
        WebElement reSendButton = wait.until(ExpectedConditions.elementToBeClickable(reSendCodeButton));
        reSendButton.click();
    }

    // Method to get error message text for empty email
    public String getErrorMessageEmptyEmail() {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageEmptyEmail));
        return errorElement.getText();
    }

    // Method to get error message text for invalid email
    public String getErrorMessageInvalidEmail() {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageInvalidEmail));
        return errorElement.getText();
    }

    // Method to get error message text for incorrect email
    public String getErrorMessageIncorrectEmail() {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageIncorrectEmail));
        return errorElement.getText();
    }

    // Method to check if the send code button is visible
    public boolean isSendCodeButtonVisible() {
        try {
            WebElement sendButton = wait.until(ExpectedConditions.visibilityOfElementLocated(sendCodeButton));
            return sendButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to check if the re-send code button is visible
    public boolean isReSendCodeButtonVisible() {
        try {
            WebElement reSendButton = wait.until(ExpectedConditions.visibilityOfElementLocated(reSendCodeButton));
            return reSendButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


}
