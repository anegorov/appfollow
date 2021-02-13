package com.appfollow.aftests.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Lazy;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Slf4j
@Lazy
@Component
@ConfigurationProperties("ui")
public class UIBase {
    @NonNull private String url;
}
