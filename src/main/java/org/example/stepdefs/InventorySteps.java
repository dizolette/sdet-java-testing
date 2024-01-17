package org.example.stepdefs;

import org.example.helper.WebElementHelper;
import org.example.pages.InventoryPage;
import org.openqa.selenium.WebElement;

public class InventorySteps extends WebElementHelper {

    public void addToCart(String... items) {
        for (String item : items) {
            WebElement element = findElementById(item);
            element.click();
        }
    }

    public void clickCart() {
        findElementById(InventoryPage.btnCartId).click();
    }
}
