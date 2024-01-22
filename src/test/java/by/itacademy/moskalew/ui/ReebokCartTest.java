package by.itacademy.moskalew.ui;

import by.itacademy.moskalew.driver.MyDriver;
import by.itacademy.moskalew.pages.ReebokCartPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReebokCartTest {
    ReebokCartPage reebokCartPage;

    @BeforeEach
    public void testStart() {
        reebokCartPage = new ReebokCartPage();
        MyDriver.getDriver().get(reebokCartPage.getUrl());
    }

    @AfterEach
    public void testFinish() {
        MyDriver.quitDriver();
    }

    @Test
    public void testReebokEmptyCart() {
        reebokCartPage.clickButtonCart();
        Assertions.assertEquals("YOUR CART IS EMPTY", reebokCartPage.getTextHeaderEmptyCart());
    }

    @Test
    public void testGetItemToCart() throws InterruptedException {
        reebokCartPage.addItemToCart();
        Assertions.assertEquals("Club C 85 Vintage Shoes",reebokCartPage.getTextMessageShoesInCart());
    }

    @Test
    public void testRemoveItemFromCart() throws InterruptedException {
        reebokCartPage.addItemToCart();
        reebokCartPage.clickButtonRemoveFromCart();
        Assertions.assertEquals("YOUR CART IS EMPTY", reebokCartPage.getTextHeaderEmptyCart());
    }

}
