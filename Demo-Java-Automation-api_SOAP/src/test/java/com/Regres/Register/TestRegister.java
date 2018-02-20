package com.Regres.Register;

import org.testng.annotations.Test;
import com.orasi.utils.TestReporter;
import com.Regres.RestRegres;
import com.Regres.Register.object.Request;
import com.Regres.Register.object.Response;
import com.orasi.api.restServices.RestResponse;

public class TestRegister {
	@Test
	public void testRegister(){
		
		String email = "sydney@fife";
		String password = "pistol";
		
		Request request = new Request();
		request.setEmail(email);
		request.setPassword(password);
		
		RestResponse response = RestRegres.register().createRegister(request);
		
		Response data = response.mapJSONToObject(Response.class);
		
		TestReporter.logAPI(response.getStatusCode() == 201, 
				"Validating the Correct Response", response);
		
		TestReporter.softAssertTrue(data.getToken() == 
				"QpwL5tke4Pnpja7X", "Validating the Token ID");
	}

}
