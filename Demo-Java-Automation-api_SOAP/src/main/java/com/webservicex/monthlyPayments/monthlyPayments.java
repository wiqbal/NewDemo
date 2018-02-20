package com.webservicex.monthlyPayments;

import com.orasi.api.soapServices.SoapService;

public class monthlyPayments extends SoapService {

	public monthlyPayments() {
		setServiceName("monthlyPayments");
		setServiceURL("http://www.webservicex.net/FinanceService.asmx?WSDL");
	}

}
