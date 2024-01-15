package org.example.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static WebDriver driver;

    private DriverFactory() {

    }

    public static WebDriver initializeDriver(String webDriver) {

        if (driver == null) {

            switch (webDriver) {
                case "CHROME":
                    System.setProperty("webdriver.chrome.driver", "D:/DATA DWI/github project/sdet-java-testing/src/main/java/org/example/driver/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;

                case "FIREFOX":
                    System.setProperty("webdriver.chrome.driver", "D:/DATA DWI/github project/sdet-java-testing/src/main/java/org/example/driver/chromedriver.exe");
                    driver = new FirefoxDriver();
                    break;

                default:
                    break;
            }
        }

        return driver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = initializeDriver(ConfigFileReader.getInstance().getProperty("DRIVER"));
        }
        return driver;
    }

}
