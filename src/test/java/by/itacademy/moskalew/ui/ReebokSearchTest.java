package by.itacademy.moskalew.ui;

import by.itacademy.moskalew.driver.MyDriver;
import by.itacademy.moskalew.pages.ReebokSearchPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ReebokSearchTest {
    ReebokSearchPage reebokSearchPage;

    @BeforeEach
    public void testStart() {
        MyDriver.getDriver().get("https://www.reebok.com");
        reebokSearchPage = new ReebokSearchPage();
    }

    @AfterEach
    public void testFinish() {
        MyDriver.quitDriver();
    }

    @Test
    public void testSearch() throws InterruptedException {
        reebokSearchPage.sendKeysInputSearch("fury 95 shoes");
        Thread.sleep(1000);
        reebokSearchPage.clickButtonSearch();
        Thread.sleep(3000);
        Assertions.assertEquals("”FURY 95 SHOES”", reebokSearchPage.getTextSearchResult());
    }

    @Test
    public void testSearchItemsList() throws InterruptedException {
        reebokSearchPage.sendKeysInputSearch("fury 95 shoes");
        Thread.sleep(1000);
        reebokSearchPage.clickButtonSearch();
        Thread.sleep(3000);
        List<WebElement> searchItems = reebokSearchPage.getProductCards();
        Assertions.assertEquals(3, searchItems.size());
    }

    @Test
    public void testSearchItemsListCompare() throws InterruptedException {
        reebokSearchPage.sendKeysInputSearch("fury 95 shoes");
        Thread.sleep(1000);
        reebokSearchPage.clickButtonSearch();
        Thread.sleep(3000);
        List<WebElement> searchItems = reebokSearchPage.getProductCards();
        List<String> searchItemsString = new ArrayList<>();
        for (WebElement searchItem : searchItems) {
            searchItemsString.add(searchItem.getText());
        }
        List<String> expectedSearchItemsList = new ArrayList<>();
        expectedSearchItemsList.add("Happy99 Instapump Fury 95 Shoes");
        expectedSearchItemsList.add("Happy99 Instapump Fury 95 Shoes");
        expectedSearchItemsList.add("Harry Potter Voldemort Instapump Fury 95 Shoes");
        Assertions.assertEquals(expectedSearchItemsList, searchItemsString);
    }

}
