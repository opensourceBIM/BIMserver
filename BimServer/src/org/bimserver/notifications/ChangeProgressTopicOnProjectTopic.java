package org.bimserver.notifications;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.endpoints.EndPoint;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class ChangeProgressTopicOnProjectTopic extends Topic {

	private ChangeProgressTopicOnProjectTopicKey key;

	public ChangeProgressTopicOnProjectTopic(NotificationsManager notificationsManager, ChangeProgressTopicOnProjectTopicKey key) {
		super(notificationsManager);
		this.key = key;
	}

	public void notifyOfNewTopic(final NewProgressTopicOnProjectNotification notification) throws UserException, ServerException, BimserverDatabaseException {
		map(new Mapper() {
			@Override
			public void map(final EndPoint endPoint) throws UserException, ServerException {
				endPoint.getNotificationInterface().newProgressOnProjectTopic(notification.getPoid(), notification.getTopicId());
			}
		});
	}

	@Override
	public void remove() {
		getNotificationsManager().removeChangeProgressTopicOnProject(key);
	}
	
	public ChangeProgressTopicOnProjectTopicKey getKey() {
		return key;
	}
}