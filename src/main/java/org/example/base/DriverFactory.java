package org.example.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverFactory() {

    }

    public static WebDriver initializeDriver(String webDriver) {

        switch (webDriver) {
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", "D:/DATA DWI/github project/sdet-java-testing/src/main/java/org/example/driver/chromedriver.exe");
                driver.set(new ChromeDriver());
                break;

            case "EDGE":
                System.setProperty("webdriver.edge.driver", "D:/DATA DWI/github project/sdet-java-testing/src/main/java/org/example/driver/msedgedriver.exe");
                driver.set(new EdgeDriver());
                break;

            default:
                break;
        }


        return driver.get();
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(initializeDriver(ConfigFileReader.getInstance().getProperty("DRIVER")));
        }
        return driver.get();
    }

    public static void cleanUpThreadLocal(){
        driver.remove();
    }

}
