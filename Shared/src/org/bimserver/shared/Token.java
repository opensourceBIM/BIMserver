package org.bimserver.shared;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace="uri:org.bimserver.shared", name="token")
@XmlAccessorType(XmlAccessType.NONE)
public class Token {
	@XmlElement
	private String token;

	public Token() {
	}
	
	public Token(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
