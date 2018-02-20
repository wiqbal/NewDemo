package com.webservicex.LoactionSearchModule.USZip_Service.operations;

import java.io.File;

import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;
import com.webservicex.locationSearch.usZip.USZip;

public class GetInfoByCityName extends USZip{
	
	public GetInfoByCityName(){
		File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/usZipSoap/getInfoByCity/getInfoByCity.xml").getPath());
		setRequestDocument(XMLTools.makeXMLDocument(xml));
		
		setOperationName("GetInfoByCity");
		removeComments();
		removeWhiteSpace();
	}
	
	public void setCity(String value){
		setRequestNodeValueByXPath("/Envelope/Body/GetInfoByCity/USCity", value);
	}
	 public int getNumberOfResults(){
		 return getNumberOfResponseNodesByXPath("/Envelope/Body/GetInfoByCityResponse/GetInfoByCityResult/NewDataSet/Table");
	 }

}
