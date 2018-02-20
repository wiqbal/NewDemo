package com.Regres.Register;

import com.orasi.api.restServices.Headers.HeaderType;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;
import com.Regres.RestRegres;
import com.Regres.Register.object.Request;

public class Register {

	private RestService restService = new RestService();
	public String Path = RestRegres.baseUrl +  "/api/register";
	
	public RestResponse createRegister(Request request){
		return restService.sendPostRequest(Path, HeaderType.JSON, 
				RestService.getJsonFromObject(request));
	}
}
