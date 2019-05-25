package org.bimserver.client;

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

import org.bimserver.emf.MetaDataManager;
import org.bimserver.plugins.PluginManager;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.ServiceFactory;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.meta.SServicesMap;

public class DirectBimServerClientFactory<T extends PublicInterface> extends AbstractBimServerClientFactory {

	@SuppressWarnings("unused")
	private final PluginManager pluginManager;
	private ServiceFactory serviceFactory;
	private String baseAddress;

	public DirectBimServerClientFactory(String baseAddress, ServiceFactory serviceFactory, SServicesMap servicesMap, PluginManager pluginManager, MetaDataManager metaDataManager) {
		super(servicesMap, metaDataManager);
		this.baseAddress = baseAddress;
		this.serviceFactory = serviceFactory;
		this.pluginManager = pluginManager;
	}
	
	@Override
	public BimServerClient create(AuthenticationInfo authenticationInfo) throws ServiceException, ChannelConnectionException {
		DirectChannel channel = new DirectChannel(getHttpClient(), serviceFactory, getServicesMap());
		channel.connect();
		BimServerClient bimServerClient = new BimServerClient(this.getMetaDataManager(), baseAddress, getServicesMap(), channel);
		bimServerClient.setAuthentication(authenticationInfo);
		return bimServerClient;
	}

	public void setBaseAddress(String baseAddress) {
		this.baseAddress = baseAddress;
	}
}