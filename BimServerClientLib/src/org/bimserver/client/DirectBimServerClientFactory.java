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

import org.bimserver.client.channels.DirectChannel;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.PluginManager;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.ServiceFactory;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.meta.SServicesMap;

public class DirectBimServerClientFactory<T extends PublicInterface> extends AbstractBimServerClientFactory {

	private final PluginManager pluginManager;
	private Class<T> interfaceClass;
	private ServiceFactory serviceFactory;
	private String baseAddress;

	public DirectBimServerClientFactory(String baseAddress, Class<T> interfaceClass, ServiceFactory serviceFactory, SServicesMap servicesMap) {
		super(servicesMap);
		this.baseAddress = baseAddress;
		this.interfaceClass = interfaceClass;
		this.serviceFactory = serviceFactory;
		pluginManager = new PluginManager();
		pluginManager.loadPluginsFromCurrentClassloader();
	}

	@Override
	public BimServerClient create(AuthenticationInfo authenticationInfo) throws ServiceException, ChannelConnectionException {
		DirectChannel channel = new DirectChannel();
		channel.connect(interfaceClass, serviceFactory.get(AccessMethod.INTERNAL).get(interfaceClass));
		BimServerClient bimServerClient = new BimServerClient(baseAddress, getServicesMap(), channel);
		bimServerClient.setAuthentication(authenticationInfo);
		return bimServerClient;
	}
}