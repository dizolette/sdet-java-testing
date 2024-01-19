package org.example.web;

import org.example.base.BaseTest;
import org.example.stepdefs.CheckoutSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutWithEmptyDataTest extends BaseTest {

    @Test
    public void checkoutWithoutData() throws InterruptedException {
        AddToCartTest addToCartTest = new AddToCartTest();
        CheckoutSteps checkoutSteps = new CheckoutSteps();

        addToCartTest.addToCartAndRemoveItemTest();

        // click checkout
        checkoutSteps.clickBtnCheckout();
        Assert.assertTrue(checkoutSteps.getErrorTextFieldRequired().contains("Error"));


    }
}
