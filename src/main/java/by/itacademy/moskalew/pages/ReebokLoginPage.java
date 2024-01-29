package by.itacademy.moskalew.pages;

import by.itacademy.moskalew.driver.SingletonWebDriver;
import by.itacademy.moskalew.utils.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReebokLoginPage extends BasePage {
    private String buttonAccount = "//*[name()='svg' and @class='icon--RZbKK icon-link--seVu2  profile-icon--r3f5X']";
    private String buttonLogin = "//button[@class='btn--1eE4Z theme-rr-navy--3ttBH size-small--1XFhu checkout-details-reviewbutton--gQTO4']";
    private String inputEmail = "//input[@class='textbox-input--jX6cr' and @name='email']";
    private String inputPassword = "//input[@class='textbox-input--jX6cr' and @name='password']";
    private String errorMessageEmail = "//p[@class='tag_p--1xo5V theme-error--3VYhx address-form-email--3xtdp']";
    private String errorMessagePassword = "//p[@class='tag_p--1xo5V theme-error--3VYhx address-form-password--2OqFT']";
    private String errorMessageLoginForm = "//span[@class='registerForm-LoginError--1mbUB']";
    private String headerLogin = "//h1[@class='tag_h1_sm--2PQTc  registerForm-title--2CADy' and text()='Log In']";

    public ReebokLoginPage() {
        this.driver = SingletonWebDriver.getDriver();
    }

    public void clickButtonAccount() {
        driver.findElement(By.xpath(buttonAccount)).click();
    }

    public void clickInputEmail() {
        driver.findElement(By.xpath(inputEmail)).click();
    }

    public void clickInputPassword() {
        driver.findElement(By.xpath(inputPassword)).click();
    }

    public void clickButtonLogin() {
        driver.findElement(By.xpath(buttonLogin)).click();
    }

    public void sendKeysInputEmail(String email) {
        driver.findElement(By.xpath(inputEmail)).sendKeys(email);
    }

    public void sendKeysInputPassword(String password) {
        driver.findElement(By.xpath(inputPassword)).sendKeys(password);
    }

    public String getTextErrorMessageEmail() {
        return driver.findElement(By.xpath(errorMessageEmail)).getText();
    }

    public String getTextErrorMessagePassword() {
        return driver.findElement(By.xpath(errorMessagePassword)).getText();
    }

    public String getTextErrorMessageLoginForm() {
        Waiter.wait(errorMessageLoginForm);
        return driver.findElement(By.xpath(errorMessageLoginForm)).getText();
    }

    public void fillLoginFormAndClickSubmit(String email, String password) {
        sendKeysInputEmail(email);
        sendKeysInputPassword(password);
        clickButtonLogin();
    }

    public void openLoginForm() {
        clickButtonAccount();
        Waiter.wait(headerLogin);
    }
}
