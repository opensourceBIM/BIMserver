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

import org.bimserver.BimserverDatabaseException;
import org.bimserver.endpoints.EndPoint;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class NewExtendedDataOnRevisionTopic extends Topic {

	private NewExtendedDataOnRevisionTopicKey key;

	public NewExtendedDataOnRevisionTopic(NotificationsManager notificationsManager, NewExtendedDataOnRevisionTopicKey key) {
		super(notificationsManager);
		this.key = key;
	}
	
	public void process(final NewExtendedDataOnRevisionNotification newExtendedDataOnRevisionNotification) throws BimserverDatabaseException, UserException, ServerException {
		map(new Mapper(){
			@Override
			public void map(EndPoint endPoint) throws UserException, ServerException, BimserverDatabaseException {
				endPoint.getNotificationInterface().newExtendedData(key.getRoid(), newExtendedDataOnRevisionNotification.getEdid());
			}});
	}

	@Override
	public void remove() {
		getNotificationsManager().removeNewExtendedDataOnRevisionTopic(key);
	}
}
