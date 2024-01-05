package by.itacademy.moskalew.ui;

import by.itacademy.moskalew.pages.ReebokSearchPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class ReebokSearchTest {
    WebDriver driver;
    ReebokSearchPage reebokSearchPage;

    @BeforeEach
    public void testStart() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.reebok.com");
        reebokSearchPage = new ReebokSearchPage(driver);
    }

    @AfterEach
    public void testFinish() {
        driver.quit();
    }

    @Test
    public void testSearch() throws InterruptedException {
        reebokSearchPage.sendKeysInputSearch("shoes bb4500");
        Thread.sleep(1000);
        reebokSearchPage.clickButtonSearch();
        Thread.sleep(3000);
        Assertions.assertEquals("”SHOES BB4500”", reebokSearchPage.getTextSearchResult());
    }

    @Test
    public void testSearchItemsList() throws InterruptedException {
        reebokSearchPage.sendKeysInputSearch("shoes bb4500");
        Thread.sleep(1000);
        reebokSearchPage.clickButtonSearch();
        Thread.sleep(3000);
        List<WebElement> searchItems = reebokSearchPage.getProductCards();
        Assertions.assertEquals(16, searchItems.size());
    }

    @Test
    public void testSearchItemsListCompare() throws InterruptedException {
        reebokSearchPage.sendKeysInputSearch("shoes bb4500");
        Thread.sleep(1000);
        reebokSearchPage.clickButtonSearch();
        Thread.sleep(3000);
        List<WebElement> searchItems = reebokSearchPage.getProductCards();
        List<String> searchItemsString = new ArrayList<>();
        for (WebElement searchItem : searchItems) {
            searchItemsString.add(searchItem.getText());
        }
        List<String> expectedSearchItemsList = new ArrayList<>();
        expectedSearchItemsList.add("Reebok Royal BB4500 Hi 2 Basketball Shoes");
        expectedSearchItemsList.add("Royal BB4500 Hi 2.0 Shoes");
        expectedSearchItemsList.add("Royal BB4500 Hi 2.0 Shoes");
        expectedSearchItemsList.add("Royal BB4500 Hi 2.0 Men'S Shoes");
        expectedSearchItemsList.add("Royal BB4500 Hi 2.0 Shoes");
        expectedSearchItemsList.add("Royal BB4500 Hi 2.0 Men'S Shoes");
        expectedSearchItemsList.add("Royal BB4500 Hi 2.0 Men'S Shoes");
        expectedSearchItemsList.add("Reebok Royal BB4500 H2 XE Men'S Shoes");
        expectedSearchItemsList.add("Reebok Royal BB4500 H2 XE Men'S Shoes");
        expectedSearchItemsList.add("Reebok Royal BB4500 Hi 2 Basketball Shoes");
        expectedSearchItemsList.add("Reebok Royal BB4500 Hi 2 Basketball Shoes");
        expectedSearchItemsList.add("Reebok Royal BB4500 Hi 2 Basketball Shoes");
        expectedSearchItemsList.add("Reebok BB4500 Court Shoes - Preschool");
        expectedSearchItemsList.add("Reebok BB4500 Court Shoes - Preschool");
        expectedSearchItemsList.add("BB4500 Court Shoes - Preschool");
        expectedSearchItemsList.add("BB4500 Court Shoes - Preschool");
        Assertions.assertEquals(expectedSearchItemsList, searchItemsString);
    }

}
