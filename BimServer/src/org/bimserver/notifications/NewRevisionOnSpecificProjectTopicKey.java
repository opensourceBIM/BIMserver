package org.bimserver.notifications;

public class NewRevisionOnSpecificProjectTopicKey {
	private long poid;
	
	public NewRevisionOnSpecificProjectTopicKey(long poid) {
		this.poid = poid;
	}
	
	public long getPoid() {
		return poid;
	}
}
