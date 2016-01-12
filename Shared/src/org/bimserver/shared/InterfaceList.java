package org.bimserver.shared;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import java.util.LinkedHashSet;
import java.util.Set;

import org.bimserver.interfaces.SServiceInterfaceService;
import org.bimserver.shared.interfaces.AdminInterface;
import org.bimserver.shared.interfaces.AuthInterface;
import org.bimserver.shared.interfaces.MetaInterface;
import org.bimserver.shared.interfaces.PluginInterface;
import org.bimserver.shared.interfaces.PublicInterface;
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

public class InterfaceList {
	private static final Set<Class<? extends PublicInterface>> interfaces = new LinkedHashSet<Class<? extends PublicInterface>>();
	private static final Set<Class<? extends PublicInterface>> bimsie1Interfaces = new LinkedHashSet<Class<? extends PublicInterface>>();
	
	static {
		interfaces.add(ServiceInterface.class);
		interfaces.add(AdminInterface.class);
		interfaces.add(MetaInterface.class);
		interfaces.add(SettingsInterface.class);
		interfaces.add(AuthInterface.class);
		interfaces.add(PluginInterface.class);
		interfaces.add(Bimsie1ServiceInterface.class);
		interfaces.add(Bimsie1NotificationInterface.class);
		interfaces.add(Bimsie1RemoteServiceInterface.class);
		interfaces.add(Bimsie1AuthInterface.class);
		interfaces.add(Bimsie1LowLevelInterface.class);
		interfaces.add(Bimsie1NotificationRegistryInterface.class);

		bimsie1Interfaces.add(Bimsie1ServiceInterface.class);
		bimsie1Interfaces.add(Bimsie1NotificationInterface.class);
		bimsie1Interfaces.add(Bimsie1RemoteServiceInterface.class);
		bimsie1Interfaces.add(Bimsie1AuthInterface.class);
		bimsie1Interfaces.add(Bimsie1LowLevelInterface.class);
		bimsie1Interfaces.add(Bimsie1NotificationRegistryInterface.class);
	}

	public static SServicesMap createSServicesMap() {
		SServicesMap servicesMap = new SServicesMap();
		CodeFetcher sourceCodeFetcher = new CodeFetcher();
		SService serviceInterface = new SServiceInterfaceService(servicesMap, sourceCodeFetcher, ServiceInterface.class);
		servicesMap.add(serviceInterface);
		for (Class<? extends PublicInterface> clazz : getInterfaces()) {
			if (clazz != ServiceInterface.class) {
				servicesMap.add(new SService(servicesMap, sourceCodeFetcher, clazz));
			}
		}
		servicesMap.initialize();
		return servicesMap;
	}

	public static SServicesMap createBimsie1SServicesMap() {
		SServicesMap servicesMap = new SServicesMap();
		CodeFetcher sourceCodeFetcher = new CodeFetcher();
		for (Class<? extends PublicInterface> clazz : bimsie1Interfaces) {
			servicesMap.add(new SService(servicesMap, sourceCodeFetcher, clazz));
		}
		servicesMap.initialize();
		return servicesMap;
	}

	public static Set<Class<? extends PublicInterface>> getInterfaces() {
		return interfaces;
	}
}