package org.bimserver.notifications;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

import org.bimserver.models.store.User;
import org.bimserver.shared.NotificationInterface;

public class NotificationContainer {

	private final User user;
	private final NotificationInterface notificationInterface;

	public NotificationContainer(User user, NotificationInterface notificationInterface) {
		this.user = user;
		this.notificationInterface = notificationInterface;
	}
	
	public User getUser() {
		return user;
	}
	
	public NotificationInterface getNotificationInterface() {
		return notificationInterface;
	}
}
