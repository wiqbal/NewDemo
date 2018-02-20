package com.Regres.update;

import org.testng.annotations.Test;

import com.Regres.RestRegres;
import com.Regres.update.objects.PostRequest;
import com.Regres.update.objects.PostResponse;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;
import com.orasi.utils.TestReporter;

public class TestUpdate {

	@Test
	public void updateTest() {

		String name = "morpheus";
		String job = "zion resident";

		PostRequest pr = new PostRequest();
		pr.setName(name);
		pr.setJob(job);

		RestResponse restResponse = RestRegres.update().updateRequest(pr);
		TestReporter.logAPI(restResponse.getStatusCode() == 200,
				"Validating Code Response", restResponse);

		PostResponse rr = restResponse.mapJSONToObject(PostResponse.class);
		TestReporter.softAssertTrue(rr.getName() != null,
				"Validating NAME was returned in response");
		TestReporter.softAssertTrue(rr.getJob() != null,
				"Validating JOB was returned in response");
		TestReporter.softAssertTrue(rr.getUpdatedAt() != null,
				"Validating UPDATEDAT was returned in response");
		TestReporter.assertAll();
	}

}
