package org.example.web;

import org.example.base.BaseTest;
import org.example.base.DriverFactory;
import org.example.stepdefs.LoginSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    WebDriver driver = DriverFactory.getDriver();

    @Test
    public void test() throws InterruptedException {
        driver.get("https://saucedemo.com"); //TODO: update the url to read from config.properties
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login("standard_user", "secret_sauce");
        Thread.sleep(5000);
    }

}
