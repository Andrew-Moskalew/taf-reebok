package by.itacademy.moskalew.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReebokSearchPage {
    private String inputSearch = "//input[@class='textbox-input--jX6cr  textbox-input-toggle-off--On9N3' and @placeholder='Search']";
    private String buttonSearch = "//*[name()='svg' and @class='icon--RZbKK icon-link--seVu2  ' and @aria-hidden='true' and @width='24'] ";
    private String searchResult = "//h1[@class='tag_h1_w--3KHZV  category-title--rXaZj']";
    private String searchProductCardName = "//p[@class='tag_p--1xo5V  product-card-name--9ffy7']";
    private WebDriver driver;

    public ReebokSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonSearch() {
        driver.findElement(By.xpath(buttonSearch)).click();
    }

    public void sendKeysInputSearch(String search) {
        driver.findElement(By.xpath(inputSearch)).sendKeys(search);
    }

    public String getTextSearchResult() {
        return driver.findElement(By.xpath(searchResult)).getText();
    }

    public List<WebElement> getProductCards() {
        return driver.findElements(By.xpath(searchProductCardName));
    }

}
