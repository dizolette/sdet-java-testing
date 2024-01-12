package org.example.base;

import org.example.enums.WebDriverEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static WebDriver driver;

    private DriverFactory() {

    }

    public static WebDriver initializeDriver(WebDriverEnum webDriver){
        System.setProperty("webdriver.chrome.driver", "D:/DATA DWI/github project/sdet-java-testing/src/main/java/org/example/driver/chromedriver.exe"); //TODO: update the path from config properties

        if(driver == null){

            switch (webDriver.toString()) {
                case "CHROME":
                    driver = new ChromeDriver();
                    break;

                case "FIREFOX":
                    driver = new FirefoxDriver();
                    break;

                default:
                    break;
            }
        }

        return driver;
    }

    public static WebDriver getDriver() {
        if(driver == null){
            driver = initializeDriver(WebDriverEnum.CHROME); // TODO: read default value from config.properties
        }
        return driver;
    }

}
