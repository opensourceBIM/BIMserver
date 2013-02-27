package org.bimserver.notifications;

import org.bimserver.interfaces.objects.SProgressTopicType;

public class ProgressOnProjectTopic extends ProgressTopic {

	public ProgressOnProjectTopic(ProgressOnProjectTopicKey key, long uoid, long poid, SProgressTopicType type, String description) {
		super(key, uoid, type, description);
	}
}
