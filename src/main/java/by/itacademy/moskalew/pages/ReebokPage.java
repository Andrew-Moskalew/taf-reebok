package by.itacademy.moskalew.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReebokPage {
    private String buttonLogin = "//*[name()='svg' and @class='icon--RZbKK icon-link--seVu2  profile-icon--r3f5X']";
    private String inputEmail = "//input[@class='textbox-input--jX6cr' and @name='email']";
    private String inputPassword = "//input[@class='textbox-input--jX6cr' and @name='password']";
    private String errorMassageEmail = "//p[@class='tag_p--1xo5V theme-error--3VYhx address-form-email--3xtdp']";
    private String errorMassagePassword = "//p[@class='tag_p--1xo5V theme-error--3VYhx address-form-password--2OqFT']";
    private WebDriver driver;

    public ReebokPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonLogin() {
        driver.findElement(By.xpath(buttonLogin)).click();
    }
    public void clickInputEmail() {
        driver.findElement(By.xpath(inputEmail)).click();
    }

    public void clickInputPassword() {
        driver.findElement(By.xpath(inputPassword)).click();
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

}
