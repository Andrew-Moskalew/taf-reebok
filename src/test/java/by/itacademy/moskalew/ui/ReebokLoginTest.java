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
        MyDriver.getDriver().get("https://www.reebok.com");
        reebokLoginPage = new ReebokLoginPage();
    }

    @AfterEach
    public void testFinish() {
        MyDriver.quitDriver();
    }

    @Test
    public void testReebokComEmptyEmail() throws InterruptedException {
        reebokLoginPage.clickButtonAccount();
        Thread.sleep(2000);
        reebokLoginPage.clickInputEmail();
        reebokLoginPage.clickInputPassword();
        Assertions.assertEquals("Please enter your email", reebokLoginPage.getTextErrorMassageEmail());
    }

    @Test
    public void testReebokComEmptyPassword() throws InterruptedException {
        reebokLoginPage.clickButtonAccount();
        Thread.sleep(2000);
        reebokLoginPage.clickInputPassword();
        reebokLoginPage.clickInputEmail();
        Assertions.assertEquals("Please enter your password", reebokLoginPage.getTextErrorMassagePassword());
    }

    @Test
    public void testReebokComInvalidEmail() throws InterruptedException {
        reebokLoginPage.clickButtonAccount();
        Thread.sleep(2000);
        reebokLoginPage.sendKeysInputEmail(RandomUserData.getRandomInvalidEmail());
        reebokLoginPage.clickInputPassword();
        Assertions.assertEquals("Please enter email in valid format", reebokLoginPage.getTextErrorMassageEmail());
    }

    @Test
    public void testReebokComInvalidPasswordWithoutNumber() throws InterruptedException {
        reebokLoginPage.clickButtonAccount();
        Thread.sleep(2000);
        reebokLoginPage.sendKeysInputPassword("AAaa@@@@");
        reebokLoginPage.clickInputEmail();
        Assertions.assertEquals("Please enter password in valid format", reebokLoginPage.getTextErrorMassagePassword());
    }

    @Test
    public void testReebokComInvalidPasswordWithoutSpecChar() throws InterruptedException {
        reebokLoginPage.clickButtonAccount();
        Thread.sleep(2000);
        reebokLoginPage.sendKeysInputPassword("AAaa1111");
        reebokLoginPage.clickInputEmail();
        Assertions.assertEquals("Please enter password in valid format", reebokLoginPage.getTextErrorMassagePassword());
    }

    @Test
    public void testReebokComInvalidPasswordWithoutLowercaseLetter() throws InterruptedException {
        reebokLoginPage.clickButtonAccount();
        Thread.sleep(2000);
        reebokLoginPage.sendKeysInputPassword("AAAA11@@");
        reebokLoginPage.clickInputEmail();
        Assertions.assertEquals("Please enter password in valid format", reebokLoginPage.getTextErrorMassagePassword());
    }

    @Test
    public void testReebokComInvalidPasswordWithoutUppercaseLetter() throws InterruptedException {
        reebokLoginPage.clickButtonAccount();
        Thread.sleep(2000);
        reebokLoginPage.sendKeysInputPassword("aaaa11@@");
        reebokLoginPage.clickInputEmail();
        Assertions.assertEquals("Please enter password in valid format", reebokLoginPage.getTextErrorMassagePassword());
    }

    @Test
    public void testReebokComInvalidPasswordTooShort() throws InterruptedException {
        reebokLoginPage.clickButtonAccount();
        Thread.sleep(2000);
        reebokLoginPage.sendKeysInputPassword("AAaa11@");
        reebokLoginPage.clickInputEmail();
        Assertions.assertEquals("Please enter password in valid format", reebokLoginPage.getTextErrorMassagePassword());
    }

    @Test
    public void testReebokComValidValues() throws InterruptedException {
        reebokLoginPage.clickButtonAccount();
        Thread.sleep(2000);
        reebokLoginPage.sendKeysInputEmail(RandomUserData.getRandomValidEmail());
        reebokLoginPage.sendKeysInputPassword("AAaa11@@");
        reebokLoginPage.clickButtonLogin();
        Thread.sleep(1000);
        Assertions.assertEquals("Incorrect email/password – please check and retry", reebokLoginPage.getTextErrorMassageLoginForm());
    }

}