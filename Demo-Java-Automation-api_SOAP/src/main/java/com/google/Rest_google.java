package com.google;

import com.google.timeZone.timeZone;
import com.google.geolocation.geolocation;

public class Rest_google {

	public static String baseURL = "https://maps.googleapis.com";
	public static String baseURLG = "https://www.googleapis.com";
	
	public static timeZone timeZone() {
		return new timeZone();
	}
	
	public static geolocation geolocation(){
		return new geolocation();
	}
}
