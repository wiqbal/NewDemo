package com.Regres.user;


import org.testng.annotations.Test;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.Regres.RestRegres;
import com.orasi.api.restServices.ResponseCodes;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;
import com.Regres.user.objects.GetUserResponse;
import com.Regres.user.objects.RootData;

public class TestUser {
	
	@Test
	public void sendGetRequest(){
		RestResponse restResponse = RestRegres.user().getUserData();
		TestReporter.logAPI(restResponse.getStatusCode() == ResponseCodes.OK, "Validate successful repsonse", restResponse);
		RootData rootData = restResponse.mapJSONToObject(RootData.class);		
		
		TestReporter.softAssertTrue(rootData.getPage() == 2, "Page Verififcation");
		TestReporter.softAssertTrue(rootData.getPerPage() == 3, "Per Page Verififcation");
		TestReporter.softAssertTrue(rootData.getTotal() == 12, "Total Verififcation");
		TestReporter.softAssertTrue(rootData.getTotalPages() == 4, "Total Page Verififcation");
		
		for(GetUserResponse user : rootData.getData()){
			TestReporter.softAssertTrue(user.getId() != null, "Validate ID was returned in Response [" + user.getId() + "]");     
			TestReporter.softAssertTrue(user.getFirstName() != null, "Validating Firstname was retunred in response [" + user.getFirstName() + "]");
			TestReporter.softAssertTrue(user.getLastName() != null, "Validating Lastname was retunred in response [" +user.getLastName()+ "]");
			TestReporter.softAssertTrue(user.getAvatar() != null, "Validating avatar was retunred in response [" + user.getAvatar() + "]");
		}
		
		TestReporter.assertAll();
	}

}
