package com.grouptk.ISOCodes;

import com.grouptk.Rest_grouptk;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;

public class ISOCodes {

	RestService restService = new RestService();	
	public String path =  Rest_grouptk.BaseURL  + "/IND/all";
		
	public RestResponse getISOResult(){
		return restService.sendGetRequest(path);
	}
	
}
