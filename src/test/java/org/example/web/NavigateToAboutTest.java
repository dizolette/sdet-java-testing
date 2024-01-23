package org.example.web;

import org.example.base.DriverFactory;
import org.example.stepdefs.InventorySteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NavigateToAboutTest {

    WebDriver driver;
    LoginTest loginTest;
    InventorySteps inventorySteps;

    @BeforeClass
    public void initialize() {
        driver = DriverFactory.getDriver();
        loginTest = new LoginTest();
        inventorySteps = new InventorySteps();
    }

    @Test
    public void navigateToAboutTest() throws InterruptedException {
        loginTest.testLogin();

        inventorySteps.clickBurgerMenu();
        inventorySteps.clickAboutSideBar();

        Assert.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/");
    }
}
