package com.google.geolocation;

import org.testng.annotations.Test;

import com.google.Rest_google;
import com.google.geolocation.object.Request;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class Test_geolocation {

	
	@Test
	public void Test_Geolocation(){
		String key = "AIzaSyAR67iaNLe7GckBoICU38I27wMPIGeHLic";
		
		
		Request request = new Request();
		request.setKey(key);
		TestReporter.setDebugLevel(3);
		RestResponse restResponse = Rest_google.geolocation().getlocation(request);
		
		System.out.println(restResponse.getStatusCode());
		TestReporter.logAPI(restResponse.getStatusCode() == 403, "Checking Code", restResponse);
	}
}
