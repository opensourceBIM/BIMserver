package org.bimserver.client;

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

import org.bimserver.interfaces.SServiceInterfaceService;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.interfaces.AdminInterface;
import org.bimserver.shared.interfaces.AuthInterface;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.shared.interfaces.MetaInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.interfaces.SettingsInterface;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.meta.SServicesMap;

public abstract class AbstractBimServerClientFactory implements BimServerClientFactory {

	private SServicesMap servicesMap;

	public AbstractBimServerClientFactory(SServicesMap servicesMap) {
		this.servicesMap = servicesMap;
	}

	public AbstractBimServerClientFactory() {
		this.servicesMap = new SServicesMap();
		addService(new SServiceInterfaceService(null, ServiceInterface.class));
		addService(new SService(null, AuthInterface.class));
		addService(new SService(null, MetaInterface.class));
		addService(new SService(null, SettingsInterface.class));
		addService(new SService(null, AdminInterface.class));
		addService(new SService(null, LowLevelInterface.class));
	}
	
	@Override
	public BimServerClient create() throws ServiceException, ChannelConnectionException {
		return create(null);
	}

	public void addService(SService sService) {
		servicesMap.add(sService);
	}
	
	public SServicesMap getServicesMap() {
		return servicesMap;
	}
}
