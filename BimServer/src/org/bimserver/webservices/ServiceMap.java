package org.bimserver.webservices;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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
import java.util.Map;

import org.bimserver.BimServer;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.ServiceHolder;
import org.bimserver.shared.ServiceMapInterface;
import org.bimserver.shared.interfaces.AdminInterface;
import org.bimserver.shared.interfaces.AuthInterface;
import org.bimserver.shared.interfaces.MetaInterface;
import org.bimserver.shared.interfaces.PluginInterface;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.interfaces.SettingsInterface;
import org.bimserver.shared.interfaces.async.AsyncAdminInterface;
import org.bimserver.shared.interfaces.async.AsyncBimsie1LowLevelInterface;
import org.bimserver.shared.interfaces.async.AsyncMetaInterface;
import org.bimserver.shared.interfaces.async.AsyncPluginInterface;
import org.bimserver.shared.interfaces.async.AsyncRegistryInterface;
import org.bimserver.shared.interfaces.async.AsyncServiceInterface;
import org.bimserver.shared.interfaces.async.AsyncSettingsInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1AuthInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1LowLevelInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1NotificationInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1NotificationRegistryInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1RemoteServiceInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1ServiceInterface;
import org.bimserver.webservices.authorization.Authorization;
import org.bimserver.webservices.impl.AdminServiceImpl;
import org.bimserver.webservices.impl.AuthServiceImpl;
import org.bimserver.webservices.impl.Bimsie1AuthServiceImpl;
import org.bimserver.webservices.impl.Bimsie1LowLevelServiceImpl;
import org.bimserver.webservices.impl.Bimsie1NotificationImpl;
import org.bimserver.webservices.impl.Bimsie1NotificationRegistryServiceImpl;
import org.bimserver.webservices.impl.Bimsie1RemoteServiceImpl;
import org.bimserver.webservices.impl.Bimsie1ServiceIImpl;
import org.bimserver.webservices.impl.MetaServiceImpl;
import org.bimserver.webservices.impl.PluginServiceImpl;
import org.bimserver.webservices.impl.ServiceImpl;
import org.bimserver.webservices.impl.SettingsServiceImpl;

public class ServiceMap implements ServiceMapInterface, ServiceHolder {
	private BimServer bimServer;
	private AccessMethod accessMethod;
	private Authorization authorization;
	private final Map<Class<? extends PublicInterface>, PublicInterface> interfaces = new HashMap<Class<? extends PublicInterface>, PublicInterface>();

	public ServiceMap(BimServer bimServer, Authorization authorization, AccessMethod accessMethod) {
		this.bimServer = bimServer;
		this.authorization = authorization;
		this.accessMethod = accessMethod;
	}

	public void put(Class<PublicInterface> clazz, PublicInterface publicInterface) {
		interfaces.put(clazz, publicInterface);
	}
	
	public BimServer getBimServer() {
		return bimServer;
	}
	
	public AccessMethod getAccessMethod() {
		return accessMethod;
	}
	
	public Authorization getAuthorization() {
		return authorization;
	}

	public void setAuthorization(Authorization authorization) {
		this.authorization = authorization;
	}

