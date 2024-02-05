package org.example.helper;

import org.example.base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebElementHelper {

    WebDriver driver = DriverFactory.getDriver();

    public WebElement waitPresenceOfElement(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement findElementById(String id) {
        return driver.findElement(By.id(id));
    }

    public WebElement findElementByClassName(String className) {
        return driver.findElement(By.className(className));
    }

    public WebElement findELementByTagName(String tagName) {
        return driver.findElement(By.tagName(tagName));
    }

    public List<WebElement> findElementsByClassName(String className) {
        return driver.findElements(By.className(className));
    }

    public void clickOn(By locator, int timeoutInSeconds){
        WebElement element = waitPresenceOfElement(locator, timeoutInSeconds);
        element.click();
    }

    public void sendKeysOn(By locator, int timeoutInSeconds, String inputText){
        WebElement element = waitPresenceOfElement(locator, timeoutInSeconds);
        element.sendKeys(inputText);
    }
}
