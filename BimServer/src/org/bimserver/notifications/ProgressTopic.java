package org.bimserver.notifications;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.endpoints.EndPoint;
import org.bimserver.interfaces.SConverter;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.models.store.ActionState;
import org.bimserver.models.store.LongActionState;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProgressTopic extends Topic {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProgressTopic.class);
	private static final int RATE_LIMIT_NANO_SECONDS = 200000000; // 200ms
	private SProgressTopicType type;
	private String description;
	private ProgressTopicKey key;
	private volatile LongActionState lastProgress;
	private long lastSent = -1;

	public ProgressTopic(NotificationsManager notificationsManager, ProgressTopicKey key, SProgressTopicType type, String description) {
		super(notificationsManager);
		this.key = key;
		this.type = type;
		this.description = description;
	}

	public ProgressTopicKey getKey() {
		return key;
	}

	protected synchronized void updateProgress(final LongActionState state) {
		try {
			// Actually we should be keeping track of when we last sent a message to A SPECIFIC ENDPOINT, this way, new endpoints won't receive the message rights away
			
			boolean sendMessage = lastSent == -1 || (System.nanoTime() - lastSent > RATE_LIMIT_NANO_SECONDS && state.getProgress() != lastProgress.getProgress());
			sendMessage |= state.getProgress() == 100;
			sendMessage |= state.getState() == ActionState.FINISHED;
			sendMessage |= state.getState() == ActionState.AS_ERROR;
			sendMessage |= lastProgress != null && lastProgress.getStage() != state.getStage();
			sendMessage |= lastProgress != null && !lastProgress.getTitle().equals(state.getTitle());

			if (sendMessage) {
				try {
//					System.out.println("Sending " + state.getProgress() + ", " + state.getState() + ", " + state.getTitle() + " to " + getEndPoints().size());
					map(new Mapper(){
						@Override
						public void map(EndPoint endPoint) throws UserException, ServerException, BimserverDatabaseException {
							try {
								endPoint.getNotificationInterface().progress(key.getId(), new SConverter().convertToSObject(state));
							} catch (Exception e) {
								LOGGER.error("", e);
							}
						}
					});
				} catch (Exception e) {
					LOGGER.error("", e);
				}
				lastProgress = state;
				lastSent = System.nanoTime();
			} else {
//				System.out.println("Skipping " + state.getProgress() + ", " + state.getState() + ", " + state.getTitle());
			}
		} catch (Exception e) {
			LOGGER.error("", e);
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
	
	public void close() {
	}

	@Override
	public void remove() {
		getNotificationsManager().removeProgressTopic(key);
	}

	public void stageProgressUpdate(LongActionState longActionState) {
		getNotificationsManager().notify(new ProgressNotification(getNotificationsManager().getBimServer(), this, longActionState));
	}
}