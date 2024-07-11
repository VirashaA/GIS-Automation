package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor to initialize the WebDriver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for up to 10 seconds
    }

    // Locators for email, password, and login button
    By emailField = By.name("email");
    By passwordField = By.name("password");
    By loginButton = By.xpath("//button[@type='submit']");
    By errorMessageIncorrectLogin = By.xpath("//div[@class='absolute top-5 text-center text-sm text-red-500']");
    By errorMessageEmptyEmail = By.xpath("//*[@id=\"headlessui-tabs-panel-:r2:\"]/div/form/div/span");
    By errorMessageInvalidEmail = By.xpath("//*[@id=\"headlessui-tabs-panel-:r2:\"]/div/form/div/span");
    By rememberMeField = By.xpath("//input[@type='checkbox']");
    By forgotPasswordLink = By.xpath("//a[@class='text-sm underline font-medium']");

    // Method to enter email
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    // Method to clear email field
    public void clearEmail() {
        driver.findElement(emailField).clear();
    }

    // Method to enter password
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Method to click on the login button
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Method to check if the login button is enabled
    public boolean isLoginButtonEnabled() {
        WebElement loginBtn = driver.findElement(loginButton);
        return loginBtn.isEnabled();
    }

    // Method to check if the "Remember Me" checkbox is selected by default
    public boolean isRememberMeChecked() {
        WebElement rememberMeCheckbox = driver.findElement(rememberMeField);
        return rememberMeCheckbox.isSelected();
    }

    // Method to get error message text for incorrect email
    public String getErrorMessageIncorrectEmail() {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageIncorrectLogin));
        return errorElement.getText();
    }

    // Method to get error message text for incorrect Password
    public String getErrorMessageIncorrectPassword() {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageIncorrectLogin));
        return errorElement.getText();
    }

    // Method to get error message text for both incorrect email and password
    public String getErrorMessageIncorrectLogin() {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageIncorrectLogin));
        return errorElement.getText();
    }

    // Method to get error message text after clearing the email field
    public String getErrorMessageEmptyEmail() {
        WebElement errorEmailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageEmptyEmail));
        return errorEmailElement.getText();
    }

    // Method to get error message text for invalid format email
    public String geterrorMessageInvalidEmail() {
        WebElement errorElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageInvalidEmail));
        return errorElement1.getText();
    }

    // Method to click on the "Forgot Password" link
    public void clickForgotPasswordLink() {
        driver.findElement(forgotPasswordLink).click();
    }

}
