package com.webservicex.monthlyPayments.loanServices;

import java.io.File;

import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;
import com.webservicex.monthlyPayments.monthlyPayments;

public class GetInfoByAmount extends monthlyPayments{

	public GetInfoByAmount(){
		
		File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/monthlyPaySoap/getMonthlyPayment.xml").getPath());
		setRequestDocument(XMLTools.makeXMLDocument(xml));
		
		setServiceName("monthlyPayments");
		removeComments();
		removeWhiteSpace();
		
	}
	
	public void setAmount(String amount){
		setRequestNodeValueByXPath("/Envelope/Body/LoanMonthlyPayment/LoanAmount", amount);
	}
	public void setIntRate(String intRate){
		setRequestNodeValueByXPath("/Envelope/Body/LoanMonthlyPayment/InterestRate", intRate);
	}
	public void setMonths(String months){
		setRequestNodeValueByXPath("/Envelope/Body/LoanMonthlyPayment/Months", months);
	}
	
	public int getNumberOfResults(){
		return getNumberOfResponseNodesByXPath("/Envelope/Body/LoanMonthlyPaymentResponse/LoanMonthlyPaymentResult");
	}
	
	public String getLoanMonthlyPaymentResult(){
		return getResponseNodeValueByXPath("/Envelope/Body/LoanMonthlyPaymentResponse/LoanMonthlyPaymentResult");
	}
}
