package com.Regres.delete;

import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;
import com.Regres.*;

public class delete {

	private RestService restService= new RestService();
	private String path = RestRegres.baseUrl + "/api/users/2";
	
	public RestResponse deletePost(){
		return restService.sendDeleteRequest(path);
	}
	
}
