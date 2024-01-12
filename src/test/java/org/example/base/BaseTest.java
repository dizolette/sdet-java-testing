package org.example.base;

import org.example.enums.WebDriverEnum;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    WebDriver driver = null;

    @BeforeTest
    public WebDriver initDriver() {
        driver = DriverFactory.initializeDriver(WebDriverEnum.CHROME); // TODO: read default value from config.properties
        return this.driver;
    }

    @AfterTest
    public void closeDriver() {
        if (this.driver != null) {
            this.driver.close();
        }
    }
}
