package org.example.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    WebDriver driver = null;

    @BeforeTest
    public WebDriver initDriver() {
        driver = DriverFactory.initializeDriver(ConfigFileReader.getInstance().getProperty("DRIVER"));
        driver.manage().window().maximize();
        return this.driver;
    }

    @AfterTest
    public void closeDriver() {
        if (this.driver != null) {
            DriverFactory.cleanUpThreadLocal();
            this.driver.quit();
        }
    }
}
