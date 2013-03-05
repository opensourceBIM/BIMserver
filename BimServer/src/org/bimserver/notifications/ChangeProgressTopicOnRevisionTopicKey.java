package org.bimserver.notifications;

public class ChangeProgressTopicOnRevisionTopicKey extends TopicKey {

	private Long roid;
	private Long poid;

	public ChangeProgressTopicOnRevisionTopicKey(Long poid, Long roid) {
		this.poid = poid;
		this.roid = roid;
	}
	
	public Long getPoid() {
		return poid;
	}
	
	public Long getRoid() {
		return roid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((poid == null) ? 0 : poid.hashCode());
		result = prime * result + ((roid == null) ? 0 : roid.hashCode());
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
		ChangeProgressTopicOnRevisionTopicKey other = (ChangeProgressTopicOnRevisionTopicKey) obj;
		if (poid == null) {
			if (other.poid != null)
				return false;
		} else if (!poid.equals(other.poid))
			return false;
		if (roid == null) {
			if (other.roid != null)
				return false;
		} else if (!roid.equals(other.roid))
			return false;
		return true;
	}
}
