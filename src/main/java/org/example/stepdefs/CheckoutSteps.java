package org.example.stepdefs;

import org.example.helper.WebElementHelper;
import org.example.pages.CheckoutPage;

public class CheckoutSteps extends WebElementHelper {

    public void clickBtnCheckout() {
        findElementById(CheckoutPage.btnCheckoutId).click();
    }

    public void clickBtnContinue() {
        findElementById(CheckoutPage.btnContinueId).click();
    }

    public String getErrorTextFieldRequired() {
        return findELementByTagName(CheckoutPage.popUpErrorTagName).getText();
    }
}
