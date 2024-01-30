package by.itacademy.moskalew.ui;

import by.itacademy.moskalew.pages.ReebokSearchPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

public class ReebokSearchTest extends BaseTest {

    private static final String SEARCH_REQUEST = "Nano X4 Training Shoes";
    private static final String SEARCH_RESPONSE_NAME_OF_ITEM = "”NANO X4 TRAINING SHOES”";
    private static final int SEARCH_RESPONSE_NUMBER_OF_ITEMS = 12;
    ReebokSearchPage reebokSearchPage;
    private static final Logger logger = LogManager.getLogger();

    @BeforeEach
    public void testStart() {
        reebokSearchPage = new ReebokSearchPage();
    }

    @Test
    public void testSearch() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        reebokSearchPage.sendKeysInputSearch(SEARCH_REQUEST);
        reebokSearchPage.clickButtonSearch();
        String expectedResult = SEARCH_RESPONSE_NAME_OF_ITEM;
        logger.info("Expected search request is: " + expectedResult);
        Assertions.assertEquals(expectedResult, reebokSearchPage.getTextSearchResult());
        logger.info("Test passed \n");
    }

    @Test
    public void testSearchItemsList() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        reebokSearchPage.sendKeysInputSearch(SEARCH_REQUEST);
        reebokSearchPage.clickButtonSearch();
        int expectedResult = SEARCH_RESPONSE_NUMBER_OF_ITEMS;
        logger.info("Expected number of founded objects is: " + expectedResult);
        Assertions.assertEquals(expectedResult, reebokSearchPage.getNumberOfProductCards());
        logger.info("Test passed \n");
    }

    @Test
    public void testSearchItemsListCompare() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        reebokSearchPage.sendKeysInputSearch(SEARCH_REQUEST);
        reebokSearchPage.clickButtonSearch();
        Set<String> expectedSearchItemsSet = new TreeSet<>();
        expectedSearchItemsSet.add("Nano X4 Training Shoes");
        expectedSearchItemsSet.add("Nano X4 Women'S Training Shoes");
        logger.info("Expected set of items is: " + expectedSearchItemsSet);
        Assertions.assertEquals(expectedSearchItemsSet, reebokSearchPage.getActualSearchItemList());
        logger.info("Test passed \n");
    }

}
