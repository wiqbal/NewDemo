package com.Regres.update;

import com.orasi.api.restServices.Headers.HeaderType;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;
import com.Regres.RestRegres;
import com.Regres.update.objects.PostRequest;

public class update {

		private RestService restService = new RestService();
		private String path = RestRegres.baseUrl + "/api/users/2";
		
		public RestResponse updateRequest(PostRequest request){
			return restService.sendPutRequest(path, HeaderType.JSON, restService.getJsonFromObject(request) );
			
		}
		
		
}
