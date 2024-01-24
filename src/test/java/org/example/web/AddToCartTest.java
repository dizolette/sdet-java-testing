package org.example.web;

import org.example.base.BaseTest;
import org.example.base.ConfigFileReader;
import org.example.base.DriverFactory;
import org.example.pages.CartPage;
import org.example.pages.InventoryPage;
import org.example.stepdefs.CartSteps;
import org.example.stepdefs.InventorySteps;
import org.example.stepdefs.LoginSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    WebDriver driver;
    LoginTest loginTest;
    InventorySteps inventorySteps;
    CartSteps cartSteps;

    @BeforeClass
    public void initialize() {
        driver = DriverFactory.getDriver();
        loginTest = new LoginTest();
        inventorySteps = new InventorySteps();
        cartSteps = new CartSteps();
    }

    @Test
    public void addToCartAndRemoveItemTest() throws InterruptedException {
        driver.get(ConfigFileReader.getInstance().getProperty("BASE_URL"));

        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(ConfigFileReader.getInstance().getProperty("EMAIL"), ConfigFileReader.getInstance().getProperty("PASSWORD"));

        inventorySteps.addToCart(InventoryPage.btnAddToCartBackpackId, InventoryPage.btnAddToCartBikeLightId);
        inventorySteps.clickCart();
        cartSteps.removeItems(CartPage.btnRemoveItemBackpackId, CartPage.btnRemoveItemBikeLightId);

        Assert.assertFalse(cartSteps.isCartEmpty());
    }
}
