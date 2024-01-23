package org.example.web;

import org.example.base.BaseTest;
import org.example.base.DriverFactory;
import org.example.stepdefs.CheckoutSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutWithEmptyDataTest extends BaseTest {

    WebDriver driver;
    AddToCartTest addToCartTest;
    CheckoutSteps checkoutSteps;

    @BeforeClass
    public void initialize() {
        driver = DriverFactory.getDriver();
        addToCartTest = new AddToCartTest();
        checkoutSteps = new CheckoutSteps();
    }

    @Test
    public void checkoutWithoutData() throws InterruptedException {

        addToCartTest.addToCartAndRemoveItemTest();

        // click checkout
        checkoutSteps.clickBtnCheckout();
        Assert.assertTrue(checkoutSteps.getErrorTextFieldRequired().contains("Error"));


    }
}
