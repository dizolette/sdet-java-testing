package org.example.stepdefs;

import org.example.helper.WebElementHelper;
import org.example.pages.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartSteps extends WebElementHelper {

    public void removeItems(String... itemIds) {
        for (String item : itemIds) {
            clickOn(By.id(item), defaultElementTimeout);
        }
    }

    public boolean isCartEmpty() {
        List<WebElement> elements = findElementsByClassName(CartPage.divRemovedItemClass);
        return elements.isEmpty();
    }
}
