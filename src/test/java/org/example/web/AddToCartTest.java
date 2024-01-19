package org.example.web;

import org.example.base.BaseTest;
import org.example.pages.CartPage;
import org.example.pages.InventoryPage;
import org.example.stepdefs.CartSteps;
import org.example.stepdefs.InventorySteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @Test
    public void addToCartAndRemoveItemTest() throws InterruptedException {
        LoginTest loginTest = new LoginTest();
        InventorySteps inventorySteps = new InventorySteps();
        CartSteps cartSteps = new CartSteps();

        loginTest.testLogin();
        inventorySteps.addToCart(InventoryPage.btnAddToCartBackpackId, InventoryPage.btnAddToCartBikeLightId);
        inventorySteps.clickCart();
        cartSteps.removeItems(CartPage.btnRemoveItemBackpackId, CartPage.btnRemoveItemBikeLightId);

        Assert.assertFalse(cartSteps.isCartEmpty());
    }
}
