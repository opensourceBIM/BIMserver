package org.bimserver.notifications;

public class ProgressOnRevisionTopicKey extends ProgressTopicKey {
	private long poid;
	private long roid;

	public ProgressOnRevisionTopicKey(long poid, long roid) {
		this.poid = poid;
		this.roid = roid;
	}

	public long getPoid() {
		return poid;
	}
	
	public long getRoid() {
		return roid;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (roid ^ (roid >>> 32));
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
		ProgressOnRevisionTopicKey other = (ProgressOnRevisionTopicKey) obj;
		if (roid != other.roid)
			return false;
		return true;
	}
}
