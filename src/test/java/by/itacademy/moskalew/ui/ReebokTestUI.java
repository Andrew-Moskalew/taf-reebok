package by.itacademy.moskalew.ui;

import by.itacademy.moskalew.pages.ReebokPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReebokTestUI {
    WebDriver driver;
    ReebokPage reebokPage;

    @BeforeEach
    public void testStart() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.reebok.com");
        reebokPage = new ReebokPage(driver);
    }

    @AfterEach
    public void testFinish() {
        driver.quit();
    }

    @Test
    public void testReebokComEmptyEmail() throws InterruptedException {
        reebokPage.clickButtonAccount();
        Thread.sleep(2000);
        reebokPage.clickInputEmail();
        reebokPage.clickInputPassword();
        Assertions.assertEquals("Please enter your email", reebokPage.getTextErrorMassageEmail());
    }

    @Test
    public void testReebokComEmptyPassword() throws InterruptedException {
        reebokPage.clickButtonAccount();
        Thread.sleep(2000);
        reebokPage.clickInputPassword();
        reebokPage.clickInputEmail();
        Assertions.assertEquals("Please enter your password", reebokPage.getTextErrorMassagePassword());
    }

    @Test
    public void testReebokComInvalidEmail() throws InterruptedException {
        reebokPage.clickButtonAccount();
        Thread.sleep(2000);
        reebokPage.sendKeysInputEmail("Invalid Email");
        reebokPage.clickInputPassword();
        Assertions.assertEquals("Please enter email in valid format", reebokPage.getTextErrorMassageEmail());
    }

    @Test
    public void testReebokComInvalidPasswordWithoutNumber() throws InterruptedException {
        reebokPage.clickButtonAccount();
        Thread.sleep(2000);
        reebokPage.sendKeysInputPassword("AAaa@@@@");
        reebokPage.clickInputEmail();
        Assertions.assertEquals("Please enter password in valid format", reebokPage.getTextErrorMassagePassword());
    }

    @Test
    public void testReebokComInvalidPasswordWithoutSpecChar() throws InterruptedException {
        reebokPage.clickButtonAccount();
        Thread.sleep(2000);
        reebokPage.sendKeysInputPassword("AAaa1111");
        reebokPage.clickInputEmail();
        Assertions.assertEquals("Please enter password in valid format", reebokPage.getTextErrorMassagePassword());
    }

    @Test
    public void testReebokComInvalidPasswordWithoutLowercaseLetter() throws InterruptedException {
        reebokPage.clickButtonAccount();
        Thread.sleep(2000);
        reebokPage.sendKeysInputPassword("AAAA11@@");
        reebokPage.clickInputEmail();
        Assertions.assertEquals("Please enter password in valid format", reebokPage.getTextErrorMassagePassword());
    }

    @Test
    public void testReebokComInvalidPasswordWithoutUppercaseLetter() throws InterruptedException {
        reebokPage.clickButtonAccount();
        Thread.sleep(2000);
        reebokPage.sendKeysInputPassword("aaaa11@@");
        reebokPage.clickInputEmail();
        Assertions.assertEquals("Please enter password in valid format", reebokPage.getTextErrorMassagePassword());
    }

    @Test
    public void testReebokComInvalidPasswordTooShort() throws InterruptedException {
        reebokPage.clickButtonAccount();
        Thread.sleep(2000);
        reebokPage.sendKeysInputPassword("AAaa11@");
        reebokPage.clickInputEmail();
        Assertions.assertEquals("Please enter password in valid format", reebokPage.getTextErrorMassagePassword());
    }

    @Test
    public void testReebokComValidValues() throws InterruptedException {
        reebokPage.clickButtonAccount();
        Thread.sleep(2000);
        reebokPage.sendKeysInputEmail("email@email.com");
        reebokPage.sendKeysInputPassword("AAaa11@@");
        reebokPage.clickButtonLogin();
        Thread.sleep(1000);
        Assertions.assertEquals("Incorrect email/password – please check and retry", reebokPage.getTextErrorMassageLoginForm());
    }

}