package com.cinescope.api.services;

import com.cinescope.api.assertions.AssertableResponse;
import com.cinescope.api.payloads.UserPayload;

public class UserApiService extends ApiService {

    public AssertableResponse registerUser(UserPayload user) {
        return new AssertableResponse(setup()
                .body(user)
                .when()
                .post("register"));
    }

    public AssertableResponse loginUser(UserPayload user) {
        return new AssertableResponse(setup()
                .body(user)
                .when()
                .post("login"));
    }
}
