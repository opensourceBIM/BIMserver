package org.bimserver.notifications;

public class NewRevisionOnSpecificProjectTopicKey {
	private long poid;
	
	public NewRevisionOnSpecificProjectTopicKey(long poid) {
		this.poid = poid;
	}
	
	public long getPoid() {
		return poid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (poid ^ (poid >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewRevisionOnSpecificProjectTopicKey other = (NewRevisionOnSpecificProjectTopicKey) obj;
		if (poid != other.poid)
			return false;
		return true;
	}
}
