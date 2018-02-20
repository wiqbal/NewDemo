package com.grouptk;

import com.grouptk.ISOCodes.ISOCodes;

public class Rest_grouptk {

	public static String BaseURL = "http://services.groupkt.com/state/get";
	
	public static ISOCodes code(){
		return new ISOCodes();
	}

}
