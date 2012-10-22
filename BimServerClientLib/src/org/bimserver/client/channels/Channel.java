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

import org.bimserver.interfaces.objects.SToken;
import org.bimserver.shared.ConnectDisconnectListener;
import org.bimserver.shared.ReflectorFactory;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.reflector.Reflector;

public abstract class Channel {
	private final Map<Class<? extends PublicInterface>, PublicInterface> serviceInterfaces = new HashMap<Class<? extends PublicInterface>, PublicInterface>();
	private final Set<ConnectDisconnectListener> connectDisconnectListeners = new HashSet<ConnectDisconnectListener>();

	public void addServiceInterface(Class<? extends PublicInterface> interfaceClass, PublicInterface object) {
		serviceInterfaces.put(interfaceClass, object);
	}

	public NotificationInterface getNotificationInterface() {
		return (NotificationInterface) getServiceInterface(NotificationInterface.class);
	}
	
	public ServiceInterface getServiceInterface() {
		return (ServiceInterface) getServiceInterface(ServiceInterface.class);
	}
	
	public PublicInterface getServiceInterface(Class<? extends PublicInterface> interfaceClass) {
		return serviceInterfaces.get(interfaceClass);
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

	protected void finish(Reflector reflector, ReflectorFactory reflectorFactory) {
		serviceInterfaces.put(ServiceInterface.class, reflectorFactory.createReflector(ServiceInterface.class, reflector));
		serviceInterfaces.put(NotificationInterface.class, reflectorFactory.createReflector(NotificationInterface.class, reflector));
	}
	
	public abstract void disconnect();

	public SToken getToken() {
		return null;
	}
}