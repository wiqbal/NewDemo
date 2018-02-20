package com.webservicex.LoactionSearchModule.USZip_Service.operations;

import java.io.File;

import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;
import com.webservicex.locationSearch.usZip.USZip;

public class GetInfoByZipCode extends USZip{
	
	public GetInfoByZipCode(){
		
		File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/usZipSoap/getInfoByZIP/getInfoByZip.xml").getPath());
		setRequestDocument(XMLTools.makeXMLDocument(xml));
		
		setOperationName("GetInfoByZip");
		removeComments();
		removeWhiteSpace();
		
	}

	public void setZip(String value){
		
		setRequestNodeValueByXPath("/Envelope/Body/GetInfoByZIP/USZip", value);
	}
	
	public int getNumberOfResults(){
		return getNumberOfResponseNodesByXPath("/Envelope/Body/GetInfoByZIPResponse/GetInfoByZIPResult/NewDataSet/Table");
	}
	
}
