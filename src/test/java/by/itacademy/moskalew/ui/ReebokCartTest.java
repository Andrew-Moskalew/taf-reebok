package by.itacademy.moskalew.ui;

import by.itacademy.moskalew.pages.ReebokCartPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReebokCartTest extends BaseTest {
    ReebokCartPage reebokCartPage;
    private static final Logger logger = LogManager.getLogger();

    @BeforeEach
    public void testStart() {
        reebokCartPage = new ReebokCartPage();
    }

    @Test
    public void testReebokEmptyCart() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        reebokCartPage.clickButtonCart();
        Assertions.assertEquals("YOUR CART IS EMPTY", reebokCartPage.getTextHeaderEmptyCart());
        logger.info("Test passed \n");
    }

    @Test
    public void testReebokGetItemToCart() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        reebokCartPage.addItemToCart();
        Assertions.assertEquals("Club C 85 Vintage Shoes", reebokCartPage.getTextMessageShoesInCart());
        logger.info("Test passed \n");
    }

    @Test
    public void testReebokRemoveItemFromCart() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        reebokCartPage.addItemToCart();
        reebokCartPage.clickButtonRemoveFromCart();
        Assertions.assertEquals("YOUR CART IS EMPTY", reebokCartPage.getTextHeaderEmptyCart());
        logger.info("Test passed \n");
    }

}
