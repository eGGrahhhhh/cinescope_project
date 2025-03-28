package com.cinescope.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegistrationResponse{

	@JsonProperty("id")
	private String id;

}