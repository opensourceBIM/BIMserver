package org.bimserver.notifications;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.store.LongActionState;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class ProgressNotification extends Notification {

	private long id;
	private LongActionState state;
	private ProgressTopicKey key;
	private ProgressTopic topic;

	public ProgressNotification(ProgressTopicKey key, ProgressTopic topic, LongActionState state) {
		this.key = key;
		this.topic = topic;
		this.state = state;
	}

	@Override
	public void process(BimServer bimServer, DatabaseSession session, NotificationsManager notificationsManager) throws BimserverDatabaseException, UserException, ServerException {
		topic.updateProgress(key, state);
	}
}