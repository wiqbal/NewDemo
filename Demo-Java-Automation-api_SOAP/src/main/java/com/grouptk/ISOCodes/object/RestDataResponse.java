package com.grouptk.ISOCodes.object;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestDataResponse {

	@JsonProperty("RestResponse")
	private RootDataResponse restResponse;

	public RootDataResponse getRestResponse() {
		return restResponse;
	}

	public void setRestResponse(RootDataResponse restResponse) {
		this.restResponse = restResponse;
	}
}
