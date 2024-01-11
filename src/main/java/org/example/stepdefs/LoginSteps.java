package org.example.stepdefs;

import org.example.helper.WebElementHelper;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebElement;

public class LoginSteps extends WebElementHelper {

    public void login(String email, String password) {
        WebElement etEmail = findElementById(LoginPage.etEmailId);
        WebElement etPassword = findElementById(LoginPage.etPasswordId);
        WebElement btnLogin = findElementById(LoginPage.btnLoginId);

        etEmail.sendKeys(email);
        etPassword.sendKeys(password);
        btnLogin.click();
    }
}
