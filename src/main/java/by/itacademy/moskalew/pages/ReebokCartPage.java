package by.itacademy.moskalew.pages;

import by.itacademy.moskalew.driver.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReebokCartPage {
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
    private String headerWomen = "//h1[@class='tag_h1_w--3KHZV  category-title--rXaZj']";
    private String headerAddToCart = "//header[@class='tag_header--fSonA  mini-cart-body-product-title--29_H7']";
    private String headerSignUp = "//h3[@class='tag_h3_wb--3Xjf-']";
    private String url = "https://www.reebok.com";
    private WebDriver driver;

    public ReebokCartPage() {
        this.driver = MyDriver.getDriver();
    }

    public String getUrl() {
        return url;
    }

    public By getHeaderCart() {
        return By.xpath(headerCart);
    }

    public By getHeaderEmptyCart() {
        return By.xpath(headerEmptyCart);
    }

    public By getHeaderWomen() {
        return By.xpath(headerWomen);
    }

    public By getSelectorShoesSizes() {
        return By.xpath(buttonAddToCart);
    }

    public By getHeaderAddToCart() {
        return By.xpath(headerAddToCart);
    }

    public By getHeaderSignUp() {
        return By.xpath(headerSignUp);
    }

    public void clickLinkWomen() {
        driver.findElement(By.xpath(linkWomen)).click();
        new WebDriverWait(MyDriver.getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(getHeaderWomen()));
    }

    public void clickLinkShoes() {
        driver.findElement(By.xpath(linkShoes)).click();
    }

    public void clickButtonSize() {
        new WebDriverWait(MyDriver.getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(getSelectorShoesSizes()));
        driver.findElement(By.xpath(buttonSize)).click();
        new WebDriverWait(MyDriver.getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(getHeaderSignUp()));
    }

    public void clickButtonAddToCart() {
        driver.findElement(By.xpath(buttonAddToCart)).click();
        new WebDriverWait(MyDriver.getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(getHeaderAddToCart()));
    }

    public void clickButtonViewCart() {
        driver.findElement(By.xpath(buttonViewCart)).click();
        new WebDriverWait(MyDriver.getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(getHeaderCart()));
    }

    public void clickButtonCart() {
        driver.findElement(By.xpath(buttonCart)).click();
    }

    public void clickButtonRemoveFromCart() {
        driver.findElement(By.xpath(buttonRemoveFromCart)).click();
        new WebDriverWait(MyDriver.getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(getHeaderEmptyCart()));
    }

    public String getTextMessageShoesInCart() {
        return driver.findElement(By.xpath(messageShoesInCart)).getText();
    }

    public String getTextHeaderEmptyCart() {
        new WebDriverWait(MyDriver.getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(getHeaderEmptyCart()));
        return driver.findElement(By.xpath(headerEmptyCart)).getText();
    }

    public void addItemToCart() {
        clickLinkWomen();
        clickLinkShoes();
        clickButtonSize();
        clickButtonAddToCart();
        clickButtonViewCart();
    }

}
