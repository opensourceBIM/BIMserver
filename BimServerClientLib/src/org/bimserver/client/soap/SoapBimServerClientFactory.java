package org.bimserver.client.soap;

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

import org.bimserver.client.AbstractBimServerClientFactory;
import org.bimserver.client.BimServerClient;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.meta.SServicesMap;

public class SoapBimServerClientFactory extends AbstractBimServerClientFactory {

	private String address;

	public SoapBimServerClientFactory(String address, SServicesMap servicesMap, MetaDataManager metaDataManager) {
		super(servicesMap, metaDataManager);
		this.address = address;
	}
	
	public SoapBimServerClientFactory(MetaDataManager metaDataManager, String address) throws BimServerClientException {
		super(metaDataManager);
		this.address = address;
	}

	@Override
	public BimServerClient create(AuthenticationInfo authenticationInfo) throws ServiceException, ChannelConnectionException {
		SoapChannel soapChannel = new SoapChannel(getHttpClient(), address + "/soap11", true, getServicesMap().getInterfaceClasses());
		BimServerClient bimServerClient = new BimServerClient(this.getMetaDataManager(), address, getServicesMap(), soapChannel);
		soapChannel.connect(bimServerClient);
		bimServerClient.setAuthentication(authenticationInfo);
		bimServerClient.connect();
		return bimServerClient;
	}
}