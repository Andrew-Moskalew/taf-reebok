package by.itacademy.moskalew.pages;

import by.itacademy.moskalew.driver.SingletonWebDriver;
import by.itacademy.moskalew.utils.Waiter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class ReebokLoginPage extends BasePage {
    private String buttonAccount = "//*[name()='svg' and @class='icon--RZbKK icon-link--seVu2  profile-icon--r3f5X']";
    private String buttonLogin = "//button[@class='btn--1eE4Z theme-rr-navy--3ttBH size-small--1XFhu checkout-details-reviewbutton--gQTO4']";
    private String inputEmail = "//input[@class='textbox-input--jX6cr' and @name='email']";
    private String inputPassword = "//input[@class='textbox-input--jX6cr' and @name='password']";
    private String errorMessageEmail = "//p[@class='tag_p--1xo5V theme-error--3VYhx address-form-email--3xtdp']";
    private String errorMessagePassword = "//p[@class='tag_p--1xo5V theme-error--3VYhx address-form-password--2OqFT']";
    private String errorMessageLoginForm = "//span[@class='registerForm-LoginError--1mbUB']";
    private String headerLogin = "//h1[@class='tag_h1_sm--2PQTc  registerForm-title--2CADy' and text()='Log In']";
    private static final Logger logger = LogManager.getLogger();

    public ReebokLoginPage() {
        this.driver = SingletonWebDriver.getDriver();
    }

    public void clickButtonAccount() {
        driver.findElement(By.xpath(buttonAccount)).click();
    }

    public void clickInputEmail() {
        driver.findElement(By.xpath(inputEmail)).click();
        logger.info("Click on Email field");
    }

    public void clickInputPassword() {
        driver.findElement(By.xpath(inputPassword)).click();
        logger.info("Click on Password field");
    }

    public void clickButtonLogin() {
        driver.findElement(By.xpath(buttonLogin)).click();
        logger.info("Click on Login button");
    }

    public void sendKeysInputEmail(String email) {
        driver.findElement(By.xpath(inputEmail)).sendKeys(email);
        logger.info("Entered Email is: " + email);
    }

    public void sendKeysInputPassword(String password) {
        driver.findElement(By.xpath(inputPassword)).sendKeys(password);
        logger.info("Entered Password is: " + password);
    }

    public String getTextErrorMessageEmail() {
        String actualResult = driver.findElement(By.xpath(errorMessageEmail)).getText();
        logger.info("Actual error message is: " + actualResult);
        return actualResult;
    }

    public String getTextErrorMessagePassword() {
        String actualResult = driver.findElement(By.xpath(errorMessagePassword)).getText();
        logger.info("Actual error message is: " + actualResult);
        return actualResult;
    }

    public String getTextErrorMessageLoginForm() {
        Waiter.wait(errorMessageLoginForm);
        String actualResult = driver.findElement(By.xpath(errorMessageLoginForm)).getText();
        logger.info("Actual error message is: " + actualResult);
        return actualResult;
    }

    public void fillLoginFormAndClickSubmit(String email, String password) {
        sendKeysInputEmail(email);
        sendKeysInputPassword(password);
        clickButtonLogin();
    }

    public void openLoginForm() {
        clickButtonAccount();
        Waiter.wait(headerLogin);
        logger.info("Login page is opened");
    }

}
