package org.bimserver.webservices;

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

import java.util.HashMap;
import java.util.Map;

import org.bimserver.BimServer;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.User;
import org.bimserver.shared.ServiceHolder;
import org.bimserver.shared.ServiceMapInterface;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.interfaces.AdminInterface;
import org.bimserver.shared.interfaces.AuthInterface;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.shared.interfaces.MetaInterface;
import org.bimserver.shared.interfaces.NewServicesInterface;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.NotificationInterfaceAdaptor;
import org.bimserver.shared.interfaces.NotificationRegistryInterface;
import org.bimserver.shared.interfaces.OAuthInterface;
import org.bimserver.shared.interfaces.PluginInterface;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.interfaces.RemoteServiceInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.interfaces.SettingsInterface;
import org.bimserver.shared.interfaces.async.AsyncAdminInterface;
import org.bimserver.shared.interfaces.async.AsyncAuthInterface;
import org.bimserver.shared.interfaces.async.AsyncMetaInterface;
import org.bimserver.shared.interfaces.async.AsyncPluginInterface;
import org.bimserver.shared.interfaces.async.AsyncRegistryInterface;
import org.bimserver.shared.interfaces.async.AsyncServiceInterface;
import org.bimserver.shared.interfaces.async.AsyncSettingsInterface;
import org.bimserver.webservices.authorization.Authorization;
import org.bimserver.webservices.impl.AdminServiceImpl;
import org.bimserver.webservices.impl.AuthServiceImpl;
import org.bimserver.webservices.impl.LowLevelServiceImpl;
import org.bimserver.webservices.impl.MetaServiceImpl;
import org.bimserver.webservices.impl.NewServicesImpl;
import org.bimserver.webservices.impl.NotificationRegistryServiceImpl;
import org.bimserver.webservices.impl.OAuthServiceImpl;
import org.bimserver.webservices.impl.PluginServiceImpl;
import org.bimserver.webservices.impl.RemoteServiceImpl;
import org.bimserver.webservices.impl.ServiceImpl;
import org.bimserver.webservices.impl.SettingsServiceImpl;

public class ServiceMap implements ServiceMapInterface, ServiceHolder {
	private BimServer bimServer;
	private AccessMethod accessMethod;
	private Authorization authorization;
	private final Map<Class<? extends PublicInterface>, PublicInterface> interfaces = new HashMap<Class<? extends PublicInterface>, PublicInterface>();
	private User user;

	public ServiceMap(BimServer bimServer, Authorization authorization, AccessMethod accessMethod, User user) {
		this.bimServer = bimServer;
		this.authorization = authorization;
		this.accessMethod = accessMethod;
		this.user = user;
	}
	
	public User getUser() {
		return user;
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
		} else if (clazz == NewServicesInterface.class) {
			publicInterface = new NewServicesImpl(this);
		} else if (clazz == AuthInterface.class) {
			publicInterface = new AuthServiceImpl(this);
		} else if (clazz == AdminInterface.class) {
			publicInterface = new AdminServiceImpl(this);
		} else if (clazz == LowLevelInterface.class) {
			publicInterface = new LowLevelServiceImpl(this);
		} else if (clazz == MetaInterface.class) {
			publicInterface = new MetaServiceImpl(this);
		} else if (clazz == SettingsInterface.class) {
			publicInterface = new SettingsServiceImpl(this);
		} else if (clazz == RemoteServiceInterface.class) {
			publicInterface = new RemoteServiceImpl(bimServer, this);
		} else if (clazz == NotificationRegistryInterface.class) {
			publicInterface = new NotificationRegistryServiceImpl(this);
		} else if (clazz == NotificationInterface.class) {
			publicInterface = new NotificationInterfaceAdaptor();
		} else if (clazz == PluginInterface.class) {
			publicInterface = new PluginServiceImpl(this);
		} else if (clazz == OAuthInterface.class) {
			publicInterface = new OAuthServiceImpl(this);
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
	
	public AsyncMetaInterface getMetaAsync() {
		return new AsyncMetaInterface(get(MetaInterface.class), bimServer.getExecutorService());
	}
	
	public AsyncPluginInterface getPluginAsync() {
		return new AsyncPluginInterface(get(PluginInterface.class), bimServer.getExecutorService());
	}
	
	public AsyncRegistryInterface getRegistryAsync() {
		return new AsyncRegistryInterface(get(NotificationRegistryInterface.class), bimServer.getExecutorService());
	}
	
	public AsyncServiceInterface getServiceAsync() {
		return new AsyncServiceInterface(get(ServiceInterface.class), bimServer.getExecutorService());
	}
	
	public AsyncAuthInterface getAuthInterfaceAsync() {
		return new AsyncAuthInterface(get(AuthInterface.class), bimServer.getExecutorService());
	}
	
	public AsyncSettingsInterface getSettingsAsync() {
		return new AsyncSettingsInterface(get(SettingsInterface.class), bimServer.getExecutorService());
	}
	
	@Override
	public AdminInterface getAdminInterface() throws PublicInterfaceNotFoundException {
		return get(AdminInterface.class);
	}
	
	@Override
	public AuthInterface getAuthInterface() throws PublicInterfaceNotFoundException {
		return get(AuthInterface.class);
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
	public ServiceInterface getServiceInterface() throws PublicInterfaceNotFoundException {
		return get(ServiceInterface.class);
	}

	@Override
	public NewServicesInterface getNewServicesInterface() throws PublicInterfaceNotFoundException {
		return get(NewServicesInterface.class);
	}
	
	@Override
	public SettingsInterface getSettingsInterface() throws PublicInterfaceNotFoundException {
		return get(SettingsInterface.class);
	}

	public AuthInterface getBimServerAuthInterface() {
		return get(AuthInterface.class);
	}

	@Override
	public NotificationRegistryInterface getRegistry() throws PublicInterfaceNotFoundException {
		return get(NotificationRegistryInterface.class);
	}

	@Override
	public LowLevelInterface getLowLevelInterface() throws PublicInterfaceNotFoundException {
		return get(LowLevelInterface.class);
	}
}