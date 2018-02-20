package com.Regres.postsNew;

import org.testng.annotations.Test;
import com.Regres.RestRegres;
import com.orasi.api.restServices.ResponseCodes;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;
import com.typicode.Rest;
import com.typicode.postsNew.objects.*;
import com.typicode.postsNew.postsNew;


public class TestPosts {
	
	
	@Test
	public void createPost(){
		String name = "morpheus";
		String job = "leader";
		
		PostRequest request = new PostRequest();
		request.setName(name);
		request.setJob(job);
		
		RestResponse restResponse = RestRegres.posts().createPostNew(request);
		
		
		TestReporter.logAPI(restResponse.getStatusCode() 
				== ResponseCodes.CREATED, "Validate successful repsonse", restResponse);
		
		
		PostResponse pr =  restResponse.mapJSONToObject(PostResponse.class);
		
		
		TestReporter.softAssertTrue(pr.getId() != null, "Validatiang the response from the ID was returned");
		TestReporter.softAssertTrue(pr.getName() != null, "Validatiang the response from the Name was returned");
		TestReporter.softAssertTrue(pr.getJob() != null, "Validatiang the response from the Job was returned");
		TestReporter.softAssertTrue(pr.getCreatedAt() != null, "Validatiang the response from the Time was returned");
		
		TestReporter.assertAll();
	}
}

