package com.google.timeZone;


import com.google.Rest_google;
import com.google.timeZone.object.Request;
import com.orasi.api.restServices.Headers.HeaderType;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;

public class timeZone {

	RestService restService = new RestService();
	public String path = Rest_google.baseURL + "/maps/api/timezone/json";

	public RestResponse getLocalData(Request request) {
		return restService.sendPostRequest(path, HeaderType.JSON,
				restService.getJsonFromObject(request));
	}

}
