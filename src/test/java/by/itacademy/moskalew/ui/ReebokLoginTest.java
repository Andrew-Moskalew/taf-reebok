package by.itacademy.moskalew.ui;

import by.itacademy.moskalew.domain.RandomUserData;
import by.itacademy.moskalew.driver.MyDriver;
import by.itacademy.moskalew.pages.ReebokLoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ReebokLoginTest {

    ReebokLoginPage reebokLoginPage;

    @BeforeEach
    public void testStart() {
        reebokLoginPage = new ReebokLoginPage();
        MyDriver.getDriver().get(reebokLoginPage.getUrl());
        reebokLoginPage.openLoginForm();
    }

    @AfterEach
    public void testFinish() {
        MyDriver.quitDriver();
    }

    @Test
    public void testReebokComEmptyEmail() {
        reebokLoginPage.clickInputEmail();
        reebokLoginPage.clickInputPassword();
        Assertions.assertEquals("Please enter your email", reebokLoginPage.getTextErrorMessageEmail());
    }

    @Test
    public void testReebokComEmptyPassword() {
        reebokLoginPage.clickInputPassword();
        reebokLoginPage.clickInputEmail();
        Assertions.assertEquals("Please enter your password", reebokLoginPage.getTextErrorMessagePassword());
    }

    @Test
    public void testReebokComValidValues() {
        reebokLoginPage.fillLoginFormAndClickSubmit(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomValidPassword());
        Assertions.assertEquals("Incorrect email/password – please check and retry", reebokLoginPage.getTextErrorMessageLoginForm());
    }

    @Test
    public void testReebokComInvalidEmail() {
        reebokLoginPage.sendKeysInputEmail(RandomUserData.getRandomInvalidEmail());
        reebokLoginPage.clickInputPassword();
        Assertions.assertEquals("Please enter email in valid format", reebokLoginPage.getTextErrorMessageEmail());
    }

    @Test
    public void testReebokComInvalidPasswordWithoutUpperCaseChars() {
        reebokLoginPage.sendKeysInputPassword(RandomUserData.getRandomPasswordWithoutUpperCaseChars());
        reebokLoginPage.clickInputEmail();
        Assertions.assertEquals("Please enter password in valid format", reebokLoginPage.getTextErrorMessagePassword());
    }

    @Test
    public void testReebokComInvalidPasswordWithoutLowerCaseChars() {
        reebokLoginPage.sendKeysInputPassword(RandomUserData.getRandomPasswordWithoutLowerCaseChars());
        reebokLoginPage.clickInputEmail();
        Assertions.assertEquals("Please enter password in valid format", reebokLoginPage.getTextErrorMessagePassword());
    }

    @Test
    public void testReebokComInvalidPasswordWithoutDigits() {
        reebokLoginPage.sendKeysInputPassword(RandomUserData.getRandomPasswordWithoutDigits());
        reebokLoginPage.clickInputEmail();
        Assertions.assertEquals("Please enter password in valid format", reebokLoginPage.getTextErrorMessagePassword());
    }

    @Test
    public void testReebokComInvalidPasswordWithoutSplChars() {
        reebokLoginPage.sendKeysInputPassword(RandomUserData.getRandomPasswordWithoutSplChars());
        reebokLoginPage.clickInputEmail();
        Assertions.assertEquals("Please enter password in valid format", reebokLoginPage.getTextErrorMessagePassword());
    }

    @Test
    public void testReebokComInvalidLengthPassword() {
        reebokLoginPage.sendKeysInputPassword(RandomUserData.getRandomInvalidLengthPassword());
        reebokLoginPage.clickInputEmail();
        Assertions.assertEquals("Please enter password in valid format", reebokLoginPage.getTextErrorMessagePassword());
    }

}
