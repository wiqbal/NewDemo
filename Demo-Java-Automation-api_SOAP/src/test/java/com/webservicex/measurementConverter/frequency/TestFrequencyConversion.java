package com.webservicex.measurementConverter.frequency;

import org.testng.annotations.Test;

import com.orasi.utils.Constants;
import com.orasi.utils.Randomness;
import com.orasi.utils.TestEnvironment;
import com.orasi.utils.TestReporter;
import com.webservicex.measurementConverter.frequency.operations.ChangeFrequencyUnit;
import com.webservicex.measurementConverter.temperature.operations.ChangeTemperatureUnit;


public class TestFrequencyConversion extends TestEnvironment{
	
	@Test
	public void ChengeFrequencyUnit(){
		ChangeFrequencyUnit cfu = new ChangeFrequencyUnit("FreqConvertMegToKil");
		
		
		//cfu.setFreqValue("1");
		//cfu.setRequestNodeValueByXPath("/Envelope/Body/ChangeFrequencyUnit/fromFrequencyUnit", fromFreq);
		//cfu.setRequestNodeValueByXPath("/Envelope/Body/ChangeFrequencyUnit/toFrequencyUnit", toFreq);
		cfu.sendRequest();
		
		System.out.println(cfu.getResult());
		TestReporter.logAPI(cfu.getNumberOfResponseNodesByXPath("/Envelope/Body/ChangeFrequencyUnitResponse/ChangeFrequencyUnitResult") != 0, "Recieved", cfu);
		TestReporter.assertTrue(cfu.getResult().equalsIgnoreCase("1000"), "Verifying Result");
	}
   }
