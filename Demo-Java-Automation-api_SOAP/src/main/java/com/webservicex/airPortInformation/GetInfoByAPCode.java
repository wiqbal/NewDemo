package com.webservicex.airPortInformation;

import java.io.File;

import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;

public class GetInfoByAPCode extends airPortCode{

	public GetInfoByAPCode(){
		
		File xml = new File
				(this.getClass().getResource(Constants.XML_FILES + "/airPortCode/getInfoByAPCode.xml").getPath());
		setRequestDocument(XMLTools.makeXMLDocument(xml));
		
		
		removeComments();
		removeWhiteSpace();
		
	}
	public void setAPCode(String APCode){
		setRequestNodeValueByXPath("Envelope/Body/getAirportInformationByAirportCode/airportCode",APCode);
	}
	
	public int getNumberOfResults(){
		return getNumberOfResponseNodesByXPath
				("/Envelope/Body/getAirportInformationByAirportCodeResponse/getAirportInformationByAirportCodeResult/CDATA/NewDataSet/Table");
	}
	
}
