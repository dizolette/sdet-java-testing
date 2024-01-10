package org.example.web;

import org.example.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    WebDriver driver = initDriver(); // FIXME: find another approach, so the initDriver not doubled called

    @Test
    public void test() {
        driver.get("https://google.com");
    }

}
