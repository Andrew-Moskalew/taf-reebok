package by.itacademy.moskalew.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReebokSearchPage {
    private String inputSearch = "//input[@class='textbox-input--jX6cr  textbox-input-toggle-off--On9N3' and @placeholder='Search']";
    private String buttonSearch = "//*[name()='svg' and @class='icon--RZbKK icon-link--seVu2  ']/*[name()='path' and @fill='currentColor']";
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

}
