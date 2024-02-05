package org.example.stepdefs;

import org.example.helper.WebElementHelper;
import org.example.pages.LoginPage;
import org.openqa.selenium.By;

public class LoginSteps extends WebElementHelper {

    public void login(String email, String password) {
        sendKeysOn(By.id(LoginPage.etEmailId), defaultElementTimeout, email);
        sendKeysOn(By.id(LoginPage.etPasswordId), defaultElementTimeout, password);
        clickOn(By.id(LoginPage.btnLoginId), defaultElementTimeout);
    }
}
