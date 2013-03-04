package org.bimserver.notifications;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.store.LongActionState;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class ProgressNotification extends Notification {

	private LongActionState state;
	private ProgressTopic topic;

	public ProgressNotification(ProgressTopic topic, LongActionState state) {
		this.topic = topic;
		this.state = state;
	}

	@Override
	public void process(BimServer bimServer, DatabaseSession session, NotificationsManager notificationsManager) throws BimserverDatabaseException, UserException, ServerException {
		topic.updateProgress(state);
	}
}