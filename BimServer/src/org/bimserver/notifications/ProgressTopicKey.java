package org.bimserver.notifications;

import java.util.concurrent.atomic.AtomicLong;

public class ProgressTopicKey extends TopicKey {
	private static AtomicLong idCounter = new AtomicLong();
	private long id;
	
	public ProgressTopicKey() {
		id = idCounter.incrementAndGet();
	}
	
	public ProgressTopicKey(Long topicId) {
		this.id = topicId;
	}

	public long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		ProgressTopicKey other = (ProgressTopicKey) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
