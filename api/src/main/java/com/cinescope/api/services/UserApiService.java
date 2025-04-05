package com.cinescope.api.services;

import com.cinescope.api.assertions.AssertableResponse;
import com.cinescope.api.payloads.UserPayload;
import io.qameta.allure.Step;

public class UserApiService extends ApiService {

    @Step
    public AssertableResponse registerUser(UserPayload user) {
        return new AssertableResponse(setup()
                .body(user)
                .when()
                .post("register"));
    }

    @Step
    public AssertableResponse loginUser(UserPayload user) {
        return new AssertableResponse(setup()
                .body(user)
                .when()
                .post("login"));
    }
}
