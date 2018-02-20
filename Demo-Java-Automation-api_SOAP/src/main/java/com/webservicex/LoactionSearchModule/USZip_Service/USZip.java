package com.webservicex.LoactionSearchModule.USZip_Service;

import com.orasi.api.soapServices.SoapService;

public class USZip extends SoapService{
	
	public USZip(){
		setServiceName("UsZipServices");
		setServiceURL("http://www.webservicex.net/uszip.asmx?wsdl");
	}

}
