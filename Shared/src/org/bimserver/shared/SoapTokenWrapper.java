package org.bimserver.shared;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SoapTokenWrapper {
	private String token;

	public SoapTokenWrapper(String token) {
		this.token = token;
	}
	
	public SoapTokenWrapper() {
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
