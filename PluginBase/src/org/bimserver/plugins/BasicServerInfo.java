package org.bimserver.plugins;

public class BasicServerInfo {

	private String siteAddress;

	public BasicServerInfo(String siteAddress) {
		this.siteAddress = siteAddress;
	}
	
	public String getSiteAddress() {
		return siteAddress;
	}
}