	@SuppressWarnings("unchecked")
	public <T extends PublicInterface> T get(Class<T> clazz) {
		PublicInterface publicInterface = interfaces.get(clazz);
		if (publicInterface != null) {
			return (T) publicInterface;
		}
		if (clazz == ServiceInterface.class) {
			publicInterface = new ServiceImpl(this);
		} else if (clazz == Bimsie1AuthInterface.class) {
			publicInterface = new Bimsie1AuthServiceImpl(this);
		} else if (clazz == AuthInterface.class) {
			publicInterface = new AuthServiceImpl(this);
		} else if (clazz == AdminInterface.class) {
			publicInterface = new AdminServiceImpl(this);
		} else if (clazz == Bimsie1LowLevelInterface.class) {
			publicInterface = new Bimsie1LowLevelServiceImpl(this);
		} else if (clazz == MetaInterface.class) {
			publicInterface = new MetaServiceImpl(this);
		} else if (clazz == SettingsInterface.class) {
			publicInterface = new SettingsServiceImpl(this);
		} else if (clazz == Bimsie1RemoteServiceInterface.class) {
			publicInterface = new Bimsie1RemoteServiceImpl(bimServer, this);
		} else if (clazz == Bimsie1NotificationInterface.class) {
			publicInterface = new Bimsie1NotificationImpl(bimServer);
		} else if (clazz == Bimsie1NotificationRegistryInterface.class) {
			publicInterface = new Bimsie1NotificationRegistryServiceImpl(this);
		} else if (clazz == Bimsie1ServiceInterface.class) {
			publicInterface = new Bimsie1ServiceIImpl(this);
		} else if (clazz == PluginInterface.class) {
			publicInterface = new PluginServiceImpl(this);
		} else {
			throw new RuntimeException("Unknown interface: " + clazz.getName());
		}
		interfaces.put((Class<PublicInterface>) clazz, publicInterface);
		return (T) publicInterface;
	}

	@Override
	public <T extends PublicInterface> void add(Class<T> class1, T remoteServiceInterface) {
		interfaces.put(class1, remoteServiceInterface);
	}
	
	public AsyncAdminInterface getAdminAsync() {
		return new AsyncAdminInterface(get(AdminInterface.class), bimServer.getExecutorService());
	}
	
	public AsyncBimsie1LowLevelInterface getBimsie1LowLevelAsync() {
		return new AsyncBimsie1LowLevelInterface(get(Bimsie1LowLevelInterface.class), bimServer.getExecutorService());
	}
	
	public AsyncMetaInterface getMetaAsync() {
		return new AsyncMetaInterface(get(MetaInterface.class), bimServer.getExecutorService());
	}
	
	public AsyncPluginInterface getPluginAsync() {
		return new AsyncPluginInterface(get(PluginInterface.class), bimServer.getExecutorService());
	}
	
	public AsyncRegistryInterface getRegistryAsync() {
		return new AsyncRegistryInterface(get(Bimsie1NotificationRegistryInterface.class), bimServer.getExecutorService());
	}
	
	public AsyncServiceInterface getServiceAsync() {
		return new AsyncServiceInterface(get(ServiceInterface.class), bimServer.getExecutorService());
	}
	
	public AsyncSettingsInterface getSettingsAsync() {
		return new AsyncSettingsInterface(get(SettingsInterface.class), bimServer.getExecutorService());
	}
	
	@Override
	public AdminInterface getAdminInterface() throws PublicInterfaceNotFoundException {
		return get(AdminInterface.class);
	}
	
	@Override
	public Bimsie1AuthInterface getBimsie1AuthInterface() throws PublicInterfaceNotFoundException {
		return get(Bimsie1AuthInterface.class);
	}
	
	@Override
	public Bimsie1LowLevelInterface getBimsie1LowLevelInterface() throws PublicInterfaceNotFoundException {
		return get(Bimsie1LowLevelInterface.class);
	}
	
	@Override
	public MetaInterface getMeta() throws PublicInterfaceNotFoundException {
		return get(MetaInterface.class);
	}
	
	@Override
	public PluginInterface getPluginInterface() {
		return get(PluginInterface.class);
	}
	
	@Override
	public Bimsie1NotificationRegistryInterface getRegistry() throws PublicInterfaceNotFoundException {
		return get(Bimsie1NotificationRegistryInterface.class);
	}
	
	@Override
	public ServiceInterface getServiceInterface() throws PublicInterfaceNotFoundException {
		return get(ServiceInterface.class);
	}
	
	@Override
	public SettingsInterface getSettingsInterface() throws PublicInterfaceNotFoundException {
		return get(SettingsInterface.class);
	}

	public AuthInterface getBimServerAuthInterface() {
		return get(AuthInterface.class);
	}

	public Bimsie1ServiceInterface getBimsie1ServiceInterface() {
		return get(Bimsie1ServiceInterface.class);
	}
}