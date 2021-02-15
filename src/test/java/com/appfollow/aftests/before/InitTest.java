package com.appfollow.aftests.before;

import com.appfollow.aftests.configuration.TestConfig;
import com.appfollow.aftests.configuration.UIBase;
import com.appfollow.aftests.pages.RegistrationPage;
import com.appfollow.aftests.pages.StartPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class InitTest {

    @Autowired @Lazy private TestConfig testConfig;
    @Autowired @Lazy protected UIBase uiBase;
    @Autowired @Lazy protected StartPage startPage;
    @Autowired @Lazy protected RegistrationPage registrationPage;

    @BeforeEach
    void setUpSelenoid(){
        Configuration.timeout = testConfig.getTimeout();
        Configuration.startMaximized = testConfig.isMaximized();
        Configuration.headless = testConfig.isHeadless();
        Configuration.browser = testConfig.getBrowser();
        Configuration.browserVersion = testConfig.getVersion();
    }

}
