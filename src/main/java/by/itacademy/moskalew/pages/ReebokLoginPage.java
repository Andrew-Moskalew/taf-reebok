package by.itacademy.moskalew.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReebokLoginPage {
    private String buttonAccount = "//*[name()='svg' and @class='icon--RZbKK icon-link--seVu2  profile-icon--r3f5X']";
    private String buttonLogin = "//button[@class='btn--1eE4Z theme-rr-navy--3ttBH size-small--1XFhu checkout-details-reviewbutton--gQTO4']";
    private String inputEmail = "//input[@class='textbox-input--jX6cr' and @name='email']";
    private String inputPassword = "//input[@class='textbox-input--jX6cr' and @name='password']";
    private String errorMassageEmail = "//p[@class='tag_p--1xo5V theme-error--3VYhx address-form-email--3xtdp']";
    private String errorMassagePassword = "//p[@class='tag_p--1xo5V theme-error--3VYhx address-form-password--2OqFT']";
    private String errorMassageLoginForm = "//span[@class='registerForm-LoginError--1mbUB']";
    private WebDriver driver;

    public ReebokLoginPage(WebDriver driver) {
        this.driver = driver;
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

    public String getTextErrorMassageEmail() {
        return driver.findElement(By.xpath(errorMassageEmail)).getText();
    }

    public String getTextErrorMassagePassword() {
        return driver.findElement(By.xpath(errorMassagePassword)).getText();
    }

    public String getTextErrorMassageLoginForm() {
        return driver.findElement(By.xpath(errorMassageLoginForm)).getText();
    }

}
