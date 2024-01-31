package by.itacademy.moskalew.pages;

import by.itacademy.moskalew.driver.SingletonWebDriver;
import by.itacademy.moskalew.utils.Waiter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class ReebokCartPage extends BasePage{
    private String linkWomen = "//a[@class='menu-item-containter--1orXf ' and @title='WOMEN']";
    private String linkShoes = "//a[@href='/p/100007798/club-c-85-vintage-shoes' and @class=' ']";
    private String buttonSize = "//*[@id=\"productInfoPanel\"]/div[7]/div[1]/div[1]";
    private String buttonAddToCart = "//button[@class='btn--1eE4Z theme-rr-navy--3ttBH size-large--3vbcz product-wrapper-info-add-to-cart-btn--3f9Dj']";
    private String buttonViewCart = "//button[@class='btn--1eE4Z theme-rr-navy--3ttBH size-medium--2Wvri mini-cart-body-summary-btn-cart--1rEBK']";
    private String buttonRemoveFromCart = "//*[name()='svg' and @width='14']";
    private String messageShoesInCart = "//h6[@class='tag_h6_title--EqL5x  cart-item-info-name--2Y01F']";
    private String buttonCart = "//*[name()='svg' and @viewBox='0 0 122 100']";
    private String headerCart = "//h1[@class='tag_h1_sm--2PQTc']";
    private String headerEmptyCart = "//h1[@class='tag_h1_sm--2PQTc  cart-content--2qjcd']";
    private String headerWomen = "//h1[@class='tag_h1_w--3KHZV  catList-title--h96hG']";
    private String headerAddToCart = "//header[@class='tag_header--fSonA  mini-cart-body-product-title--29_H7']";
    private static final Logger logger = LogManager.getLogger();

    public ReebokCartPage() {
        this.driver = SingletonWebDriver.getDriver();
    }

    public void clickLinkWomen() {
        driver.findElement(By.xpath(linkWomen)).click();
        Waiter.wait(headerWomen);
        logger.info("Click on \"Women\" link");
    }

    public void clickLinkShoes() {
        driver.findElement(By.xpath(linkShoes)).click();
        Waiter.wait(buttonAddToCart);
        logger.info("Click on item card");
    }

    public void clickButtonSize() {
        driver.findElement(By.xpath(buttonSize)).click();
        logger.info("Click on size button");
    }

    public void clickButtonAddToCart() {
        driver.findElement(By.xpath(buttonAddToCart)).click();
        Waiter.wait(headerAddToCart);
        logger.info("Click on button \"Add to Cart\"");
    }

    public void clickButtonViewCart() {
        driver.findElement(By.xpath(buttonViewCart)).click();
        Waiter.wait(headerCart);
        logger.info("Click on button \"View cart\"");
    }

    public void clickButtonCart() {
        driver.findElement(By.xpath(buttonCart)).click();
        logger.info("Click on Cart button");
    }

    public void clickButtonRemoveFromCart() {
        driver.findElement(By.xpath(buttonRemoveFromCart)).click();
        logger.info("Click on button remove from cart");
    }

    public String getTextMessageShoesInCart() {
        String actualResult = driver.findElement(By.xpath(messageShoesInCart)).getText();
        logger.info("Actual Header is: " + actualResult);
        return actualResult;
    }

    public String getTextHeaderEmptyCart() {
        Waiter.wait(headerEmptyCart);
        String actualResult = driver.findElement(By.xpath(headerEmptyCart)).getText();
        logger.info("Actual Header is: " + actualResult);
        return actualResult;
    }

    public void addItemToCart() {
        clickLinkWomen();
        clickLinkShoes();
        clickButtonSize();
        clickButtonAddToCart();
        clickButtonViewCart();
    }

}
