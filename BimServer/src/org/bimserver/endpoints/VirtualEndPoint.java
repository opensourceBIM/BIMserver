package org.bimserver.endpoints;

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

import org.bimserver.shared.StreamingSocketInterface;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.RemoteServiceInterface;

public class VirtualEndPoint implements EndPoint {

	@Override
	public long getEndPointId() {
		return 0;
	}

	@Override
	public NotificationInterface getNotificationInterface() {
		return null;
	}

	@Override
	public RemoteServiceInterface getRemoteServiceInterface() {
		return null;
	}

	@Override
	public void cleanup() {
	}

	@Override
	public long getUoid() {
		return 0;
	}

	@Override
	public String getToken() {
		return null;
	}

	@Override
	public StreamingSocketInterface getStreamingSocketInterface() {
		return null;
	}
}