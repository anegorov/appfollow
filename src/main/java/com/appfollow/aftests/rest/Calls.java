package com.appfollow.aftests.rest;

import com.appfollow.aftests.configuration.ReqSpec;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static io.restassured.config.RedirectConfig.redirectConfig;

@Component
public class Calls {

    @Autowired
    private ReqSpec reqSpec;

    public Response get(String path){
        return reqSpec.getRequest()
                .config(RestAssured.config().redirect(redirectConfig().followRedirects(true)))
                .accept(ContentType.JSON)
                .log()
                .all()
                .request(Method.GET, path);
    }
}
