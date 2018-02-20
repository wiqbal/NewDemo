package com.grouptk;

import org.testng.annotations.Test;

import com.grouptk.ISOCodes.object.CountryDataResponse;
import com.grouptk.ISOCodes.object.RestDataResponse;
import com.grouptk.ISOCodes.object.RootDataResponse;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestISOCode {

		
	@Test
	public void testISOCode(){
		
		RestResponse response = Rest_grouptk.code().getISOResult();
		System.out.println(	response.getStatusCode());
		TestReporter.logAPI(response.getStatusCode() == 200, "Validating the Response Status Code", response);
		
		RestDataResponse rdr = response.mapJSONToObject(RestDataResponse.class);
		
		TestReporter.logAPI(rdr.getRestResponse() != null, "Validating If Returned", response);
		

		
		RootDataResponse rdresponse = new RootDataResponse();
		System.out.println(rdresponse.getMessages());
			
		
		
	}
}
