package org.example.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    WebDriver driver = null;

    @BeforeTest
    public WebDriver initDriver() {
        System.setProperty("webdriver.chrome.driver", "D:/DATA DWI/github project/sdet-java-testing/src/main/java/org/example/driver/chromedriver.exe");
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return this.driver;
    }

    @AfterTest
    public void closeDriver() {
        if (this.driver != null) {
            this.driver.close();
        }
    }
}
