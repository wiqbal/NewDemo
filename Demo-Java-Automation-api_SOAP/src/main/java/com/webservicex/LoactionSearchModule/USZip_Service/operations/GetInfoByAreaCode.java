package com.webservicex.LoactionSearchModule.USZip_Service.operations;

import java.io.File;

import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;
import com.webservicex.locationSearch.usZip.USZip;

public class GetInfoByAreaCode extends USZip{
	
	public GetInfoByAreaCode(){
		File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/usZipSoap/getInfoByAreaCode/getInfoByAreaCode.xml").getPath());
		setRequestDocument(XMLTools.makeXMLDocument(xml));
		
		setOperationName("GetInfoByArea");
		removeComments();
		removeWhiteSpace();
	}
	
	public void setArea(String value){
		setRequestNodeValueByXPath("/Envelope/Body/GetInfoByAreaCode/USAreaCode", value);
	}
	 public int getNumberOfResults(){
		 return getNumberOfResponseNodesByXPath("/Envelope/Body/GetInfoByAreaCodeResponse/GetInfoByAreaCodeResult/NewDataSet/Table");
	 }

}
