package by.itacademy.moskalew.utils;

import by.itacademy.moskalew.driver.SingletonWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {
    public static void wait(String element){
        new WebDriverWait(SingletonWebDriver.getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
    }
}
