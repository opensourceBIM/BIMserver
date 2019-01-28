package org.bimserver.notifications;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewProgressTopicOnProjectNotification extends Notification {

	private static final Logger LOGGER = LoggerFactory.getLogger(NewProgressTopicOnProjectNotification.class);
	private long topicId;
	private long poid;

	public NewProgressTopicOnProjectNotification(BimServer bimServer, long poid, long topicId) {
		super(bimServer);
		this.poid = poid;
		this.topicId = topicId;
	}
	
	public long getTopicId() {
		return topicId;
	}
	
	public long getPoid() {
		return poid;
	}
	
	public void process() {
		ChangeProgressTopicOnProjectTopic changeProgressOnProjectTopic = getBimServer().getNotificationsManager().getChangeProgressOnProjectTopic(poid);
		try {
			changeProgressOnProjectTopic.notifyOfNewTopic(this);
		} catch (UserException e) {
			LOGGER.error("", e);
		} catch (ServerException e) {
			LOGGER.error("", e);
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		}
	}
}