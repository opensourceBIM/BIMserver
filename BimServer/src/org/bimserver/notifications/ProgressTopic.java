package org.bimserver.notifications;

import org.bimserver.endpoints.EndPoint;
import org.bimserver.interfaces.SConverter;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.models.store.LongActionState;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class ProgressTopic extends Topic {

	private long uoid;
	private SProgressTopicType type;
	private String description;

	public ProgressTopic(long uoid, SProgressTopicType type, String description) {
		this.uoid = uoid;
		this.type = type;
		this.description = description;
	}
	
	public void updateProgress(ProgressTopicKey progressKey, LongActionState state) {
		for (EndPoint endPoint : getEndPoints()) {
			try {
				endPoint.getNotificationInterface().progress(progressKey.getId(), new SConverter().convertToSObject(state));
			} catch (UserException e) {
				e.printStackTrace();
			} catch (ServerException e) {
				e.printStackTrace();
			}
		}
	}
	
	public SProgressTopicType getType() {
		return type;
	}
	
	public String getDescription() {
		return description;
	}
	
	@Override
	public void register(EndPoint endPoint) throws TopicRegisterException {
		if (endPoint.getUoid() != uoid) {
			throw new TopicRegisterException("This user cannot register for updates on this Topic");
		}
		super.register(endPoint);
	}

	public void unregister(EndPoint endPoint) {
		super.unregister(endPoint);
	}

	public void close() {
	}
}