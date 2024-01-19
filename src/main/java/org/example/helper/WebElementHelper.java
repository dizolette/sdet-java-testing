package org.example.helper;

import org.example.base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebElementHelper {

    WebDriver driver = DriverFactory.getDriver();

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
}
