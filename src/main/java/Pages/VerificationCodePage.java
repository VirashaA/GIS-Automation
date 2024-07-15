package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VerificationCodePage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor to initialize the WebDriver
    public VerificationCodePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for up to 10 seconds
    }

    // Locators
    By codeField = By.name("code");
    By verifyButton = By.xpath("//button[contains(text(),'Verify')]");
    By errorMessageEmptyCode = By.xpath("//span[contains(text(),'code is a required field')]");

    // Method to enter code
    public void enterCode(String code) {
        WebElement codeInput = driver.findElement(codeField);
        codeInput.clear();
        codeInput.sendKeys(code);
    }

    // Method to click on the verify button
    public void clickVerifyButton() {
        WebElement verifyBtn = wait.until(ExpectedConditions.elementToBeClickable(verifyButton));
        verifyBtn.click();
    }

    // Method to get error message text for empty code
    public String getErrorMessageEmptyCode() {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageEmptyCode));
        return errorElement.getText();
    }
}
