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
    }
    @AfterEach
    public void testFinish() {
        driver.quit();
    }
    @Test
    public void testReebokComEmptyEmail() throws InterruptedException {
        reebokPage = new ReebokPage(driver);
        reebokPage.clickButtonLogin();
        Thread.sleep(2000);
        reebokPage.clickInputEmail();
        reebokPage.clickInputPassword();
        Assertions.assertEquals( "Please enter your email", reebokPage.getTextErrorMassageEmail());
    }
}
