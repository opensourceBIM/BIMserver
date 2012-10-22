package org.bimserver.client.factories;

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

import org.bimserver.client.AbstractBimServerClientFactory;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.ConnectionException;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.meta.ServicesMap;

public class SoapBimServerClientFactory extends AbstractBimServerClientFactory {

	private final String address;

	public SoapBimServerClientFactory(String address, ServicesMap servicesMap) {
		super(servicesMap);
		this.address = address;
	}

	@Override
	public BimServerClient create(AuthenticationInfo authenticationInfo, String remoteAddress) throws ServiceException, ConnectionException {
		BimServerClient bimServerClient = new BimServerClient(remoteAddress, getServicesMap());
		bimServerClient.setAuthentication(authenticationInfo);
		bimServerClient.connectSoap(false);
		return bimServerClient;
	}
}