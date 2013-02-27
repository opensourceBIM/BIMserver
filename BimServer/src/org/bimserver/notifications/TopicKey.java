package org.bimserver.notifications;

import java.util.concurrent.atomic.AtomicLong;

public class TopicKey {
	private static AtomicLong idCounter = new AtomicLong();
	private long id;
	
	public TopicKey() {
		id = idCounter.incrementAndGet();
	}
	
	public TopicKey(Long topicId) {
		this.id = topicId;
	}

	public long getId() {
		return id;
	}
}