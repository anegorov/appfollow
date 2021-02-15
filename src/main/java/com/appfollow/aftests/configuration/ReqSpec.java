package com.appfollow.aftests.configuration;

import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Getter
@Setter
@Slf4j
@Lazy
@Component
public class ReqSpec {

    private RequestSpecification request;

    private ReqSpec(@Value("${api.url}") String url, @Value("${api.secret}") String secret){
        request = given();
        request.baseUri(url);
        request.header("Authorization", secret);
    }

}
