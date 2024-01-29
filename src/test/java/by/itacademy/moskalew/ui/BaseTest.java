package by.itacademy.moskalew.ui;

import by.itacademy.moskalew.driver.SingletonWebDriver;
import by.itacademy.moskalew.pages.BasePage;
import by.itacademy.moskalew.pages.ReebokCartPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    BasePage basePage;
    @BeforeEach
    public void baseTestStart() {
        basePage = new BasePage();
        SingletonWebDriver.getDriver().get(basePage.getUrl());
    }

    @AfterEach
    public void testFinish() {
        SingletonWebDriver.quitDriver();
    }

}
