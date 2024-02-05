package org.example.stepdefs;

import org.example.helper.WebElementHelper;
import org.example.pages.CheckoutPage;
import org.openqa.selenium.By;

public class CheckoutSteps extends WebElementHelper {

    public void clickBtnCheckout() {
        clickOn(By.id(CheckoutPage.btnCheckoutId), defaultElementTimeout);
    }

    public void clickBtnContinue() {
        clickOn(By.id(CheckoutPage.btnContinueId), defaultElementTimeout);
    }

    public String getErrorTextFieldRequired() {
        return waitPresenceOfElement(By.tagName(CheckoutPage.popUpErrorTagName), defaultElementTimeout).getText();
    }
}
