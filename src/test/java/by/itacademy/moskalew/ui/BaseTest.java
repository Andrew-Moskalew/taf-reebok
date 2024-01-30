package by.itacademy.moskalew.ui;

import by.itacademy.moskalew.driver.SingletonWebDriver;
import by.itacademy.moskalew.pages.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    private static final Logger logger = LogManager.getLogger();
    BasePage basePage;

    @BeforeEach
    public void baseTestStart() {
        basePage = new BasePage();
        SingletonWebDriver.getDriver().get(basePage.getUrl());
        logger.info("Home page Reebok.com is opened");
    }

    @AfterEach
    public void testFinish() {
        SingletonWebDriver.quitDriver();
    }

}
