package org.bimserver.web;

/******************************************************************************
 * Copyright (C) 2009-2011  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ConnectionException;
import org.bimserver.client.factories.BimServerClientFactory;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.exceptions.ServiceException;

public class LoginManager {
	public static BimServerClientFactory bimServerClientFactory;
	
	private ServiceInterface service;
	private BimServerClient bimServerClient;

	private ServiceInterface systemService;
	private BimServerClient systemBimServerClient;

	public long getUoid() throws ServiceException {
		return service.getCurrentUser().getOid();
	}

	public ServiceInterface getService() {
		if (service == null) {
			if (bimServerClient == null) {
				try {
					bimServerClient = bimServerClientFactory.create();
				} catch (ServiceException e) {
					e.printStackTrace();
				} catch (ConnectionException e) {
					e.printStackTrace();
				}
			}
			service = bimServerClient.getServiceInterface();
		}
		return service;
	}

	public SUserType getUserType() throws ServiceException {
		return getService().getCurrentUser().getUserType();
	}
	
	public ServiceInterface getSystemService() {
		if (systemService == null) {
			if (systemBimServerClient == null) {
				try {
					systemBimServerClient = bimServerClientFactory.create();
				} catch (ServiceException e) {
					e.printStackTrace();
				} catch (ConnectionException e) {
					e.printStackTrace();
				}
			}
			systemService = systemBimServerClient.getServiceInterface();
		}
		return systemService;
	}
}