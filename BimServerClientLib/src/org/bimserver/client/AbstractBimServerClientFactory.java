package org.bimserver.client;

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

import java.util.Collections;
import java.util.List;

import org.bimserver.interfaces.SServiceInterfaceService;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.reflector.ReflectorFactoryImpl1;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.interfaces.AdminInterface;
import org.bimserver.shared.interfaces.AuthInterface;
import org.bimserver.shared.interfaces.MetaInterface;
import org.bimserver.shared.interfaces.PluginInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.interfaces.SettingsInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1AuthInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1LowLevelInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1NotificationInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1NotificationRegistryInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1RemoteServiceInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1ServiceInterface;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.meta.SServicesMap;

public abstract class AbstractBimServerClientFactory implements BimServerClientFactory {

	private SServicesMap servicesMap;

	public AbstractBimServerClientFactory(SServicesMap servicesMap) {
		this.servicesMap = servicesMap;
	}

	public AbstractBimServerClientFactory() {
		this.servicesMap = new SServicesMap();
		servicesMap.setReflectorFactory(new ReflectorFactoryImpl1());
		SService serviceInterface = new SServiceInterfaceService(null, ServiceInterface.class);
		addService(serviceInterface);
		List<SService> serviceInterfaceDep = Collections.singletonList(serviceInterface);
		addService(new SService(null, MetaInterface.class, serviceInterfaceDep));
		addService(new SService(null, AdminInterface.class, serviceInterfaceDep));
		addService(new SService(null, AuthInterface.class, serviceInterfaceDep));
		addService(new SService(null, SettingsInterface.class, serviceInterfaceDep));
		addService(new SService(null, PluginInterface.class, serviceInterfaceDep));
		addService(new SService(null, Bimsie1NotificationInterface.class, serviceInterfaceDep));
		addService(new SService(null, Bimsie1RemoteServiceInterface.class, serviceInterfaceDep));
		addService(new SService(null, Bimsie1AuthInterface.class, serviceInterfaceDep));
		addService(new SService(null, Bimsie1LowLevelInterface.class, serviceInterfaceDep));
		addService(new SService(null, Bimsie1NotificationRegistryInterface.class, serviceInterfaceDep));
		addService(new SService(null, Bimsie1ServiceInterface.class, serviceInterfaceDep));
	}
	
	@Override
	public BimServerClientInterface create() throws ServiceException, ChannelConnectionException {
		return create(null);
	}

	public void addService(SService sService) {
		servicesMap.add(sService);
	}
	
	public SServicesMap getServicesMap() {
		return servicesMap;
	}
}
