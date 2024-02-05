package org.example.stepdefs;

import org.example.helper.WebElementHelper;
import org.example.pages.InventoryPage;
import org.openqa.selenium.By;

public class InventorySteps extends WebElementHelper {

    public void addToCart(String... items) {
        for (String item : items) {
            clickOn(By.id(item), defaultElementTimeout);
        }
    }

    public void clickCart() {
        clickOn(By.id(InventoryPage.btnCartId), defaultElementTimeout);
    }

    public void clickBurgerMenu() {
        clickOn(By.id(InventoryPage.btnBurgerMenuId), defaultElementTimeout);
    }

    public void clickAboutSideBar() {
        clickOn(By.id(InventoryPage.btnSidebarAboutId), defaultElementTimeout);
    }
}
