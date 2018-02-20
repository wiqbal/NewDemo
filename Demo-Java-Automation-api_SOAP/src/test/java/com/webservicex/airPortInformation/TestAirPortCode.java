package com.webservicex.airPortInformation;

import org.testng.annotations.Test;

import com.orasi.utils.TestEnvironment;
import com.orasi.utils.TestReporter;

public class TestAirPortCode extends TestEnvironment {
	
	
	
	@Test
	public void getInfoByAPCode(){
		
		GetInfoByAPCode ap = new GetInfoByAPCode();
		ap.setAPCode("KHI");
		ap.sendRequest();
		//System.out.println(ap.getNumberOfResults());
		//TestReporter.assertTrue(ap.getNumberOfResults() != 0, "Response Returned");
		System.out.println(ap.getResponse());

}
}
