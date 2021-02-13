package com.appfollow.aftests.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;

@Getter
@Component
public class RegistrationPage {
    private SelenideElement form = $("body > div.popup-wrapper.js-signup-payed.js-popup.signup-payed__popup--scrollable > div > form");
    private SelenideElement inputEmail = $("#signup-payed-email");
    private SelenideElement inputFullName = $("#signup-payed-full_name");
    private SelenideElement inputCompany = $("#signup-payed-company");
    private SelenideElement cmbPosition = $("#signup-payed-position");
    private SelenideElement inputRole = $("#signup-payed-role");
    private SelenideElement btnSignup = $("#payed-signup-button");
    private SelenideElement msgError = $("#signup-payed-error");
}
