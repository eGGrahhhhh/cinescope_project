package com.cinescope.api.assertions;

import com.cinescope.api.conditions.Condition;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class AssertableResponse {

    private final Response response;

    @Step("then api response should have {condition}")
    public AssertableResponse shouldHave(Condition condition){
        log.info("About to check condition {} ", condition);
        condition.check(response);
        return this;
    }

//    public <T> T asPojo(Class<T> tClass){
//        return response.as(tClass);
//    }

}
