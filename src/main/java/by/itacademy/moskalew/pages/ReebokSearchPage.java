package by.itacademy.moskalew.pages;

import by.itacademy.moskalew.driver.SingletonWebDriver;
import by.itacademy.moskalew.utils.Waiter;
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
    private static final String SEARCH_REQUEST = "Nano X4 Women'S Training Shoes";


    public ReebokSearchPage() {
        this.driver = SingletonWebDriver.getDriver();
    }

    public void clickButtonSearch() {
        driver.findElement(By.xpath(buttonSearch)).click();
        Waiter.wait(headerSearchResult);
    }

    public void sendKeysInputSearch(String search) {
        driver.findElement(By.xpath(inputSearch)).sendKeys(search);
        Waiter.wait(buttonResetSearch);
    }

    public String getTextSearchResult() {
        return driver.findElement(By.xpath(searchResult)).getText();
    }

    public List<WebElement> getProductCards() {
        return driver.findElements(By.xpath(searchProductCardName));
    }

    public Set<String> getExpectedSearchItemsList() {
        Set<String> expectedSearchItemsList = new TreeSet<>();
        expectedSearchItemsList.add(SEARCH_REQUEST);
        return expectedSearchItemsList;
    }

    public Set<String> getActualSearchItemList() {
        List<WebElement> searchItems = getProductCards();
        Set<String> searchItemsString = new TreeSet<>();
        for (WebElement searchItem : searchItems) {
            searchItemsString.add(searchItem.getText());
        }
        return searchItemsString;
    }

}
