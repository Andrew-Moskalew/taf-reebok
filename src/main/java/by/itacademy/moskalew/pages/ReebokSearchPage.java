package by.itacademy.moskalew.pages;

import by.itacademy.moskalew.driver.SingletonWebDriver;
import by.itacademy.moskalew.utils.Waiter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ReebokSearchPage extends BasePage {
    private String inputSearch = "//input[@class='textbox-input--jX6cr  textbox-input-toggle-off--On9N3' and @placeholder='Search']";
    private String buttonSearch = "//*[name()='svg' and @class='icon--RZbKK icon-link--seVu2  ' and @aria-hidden='true' and @width='24']";
    private String buttonResetSearch = "//*[name()='svg' and @class='icon--RZbKK icon-link--seVu2  ' and @width='14']";
    private String searchResult = "//h1[@class='tag_h1_w--3KHZV  category-title--rXaZj']";
    private String headerSearchResult = "//h6[@class='tag_h6_small--1VdSQ' and text()='Your Search results for:']";
    private String searchProductCardName = "//p[@class='tag_p--1xo5V  product-card-name--9ffy7']";
    private static final Logger logger = LogManager.getLogger();

    public ReebokSearchPage() {
        this.driver = SingletonWebDriver.getDriver();
    }

    public void clickButtonSearch() {
        driver.findElement(By.xpath(buttonSearch)).click();
        Waiter.wait(headerSearchResult);
        logger.info("Click on Search button");
    }

    public void sendKeysInputSearch(String searchRequest) {
        driver.findElement(By.xpath(inputSearch)).sendKeys(searchRequest);
        Waiter.wait(buttonResetSearch);
        logger.info("Search request has been entered: " + searchRequest);
    }

    public String getTextSearchResult() {
        String actualResult = driver.findElement(By.xpath(searchResult)).getText();
        logger.info("Actual search request is: " + actualResult);
        return actualResult;
    }

    public int getNumberOfProductCards() {
        int actualResult = driver.findElements(By.xpath(searchProductCardName)).size();
        logger.info("Actual number of founded objects is: " + actualResult);
        return actualResult;
    }

    public Set<String> getActualSearchItemList() {
        List<WebElement> searchItems = driver.findElements(By.xpath(searchProductCardName));
        Set<String> searchItemsString = new TreeSet<>();
        for (WebElement searchItem : searchItems) {
            searchItemsString.add(searchItem.getText());
        }
        logger.info("Actual set of items is: " + searchItemsString);
        return searchItemsString;
    }

}
