package by.itacademy.moskalew.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    private String url = "https://www.reebok.com";
    protected WebDriver driver;

    public String getUrl() {
        return url;
    }

}
