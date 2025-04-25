package com.cinescope.api.services;

import com.cinescope.api.ProjectConfig;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;

import java.util.Arrays;
import java.util.List;

public class ApiService {

    protected RequestSpecification setup() {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .filters(getFilters());
    }

    private List<Filter> getFilters(){
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
        if (config.logging()) {
            return Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter(), new AllureRestAssured());
        }
        return List.of(new AllureRestAssured());
    }
}


