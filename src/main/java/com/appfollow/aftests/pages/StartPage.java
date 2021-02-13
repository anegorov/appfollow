package com.appfollow.aftests.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;

@Getter
@Component
public class StartPage {
    private SelenideElement btnCreateAccount = $("body > header > div > div > div > form > button.ui-button.ui-button--primary.js-type-signup");
    private SelenideElement btnAdReject = $("#adroll_reject");
}
