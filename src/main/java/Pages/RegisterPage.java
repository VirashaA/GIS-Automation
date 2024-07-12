package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor to initialize the WebDriver
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for up to 10 seconds
    }

    //Locators
    By registerTab = By.xpath("//button[contains(text(), 'Register')]");
    By firstNameField = By.name("first_name");
    By lastNameField = By.name("last_name");
    By emailField = By.name("email");
    By passwordField = By.name("password");
    By confirmPasswordField = By.name("confirm_password");
    By registerButton = By.xpath("//button[@type='submit']");
    By errorMessageInvalidEmail = By.xpath("//*[@id=\"headlessui-tabs-panel-:r3:\"]/div/form/div/span");
    By errorMessageDuplicateEmail = By.xpath("//*[@id=\"headlessui-tabs-panel-:r3:\"]/div/form/div/div[5]/div");
    By errorMessageDifferentPassword = By.xpath("//*[@id=\"headlessui-tabs-panel-:r3:\"]/div/form/div/span");

    // Method to click on the "Register" tab"
    public void clickRegisterTab() {
        driver.findElement(registerTab).click();
    }

    // Method to enter First Name
    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    // Method to enter Last Name
    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    // Method to enter email
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    // Method to enter password
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Method to enter confirm password
    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    // Method to click on the register button
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    // Method to check if the login button is enabled
    public boolean isRegisterButtonEnabled() {
        WebElement registerBtn = driver.findElement(registerButton);
        return registerBtn.isEnabled();
    }

    // Method to get error message text for invalid format email
    public String geterrorMessageInvalidEmail() {
        WebElement errorElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageInvalidEmail));
        return errorElement1.getText();
    }

    // Method to get error message text for duplicated emails
    public String geterrorMessageDuplicateEmail() {
        WebElement errorElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageDuplicateEmail));
        return errorElement1.getText();
    }

    // Method to get error message text for different passwords
    public String geterrorMessageDifferentPasswords() {
        WebElement errorElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageDifferentPassword));
        return errorElement1.getText();
    }
}
