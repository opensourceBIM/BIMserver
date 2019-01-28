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

import java.util.HashSet;
import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.endpoints.EndPoint;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public abstract class Topic {
	private final Set<EndPoint> endPoints = new HashSet<EndPoint>();
	private final NotificationsManager notificationsManager;
	
	public static interface Mapper {
		void map(EndPoint endPoint) throws UserException, ServerException, BimserverDatabaseException;
	}
	
	public Topic(NotificationsManager notificationsManager) {
		this.notificationsManager = notificationsManager;
	}

	public synchronized void map(Mapper mapper) throws UserException, ServerException, BimserverDatabaseException {
		for (EndPoint endPoint : endPoints) {
			mapper.map(endPoint);
		}
	}
	
	public synchronized void register(EndPoint endPoint) throws TopicRegisterException {
		endPoints.add(endPoint);
	}

	public synchronized void unregister(EndPoint endPoint) throws TopicRegisterException {
		endPoints.remove(endPoint);
	}
	
	public NotificationsManager getNotificationsManager() {
		return notificationsManager;
	}
	
	public Set<EndPoint> getEndPoints() {
		return endPoints;
	}
	
	public abstract void remove();
}