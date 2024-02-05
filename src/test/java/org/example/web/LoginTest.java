package org.example.web;

import org.example.base.BaseTest;
import org.example.base.ConfigFileReader;
import org.example.base.DriverFactory;
import org.example.stepdefs.LoginSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    WebDriver driver;

    @BeforeClass
    public void initialize() {
        driver = DriverFactory.getDriver();
    }

    @Test
    public void testLogin() {
        ConfigFileReader configFileReader = ConfigFileReader.getInstance();

        driver.get(configFileReader.getProperty("BASE_URL"));
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(configFileReader.getProperty("EMAIL"), configFileReader.getProperty("PASSWORD"));
    }

}
