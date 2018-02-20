package com.Regres.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.Regres.RestRegres;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;
import com.orasi.api.restServices.Headers.HeaderType;

public class user {

	private RestService restService = new RestService();
	private String path = RestRegres.baseUrl + "/api/users?page=2";
	
	public RestResponse getUserData(){
		return restService.sendGetRequest(path);
	}
	
}
