package com.google.timeZone;

import org.testng.annotations.Test;

import com.google.Rest_google;
import com.google.timeZone.object.Request;
import com.google.timeZone.object.Response;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class Test_timeZone {

	@Test
	public void gettimeZone() {
		
		String key = "AIzaSyDOHMDCG8BcV0xCinEkb3c2iIg_9jwlaMg";
		String location = "38.908133,-77.047119";
		String timestamp = "1516802400";
		
		Request request = new Request();
		request.setKey(key);
		request.setLocation(location);
		request.setTimestamp(timestamp);
		
		TestReporter.setDebugLevel(3);
		
		RestResponse restResponse = Rest_google.timeZone().getLocalData(request);
		
		TestReporter.logAPI(restResponse.getStatusCode() == 200, 
				"Validating the Correct Resposne Code", restResponse);
		
		
		
		
		
		
	}

}
