package by.itacademy.moskalew.ui;

import by.itacademy.moskalew.pages.ReebokSearchPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReebokSearchTest extends BaseTest{
    ReebokSearchPage reebokSearchPage;
    private static final Logger logger = LogManager.getLogger();

    @BeforeEach
    public void testStart() {
        reebokSearchPage = new ReebokSearchPage();
    }

    @Test
    public void testSearch() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        reebokSearchPage.sendKeysInputSearch(ReebokSearchPage.SEARCH_REQUEST);
        reebokSearchPage.clickButtonSearch();
        Assertions.assertEquals(ReebokSearchPage.SEARCH_RESPONSE_NAME_OF_ITEM, reebokSearchPage.getTextSearchResult());
        logger.info("Test passed \n");
    }

    @Test
    public void testSearchItemsList() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        reebokSearchPage.sendKeysInputSearch(ReebokSearchPage.SEARCH_REQUEST);
        reebokSearchPage.clickButtonSearch();
        Assertions.assertEquals(ReebokSearchPage.SEARCH_RESPONSE_NUMBER_OF_ITEMS, reebokSearchPage.getProductCards().size());
        logger.info("Test passed \n");
    }

    @Test
    public void testSearchItemsListCompare() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        reebokSearchPage.sendKeysInputSearch(ReebokSearchPage.SEARCH_REQUEST);
        reebokSearchPage.clickButtonSearch();
        Assertions.assertEquals(reebokSearchPage.getExpectedSearchItemsList(),reebokSearchPage.getActualSearchItemList());
        logger.info("Test passed \n");
    }

}
