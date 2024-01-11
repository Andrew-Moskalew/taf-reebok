package by.itacademy.moskalew.ui;

import by.itacademy.moskalew.domain.RandomUserData;
import by.itacademy.moskalew.driver.MyDriver;
import by.itacademy.moskalew.pages.ReebokLoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ReebokLoginTest {

    ReebokLoginPage reebokLoginPage;

    @BeforeEach
    public void testStart() {
        reebokLoginPage = new ReebokLoginPage();
        MyDriver.getDriver().get(reebokLoginPage.getUrl());
    }

    @AfterEach
    public void testFinish() {
        MyDriver.quitDriver();
    }

    @Test
    public void testReebokComEmptyEmail() {
        reebokLoginPage.clickButtonAccount();
        new WebDriverWait(MyDriver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(reebokLoginPage.getHeaderLogin()));
        reebokLoginPage.clickInputEmail();
        reebokLoginPage.clickInputPassword();
        Assertions.assertEquals("Please enter your email", reebokLoginPage.getTextErrorMessageEmail());
    }

    @Test
    public void testReebokComEmptyPassword() {
        reebokLoginPage.clickButtonAccount();
        new WebDriverWait(MyDriver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(reebokLoginPage.getHeaderLogin()));
        reebokLoginPage.clickInputPassword();
        reebokLoginPage.clickInputEmail();
        Assertions.assertEquals("Please enter your password", reebokLoginPage.getTextErrorMessagePassword());
    }

    @Test
    public void testReebokComInvalidEmail() {
        reebokLoginPage.clickButtonAccount();
        new WebDriverWait(MyDriver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(reebokLoginPage.getHeaderLogin()));
        reebokLoginPage.sendKeysInputEmail(RandomUserData.getRandomInvalidEmail());
        reebokLoginPage.clickInputPassword();
        Assertions.assertEquals("Please enter email in valid format", reebokLoginPage.getTextErrorMessageEmail());
    }

    @Test
    public void testReebokComInvalidPasswordWithoutDigits() {
        reebokLoginPage.clickButtonAccount();
        new WebDriverWait(MyDriver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(reebokLoginPage.getHeaderLogin()));
        reebokLoginPage.sendKeysInputPassword(RandomUserData.getRandomPasswordWithoutDigits());
        reebokLoginPage.clickInputEmail();
        Assertions.assertEquals("Please enter password in valid format", reebokLoginPage.getTextErrorMessagePassword());
    }

    @Test
    public void testReebokComInvalidPasswordWithoutSplChars() {
        reebokLoginPage.clickButtonAccount();
        new WebDriverWait(MyDriver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(reebokLoginPage.getHeaderLogin()));
        reebokLoginPage.sendKeysInputPassword(RandomUserData.getRandomPasswordWithoutSplChars());
        reebokLoginPage.clickInputEmail();
        Assertions.assertEquals("Please enter password in valid format", reebokLoginPage.getTextErrorMessagePassword());
    }

    @Test
    public void testReebokComInvalidPasswordWithoutLowerCaseChars() {
        reebokLoginPage.clickButtonAccount();
        new WebDriverWait(MyDriver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(reebokLoginPage.getHeaderLogin()));
        reebokLoginPage.sendKeysInputPassword(RandomUserData.getRandomPasswordWithoutLowerCaseChars());
        reebokLoginPage.clickInputEmail();
        Assertions.assertEquals("Please enter password in valid format", reebokLoginPage.getTextErrorMessagePassword());
    }

    @Test
    public void testReebokComInvalidPasswordWithoutUpperCaseChars() {
        reebokLoginPage.clickButtonAccount();
        new WebDriverWait(MyDriver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(reebokLoginPage.getHeaderLogin()));
        reebokLoginPage.sendKeysInputPassword(RandomUserData.getRandomPasswordWithoutUpperCaseChars());
        reebokLoginPage.clickInputEmail();
        Assertions.assertEquals("Please enter password in valid format", reebokLoginPage.getTextErrorMessagePassword());
    }

    @Test
    public void testReebokComInvalidLengthPassword() {
        reebokLoginPage.clickButtonAccount();
        new WebDriverWait(MyDriver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(reebokLoginPage.getHeaderLogin()));
        reebokLoginPage.sendKeysInputPassword(RandomUserData.getRandomInvalidLengthPassword());
        reebokLoginPage.clickInputEmail();
        Assertions.assertEquals("Please enter password in valid format", reebokLoginPage.getTextErrorMessagePassword());
    }

    @Test
    public void testReebokComValidValues() {
        reebokLoginPage.clickButtonAccount();
        new WebDriverWait(MyDriver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(reebokLoginPage.getHeaderLogin()));
        reebokLoginPage.sendKeysInputEmail(RandomUserData.getRandomValidEmail());
        reebokLoginPage.sendKeysInputPassword(RandomUserData.getRandomValidPassword());
        reebokLoginPage.clickButtonLogin();
        new WebDriverWait(MyDriver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(reebokLoginPage.getErrorMessageloginForm()));
        Assertions.assertEquals("Incorrect email/password – please check and retry", reebokLoginPage.getTextErrorMessageLoginForm());
    }

}