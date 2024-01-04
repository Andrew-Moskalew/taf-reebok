package by.itacademy.moskalew.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReebokPage {
    private String ButtonLogin = "//*[name()='svg' and @class='icon--RZbKK icon-link--seVu2  profile-icon--r3f5X']]";
    WebDriver driver;

    public void clickButtonLogin() {
        driver.findElement(By.xpath(ButtonLogin)).click();
    }
}
