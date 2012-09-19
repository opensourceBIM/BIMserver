package org.bimserver.client.channels;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bimserver.interfaces.NotificationInterfaceReflectorImpl;
import org.bimserver.interfaces.ServiceInterfaceReflectorImpl;
import org.bimserver.shared.ConnectDisconnectListener;
import org.bimserver.shared.NotificationInterface;
import org.bimserver.shared.Reflector;
import org.bimserver.shared.ServiceInterface;

public abstract class Channel {
	private final Map<String, Object> serviceInterfaces = new HashMap<String, Object>();
	private final Set<ConnectDisconnectListener> connectDisconnectListeners = new HashSet<ConnectDisconnectListener>();

	protected void addServiceInterface(String name, Object object) {
		serviceInterfaces.put(name, object);
	}

	public NotificationInterface getNotificationInterface() {
		return (NotificationInterface) getServiceInterface("NotificationInterface");
	}
	
	public ServiceInterface getServiceInterface() {
		return (ServiceInterface) getServiceInterface("ServiceInterface");
	}
	
	public Object getServiceInterface(String name) {
		return serviceInterfaces.get(name);
	}
	
	public void registerConnectDisconnectListener(ConnectDisconnectListener connectDisconnectListener) {
		connectDisconnectListeners.add(connectDisconnectListener);
	}
	
	public void notifyOfConnect() {
		for (ConnectDisconnectListener connectDisconnectListener : connectDisconnectListeners) {
			connectDisconnectListener.connected();
		}
	}
	
	public void notifyOfDisconnect() {
		for (ConnectDisconnectListener connectDisconnectListener : connectDisconnectListeners) {
			connectDisconnectListener.disconnected();
		}
	}

	protected void finish(Reflector reflector) {
		serviceInterfaces.put("ServiceInterface", new ServiceInterfaceReflectorImpl(reflector));
		serviceInterfaces.put("NotificationInterface", new NotificationInterfaceReflectorImpl(reflector));
	}
	
	public abstract void disconnect();
}