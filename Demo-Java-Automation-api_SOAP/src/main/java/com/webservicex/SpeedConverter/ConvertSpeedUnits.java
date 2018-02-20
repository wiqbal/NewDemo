package com.webservicex.SpeedConverter;

import java.io.File;

import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;

public class ConvertSpeedUnits extends ConvertSpeed {

	public ConvertSpeedUnits(String conversion) {
		File file = new File(this
				.getClass()
				.getResource(
						Constants.XML_FILES
								+ "/speedConverter/speedConverter.xml")
				.getPath());
		setRequestDocument(XMLTools.makeXMLDocument(file));
		
		setRequestNodeValueByXPath(getTestScenario(Constants.EXCEL_SHEETS + "/speedData/speedData.xlsx", conversion));

		setServiceName("speedConverter");
		removeComments();
		removeWhiteSpace();
	}

	public void setSpeed(String speed) {
		setRequestNodeValueByXPath("/Envelope/Body/ConvertSpeed/speed", speed);
	}

	public void setFromUnit(String FromUnit) {
		setRequestNodeValueByXPath("/Envelope/Body/ConvertSpeed/FromUnit",
				FromUnit);
	}

	public void setToUnit(String ToUnit) {
		setRequestNodeValueByXPath("/Envelope/Body/ConvertSpeed/ToUnit", ToUnit);
	}
	
	public int getNumberOfResults(){
		return getNumberOfResponseNodesByXPath("Envelope/Body/ConvertSpeedResponse/ConvertSpeedResult");
	}
	
	
	
	
	
	

}
