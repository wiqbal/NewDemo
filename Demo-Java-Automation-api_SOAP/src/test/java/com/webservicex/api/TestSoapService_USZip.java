package com.webservicex.api;

import org.testng.annotations.Test;

import com.orasi.utils.Constants;
import com.orasi.utils.TestEnvironment;
import com.orasi.utils.TestReporter;
import com.webservicex.LoactionSearchModule.USZip_Service.operations.GetInfoByZipCode;



public class TestSoapService_USZip extends TestEnvironment {
	
	private String excelFileLocation = Constants.EXCEL_SHEETS + "/USZip_Service";
	
	@Test
	public void getInfoByZipCode(){
			
		GetInfoByZipCode getInfo = new GetInfoByZipCode();
		getInfo.setZip("27263");
		getInfo.sendRequest();	
		TestReporter.assertTrue(getInfo.getResponseNodeValueByXPath("/Envelope/Body/GetInfoByZIPResponse/GetInfoByZIPResult/NewDataSet/Table/STATE").equalsIgnoreCase("NC"), "Result were Retunred");
		System.out.println(getInfo.getNumberOfResults());
		TestReporter.logAPI(getInfo.getNumberOfResults() != 0, "Results Received", getInfo);
		TestReporter.assertTrue(getInfo.validateResponse(excelFileLocation + "/GetInfoByZipCode/GetInfoByZipCode.xlsx", "Main"), "Validate Response");
	}

}
