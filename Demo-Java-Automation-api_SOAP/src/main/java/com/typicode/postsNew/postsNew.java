package com.typicode.postsNew;

import com.Regres.RestRegres;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;
import com.orasi.api.restServices.Headers.HeaderType;
import com.typicode.postsNew.objects.PostRequest;

public class postsNew {

	private RestService restService = new RestService();
	private String path = RestRegres.baseUrl + "/api/users";
	
	public RestResponse createPostNew(PostRequest request){
		return restService.sendPostRequest(path, HeaderType.JSON, RestService.getJsonFromObject(request));
	}
	
	
	
}
