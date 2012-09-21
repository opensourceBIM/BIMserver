package org.bimserver.webservices;

public class Authorization {
	private long uoid = -1;
	
	public Authorization() {
	}
	
	public Authorization(long uoid) {
		this.uoid = uoid;
	}
	
	public long getUoid() {
		return uoid;
	}
	
	public void setUoid(long uoid) {
		this.uoid = uoid;
	}
}
