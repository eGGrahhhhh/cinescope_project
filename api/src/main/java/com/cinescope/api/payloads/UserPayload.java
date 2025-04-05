package com.cinescope.api.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;


@Getter
@Setter
@ToString
@Accessors(fluent = true)
public class UserPayload {

    @JsonProperty("password")
    private String password;

    @JsonProperty("fullName")
    private String fullName;

    @JsonProperty("passwordRepeat")
    private String passwordRepeat;

    @JsonProperty("email")
    private String email;
}