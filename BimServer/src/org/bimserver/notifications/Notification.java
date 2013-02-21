package org.bimserver.notifications;

import org.bimserver.BimServer;
import org.bimserver.client.ChannelConnectionException;
import org.bimserver.client.JsonChannel;
import org.bimserver.client.SimpleTokenHolder;
import org.bimserver.client.channels.Channel;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.store.Service;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Notification {

	private static final Logger LOGGER = LoggerFactory.getLogger(Notification.class);	
	public abstract void process(BimServer bimServer, DatabaseSession session, NotificationsManager notificationsManager) throws BimserverDatabaseException, UserException, ServerException;
}