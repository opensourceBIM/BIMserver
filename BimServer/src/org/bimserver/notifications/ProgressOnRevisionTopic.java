package org.bimserver.notifications;

import org.bimserver.interfaces.objects.SProgressTopicType;

public class ProgressOnRevisionTopic extends ProgressTopic {
	private long poid;
	private long roid;

	public ProgressOnRevisionTopic(ProgressOnRevisionTopicKey key, long uoid, long poid, long roid, SProgressTopicType type, String description) {
		super(key, uoid, type, description);
		this.poid = poid;
		this.roid = roid;
	}
	
	public long getPoid() {
		return poid;
	}
	
	public long getRoid() {
		return roid;
	}
}
