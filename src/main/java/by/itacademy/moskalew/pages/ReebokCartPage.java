package by.itacademy.moskalew.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReebokCartPage {
    private String linkWomen = "//a[@class='menu-item-containter--1orXf ' and @title='WOMEN']";
    private String linkShoes = "//a[@href='/p/100074779/nano-x4-women-s-training-shoes' and @style]";
    private String buttonSize = "//*[@id=\"productInfoPanel\"]/div[7]/div[1]/div[7]/span";
    private String buttonAddToCart = "//button[@class='btn--1eE4Z theme-rr-navy--3ttBH size-large--3vbcz product-wrapper-info-add-to-cart-btn--3f9Dj']";
    private String buttonViewCart = "//button[@class='btn--1eE4Z theme-rr-navy--3ttBH size-medium--2Wvri mini-cart-body-summary-btn-cart--1rEBK']";
    private String messageShoesInCart = "//h6[@class='tag_h6_title--EqL5x  cart-item-info-name--2Y01F']";
    private String headerCart = "//h1[@class='tag_h1_sm--2PQTc']";
    private String headerWomen = "//h1[@class='tag_h1_w--3KHZV  category-title--rXaZj']";
    private String headerShoesIsSelected = "//h1[@class='tag_h1_light--2sTWu  product-wrapper-title--1ky4m']";
    private String headerAddToCart = "//header[@class='tag_header--fSonA  mini-cart-body-product-title--29_H7']";
    private String url = "https://www.reebok.com";
    private WebDriver driver;

    public By getHeaderCart() {
        return By.xpath(headerCart);
    }

    public By getHeaderWomen() {
        return By.xpath(headerWomen);
    }

    public By getHeaderShoesIsSelected() {
        return By.xpath(headerShoesIsSelected);
    }

    public By getHeaderAddToCart() {
        return By.xpath(headerAddToCart);
    }

    public void clickLinkWomen() {
        driver.findElement(By.xpath(linkWomen)).click();
    }

    public void clickLinkShoes() {
        driver.findElement(By.xpath(linkShoes)).click();
    }
    public void clickButtonSize() {
        driver.findElement(By.xpath(buttonSize)).click();
    }

    public void clickButtonAddToCart() {
        driver.findElement(By.xpath(buttonAddToCart)).click();
    }

    public void clickButtonViewCart() {
        driver.findElement(By.xpath(buttonViewCart)).click();
    }

    public String getTextMessageShoesInCart() {
        return driver.findElement(By.xpath(messageShoesInCart)).getText();
    }

}
