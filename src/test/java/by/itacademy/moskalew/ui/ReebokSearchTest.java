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
        reebokSearchPage = new ReebokSearchPage();
        MyDriver.getDriver().get(reebokSearchPage.getUrl());
    }

    @AfterEach
    public void testFinish() {
        MyDriver.quitDriver();
    }

    @Test
    public void testSearch() {
        reebokSearchPage.sendKeysInputSearch("fury 95 shoes");
        reebokSearchPage.clickButtonSearch();
        Assertions.assertEquals("”FURY 95 SHOES”", reebokSearchPage.getTextSearchResult());
    }

    @Test
    public void testSearchItemsList() {
        reebokSearchPage.sendKeysInputSearch("fury 95 shoes");
        reebokSearchPage.clickButtonSearch();
        List<WebElement> searchItems = reebokSearchPage.getProductCards();
        Assertions.assertEquals(3, searchItems.size());
    }

    @Test
    public void testSearchItemsListCompare() {
        reebokSearchPage.sendKeysInputSearch("fury 95 shoes");
        reebokSearchPage.clickButtonSearch();
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
