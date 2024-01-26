package by.itacademy.moskalew.pages;

import by.itacademy.moskalew.driver.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ReebokSearchPage {
    private String inputSearch = "//input[@class='textbox-input--jX6cr  textbox-input-toggle-off--On9N3' and @placeholder='Search']";
    private String buttonSearch = "//*[name()='svg' and @class='icon--RZbKK icon-link--seVu2  ' and @aria-hidden='true' and @width='24']";
    private String buttonResetSearch = "//*[name()='svg' and @class='icon--RZbKK icon-link--seVu2  ' and @width='14']";
    private String searchResult = "//h1[@class='tag_h1_w--3KHZV  category-title--rXaZj']";
    private String headerSearchResult = "//h6[@class='tag_h6_small--1VdSQ' and text()='Your Search results for:']";
    private String searchProductCardName = "//p[@class='tag_p--1xo5V  product-card-name--9ffy7']";
    private String url = "https://www.reebok.com";
    private WebDriver driver;

    public By getButtonResetSearch() {
        return By.xpath(buttonResetSearch);
    }

    public By getHeaderSearchResult() {
        return By.xpath(headerSearchResult);
    }

    public ReebokSearchPage() {
        this.driver = MyDriver.getDriver();
    }

    public void clickButtonSearch() {
        new WebDriverWait(MyDriver.getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(getButtonResetSearch()));
        driver.findElement(By.xpath(buttonSearch)).click();
        new WebDriverWait(MyDriver.getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(getHeaderSearchResult()));
    }

    public void sendKeysInputSearch(String search) {
        driver.findElement(By.xpath(inputSearch)).sendKeys(search);
    }

    public String getUrl() {
        return url;
    }

    public String getTextSearchResult() {
        return driver.findElement(By.xpath(searchResult)).getText();
    }

    public List<WebElement> getProductCards() {
        return driver.findElements(By.xpath(searchProductCardName));
    }

}
