package org.example.helper;

import org.example.base.DriverFactory;
import org.example.enums.WebDriverEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementHelper {

    WebDriver driver = DriverFactory.initializeDriver(WebDriverEnum.CHROME);

    public WebElement findElementById(String id){
        return driver.findElement(By.id(id));
    }
}
