package org.example.web;

import org.example.base.BaseTest;
import org.example.base.ConfigFileReader;
import org.example.base.DriverFactory;
import org.example.pages.CartPage;
import org.example.pages.InventoryPage;
import org.example.stepdefs.CartSteps;
import org.example.stepdefs.CheckoutSteps;
import org.example.stepdefs.InventorySteps;
import org.example.stepdefs.LoginSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutWithEmptyDataTest extends BaseTest {

    WebDriver driver;
    AddToCartTest addToCartTest;
    CheckoutSteps checkoutSteps;
    InventorySteps inventorySteps;
    CartSteps cartSteps;

    @BeforeClass
    public void initialize() {
        driver = DriverFactory.getDriver();
        addToCartTest = new AddToCartTest();
        checkoutSteps = new CheckoutSteps();
        inventorySteps = new InventorySteps();
        cartSteps = new CartSteps();
    }

    @Test
    public void checkoutWithoutData() {

        driver.get(ConfigFileReader.getInstance().getProperty("BASE_URL"));

        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(ConfigFileReader.getInstance().getProperty("EMAIL"), ConfigFileReader.getInstance().getProperty("PASSWORD"));

        inventorySteps.addToCart(InventoryPage.btnAddToCartBackpackId, InventoryPage.btnAddToCartBikeLightId);
        inventorySteps.clickCart();
        cartSteps.removeItems(CartPage.btnRemoveItemBackpackId, CartPage.btnRemoveItemBikeLightId);

        Assert.assertFalse(cartSteps.isCartEmpty());

        // click checkout
        checkoutSteps.clickBtnCheckout();
        checkoutSteps.clickBtnContinue();
        Assert.assertTrue(checkoutSteps.getErrorTextFieldRequired().contains("Error"));


    }
}
