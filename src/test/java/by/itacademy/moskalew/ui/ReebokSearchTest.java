package by.itacademy.moskalew.ui;

import by.itacademy.moskalew.driver.MyDriver;
import by.itacademy.moskalew.pages.ReebokSearchPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ReebokSearchTest {
    ReebokSearchPage reebokSearchPage;
    private static final Logger logger = LogManager.getLogger();

    @BeforeEach
    public void testStart() {
        reebokSearchPage = new ReebokSearchPage();
        MyDriver.getDriver().get(reebokSearchPage.getUrl());
    }

    @AfterEach
    public void testFinish() {
        MyDriver.quitDriver();
    }

    @Test
    public void testSearch() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        reebokSearchPage.sendKeysInputSearch("freestyle high women's shoes");
        reebokSearchPage.clickButtonSearch();
        Assertions.assertEquals("”FREESTYLE HIGH WOMEN'S SHOES”", reebokSearchPage.getTextSearchResult());
        logger.info("Test passed \n");
    }

    @Test
    public void testSearchItemsList() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        reebokSearchPage.sendKeysInputSearch("freestyle high women's shoes");
        reebokSearchPage.clickButtonSearch();
        List<WebElement> searchItems = reebokSearchPage.getProductCards();
        Assertions.assertEquals(6, searchItems.size());
        logger.info("Test passed \n");
    }

    @Test
    public void testSearchItemsListCompare() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        reebokSearchPage.sendKeysInputSearch("freestyle high women's shoes");
        reebokSearchPage.clickButtonSearch();
        List<WebElement> searchItems = reebokSearchPage.getProductCards();
        List<String> searchItemsString = new ArrayList<>();
        for (WebElement searchItem : searchItems) {
            searchItemsString.add(searchItem.getText());
        }
        List<String> expectedSearchItemsList = new ArrayList<>();
        expectedSearchItemsList.add("Freestyle Hi Women'S Shoes");
        expectedSearchItemsList.add("Freestyle Hi Women'S Shoes");
        expectedSearchItemsList.add("Freestyle Hi Women'S Shoes");
        expectedSearchItemsList.add("F/S Hi Women'S Shoes");
        expectedSearchItemsList.add("F/S Hi Women'S Shoes");
        expectedSearchItemsList.add("F/S Hi Women'S Shoes");
        Assertions.assertEquals(expectedSearchItemsList, searchItemsString);
        logger.info("Test passed \n");
    }

}
