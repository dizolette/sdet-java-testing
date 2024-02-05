package org.example.web;

import org.example.base.BaseTest;
import org.example.base.ConfigFileReader;
import org.example.base.DriverFactory;
import org.example.stepdefs.InventorySteps;
import org.example.stepdefs.LoginSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NavigateToAboutTest extends BaseTest {

    WebDriver driver;
    LoginTest loginTest;
    InventorySteps inventorySteps;
    ConfigFileReader configFileReader;

    @BeforeClass
    public void initialize() {
        driver = DriverFactory.getDriver();
        loginTest = new LoginTest();
        inventorySteps = new InventorySteps();
    }

    @Test
    public void navigateToAboutTest() {

        driver.get(ConfigFileReader.getInstance().getProperty("BASE_URL"));
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(ConfigFileReader.getInstance().getProperty("EMAIL"), ConfigFileReader.getInstance().getProperty("PASSWORD"));

        inventorySteps.clickBurgerMenu();
        inventorySteps.clickAboutSideBar();

        Assert.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/");
    }
}
