package com.webservicex.monthlyPay;

import org.testng.annotations.Test;

import com.webservicex.monthlyPayments.loanServices.GetInfoByAmount;
import com.orasi.utils.Constants;
import com.orasi.utils.TestEnvironment;
import com.orasi.utils.TestReporter;

public class TestSoapService_monthlyPayment extends TestEnvironment{
	
	private String excelFileLocation = Constants.EXCEL_SHEETS + "/monthlyPayment";
	
	@Test
	public void GetInfoByAmount(){
		
		GetInfoByAmount scenario = new GetInfoByAmount();
		scenario.setAmount("50000");
		scenario.setIntRate("3.75");
		scenario.setMonths("360");
		scenario.sendRequest();
		System.out.println(scenario.getNumberOfResults());
		System.out.println(scenario.getResponseNodeValueByXPath
				("/Envelope/Body/LoanMonthlyPaymentResponse/LoanMonthlyPaymentResult"));
		
		
		
		TestReporter.logAPI(scenario.getLoanMonthlyPaymentResult().equalsIgnoreCase("231.55779578606212"), "Valid Results", scenario);
		
		TestReporter.logAPI(scenario.validateResponse
				(excelFileLocation + "/GetInfoByAmount.xlsx", "Main"), "Validating Response", scenario);
		
	}

}
