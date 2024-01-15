package org.example.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    WebDriver driver = null;

    @BeforeTest
    public WebDriver initDriver() {
        driver = DriverFactory.initializeDriver(ConfigFileReader.getInstance().getProperty("DRIVER"));
        return this.driver;
    }

    @AfterTest
    public void closeDriver() {
        if (this.driver != null) {
            this.driver.close();
        }
    }
}
