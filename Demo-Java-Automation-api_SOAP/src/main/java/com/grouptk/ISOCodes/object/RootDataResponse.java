package com.grouptk.ISOCodes.object;

import java.util.List;
import com.grouptk.ISOCodes.object.CountryDataResponse;

public class RootDataResponse {

	private List<String> messages = null;
	private List<CountryDataResponse> CountryDataResponse = null;

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public List<CountryDataResponse> getResult() {
		return CountryDataResponse;
	}

	public void setResult(List<CountryDataResponse> CountryDataResponse) {
		this.CountryDataResponse = CountryDataResponse;
	}
}
