package com.webservicex.SpeedConverter;

import com.orasi.api.soapServices.SoapService;

public class ConvertSpeed  extends SoapService{

	public ConvertSpeed(){
		setServiceName("SpeedConverter");
		setServiceURL("http://www.webservicex.net/ConvertSpeed.asmx?WSDL");
	}
}
