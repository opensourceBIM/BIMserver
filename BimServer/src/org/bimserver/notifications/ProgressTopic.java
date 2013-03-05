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
	private ProgressTopicKey key;
	private LongActionState lastProgress;

	public ProgressTopic(ProgressTopicKey key, long uoid, SProgressTopicType type, String description) {
		this.key = key;
		this.uoid = uoid;
		this.type = type;
		this.description = description;
	}
	
	public ProgressTopicKey getKey() {
		return key;
	}
	
	public void updateProgress(LongActionState state) {
		lastProgress = state;
		for (EndPoint endPoint : getEndPoints()) {
			try {
				endPoint.getNotificationInterface().progress(key.getId(), new SConverter().convertToSObject(state));
			} catch (UserException e) {
				e.printStackTrace();
			} catch (ServerException e) {
				e.printStackTrace();
			}
		}
	}
	
	public LongActionState getLastProgress() {
		return lastProgress;
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

	public void unregister(EndPoint endPoint) throws TopicRegisterException {
		super.unregister(endPoint);
	}

	public void close() {
	}
}