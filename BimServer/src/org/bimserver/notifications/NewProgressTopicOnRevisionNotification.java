package org.bimserver.notifications;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class NewProgressTopicOnRevisionNotification extends Notification {

	private long poid;
	private long roid;
	private long topicId;

	public NewProgressTopicOnRevisionNotification(long poid, long roid, long topicId) {
		this.poid = poid;
		this.roid = roid;
		this.topicId = topicId;
	}

	public long getTopicId() {
		return topicId;
	}
	
	public long getPoid() {
		return poid;
	}
	
	public long getRoid() {
		return roid;
	}
	
	@Override
	public void process(BimServer bimServer, DatabaseSession session, NotificationsManager notificationsManager) throws BimserverDatabaseException, UserException, ServerException {
		ChangeProgressTopicOnRevisionTopic changeProgressOnRevisionTopic = notificationsManager.getChangeProgressOnRevisionTopic(poid, roid);
		changeProgressOnRevisionTopic.notifyOfNewTopic(this);
		ChangeProgressTopicOnProjectTopic changeProgressOnProjectTopic = notificationsManager.getChangeProgressOnProjectTopic(poid);
		changeProgressOnProjectTopic.notifyOfNewTopic(new NewProgressTopicOnProjectNotification(poid, topicId));
		ChangeProgressTopicOnServerTopic changeProgressTopicOnServerTopic = notificationsManager.getChangeProgressTopicOnServerTopic();
		changeProgressTopicOnServerTopic.notifyOfNewTopic(new NewProgressTopicOnServerNotification(topicId));
	}
}