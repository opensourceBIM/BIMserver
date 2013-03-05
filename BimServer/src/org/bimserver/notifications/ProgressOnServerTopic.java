package org.bimserver.notifications;

import org.bimserver.interfaces.objects.SProgressTopicType;

public class ProgressOnServerTopic extends ProgressTopic {

	public ProgressOnServerTopic(ProgressTopicKey key, long uoid, SProgressTopicType type, String description) {
		super(key, uoid, type, description);
		
	}
}
