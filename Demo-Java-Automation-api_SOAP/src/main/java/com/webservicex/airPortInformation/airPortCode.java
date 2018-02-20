package com.webservicex.airPortInformation;

import com.orasi.api.soapServices.SoapService;

public class airPortCode extends SoapService{

	public airPortCode(){
	setServiceName("airPortCode");
	setServiceURL("http://www.webservicex.net/airport.asmx?WSDL");
}
	
}
