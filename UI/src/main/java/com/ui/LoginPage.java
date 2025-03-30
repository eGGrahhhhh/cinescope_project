package com.ui;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    public static LoginPage open() {
        Selenide.open("/login");
        return new LoginPage();
    }

    private final SelenideElement emailField = $(byName("email"));
    private final SelenideElement passwordField = $(byName("password"));
    private final SelenideElement loginBtn = $("[data-qa-id='login_submit_button']");

    public void sendEmail(String email) {
        emailField.setValue(email);
    }

    public void sendPassword(String password) {
        passwordField.setValue(password);
    }

    public void clickLogin() {
        loginBtn.click();
    }

    public void loginAs(String email, String password) {
        sendEmail(email);
        sendPassword(password);
        clickLogin();
    }

}
