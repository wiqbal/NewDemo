package com.webservicex.SpeedConverter;

import org.testng.annotations.Test;

import com.orasi.utils.Constants;
import com.orasi.utils.TestEnvironment;
import com.orasi.utils.TestReporter;

public class TestSoapService_SpeedConverter extends TestEnvironment {
	
	public String excelFileLocation = Constants.EXCEL_SHEETS + "/speedData";

	@Test
	public void testSpeedConverter() {

		ConvertSpeedUnits cpu = new ConvertSpeedUnits("milesToKilometers");
		cpu.sendRequest();

		System.out.println(cpu.getNumberOfResults());
		
		System.out.println(cpu.getResponseNodeValueByXPath
				("Envelope/Body/ConvertSpeedResponse/ConvertSpeedResult"));
		
		TestReporter.logAPI(cpu.getNumberOfResults() != 0, "Result Returned",
				cpu);
		
		TestReporter.assertTrue(cpu.getResponseNodeValueByXPath
				("Envelope/Body/ConvertSpeedResponse/ConvertSpeedResult")
				.equalsIgnoreCase("62.137"), "Matching Result");
		
		TestReporter.assertTrue(cpu.validateResponse
				(excelFileLocation +"/speedDataVerification.xlsx", "Main"), "Valiadting Result");
	}
}
