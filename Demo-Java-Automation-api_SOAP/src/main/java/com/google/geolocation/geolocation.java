package com.google.geolocation;

import com.google.Rest_google;
import com.orasi.api.restServices.Headers.HeaderType;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;
import com.google.geolocation.object.Request;

public class geolocation {

	RestService restService = new RestService();
	public String path = Rest_google.baseURLG + "/geolocation/v1/geolocate";
	
	public RestResponse getlocation(Request request){
		return restService.sendPostRequest(path, HeaderType.JSON, restService.getJsonFromObject(request));
		
	}
	
	
	
	
}
