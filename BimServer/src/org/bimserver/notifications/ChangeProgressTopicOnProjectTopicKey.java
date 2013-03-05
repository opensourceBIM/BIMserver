package org.bimserver.notifications;

public class ChangeProgressTopicOnProjectTopicKey extends TopicKey {

	private Long poid;

	public ChangeProgressTopicOnProjectTopicKey(Long poid) {
		this.poid = poid;
	}
	
	public Long getPoid() {
		return poid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((poid == null) ? 0 : poid.hashCode());
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
		ChangeProgressTopicOnProjectTopicKey other = (ChangeProgressTopicOnProjectTopicKey) obj;
		if (poid == null) {
			if (other.poid != null)
				return false;
		} else if (!poid.equals(other.poid))
			return false;
		return true;
	}
}
