package com.appfollow.aftests.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Slf4j
@Lazy
@Component
@ConfigurationProperties("test")
public class TestConfig {

    @Value("${timeout:4000}")
    private long timeout;

    @Value("${test.maximized:false}")
    private boolean maximized;

    @Value("${test.headless:false}")
    private boolean headless;

    @Value("${test.browser:chrome}")
    private String browser;

    @Value("${test.version:88}")
    private String version;

}
