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

import org.bimserver.client.ChannelConnectionException;
import org.bimserver.client.channels.Channel;
import org.bimserver.shared.TokenHolder;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.RemoteServiceInterface;

public class InternalChannel extends Channel {

	public InternalChannel(NotificationInterface notificationInterface) {
		addServiceInterface(NotificationInterface.class, notificationInterface);
	}

	public InternalChannel(RemoteServiceInterface remoteServiceInterface) {
		addServiceInterface(RemoteServiceInterface.class, remoteServiceInterface);
	}

	@Override
	public void disconnect() {
	}

	@Override
	public void connect(TokenHolder tokenHolder) throws ChannelConnectionException {
	}
}