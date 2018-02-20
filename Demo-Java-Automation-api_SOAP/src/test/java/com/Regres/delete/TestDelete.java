package com.Regres.delete;

import org.testng.annotations.Test;

import com.Regres.RestRegres;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestDelete {

	
	@Test
	public void delete(){
		
		RestResponse restService = RestRegres.delete().deletePost();
		
		
		TestReporter.logAPI(restService.getStatusCode() == 204, "Validating correct Response", restService);
		
	}
}
