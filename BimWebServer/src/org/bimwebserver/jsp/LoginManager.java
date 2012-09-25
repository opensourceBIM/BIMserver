package org.bimwebserver.jsp;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
import org.bimserver.client.factories.AuthenticationInfo;
import org.bimserver.client.factories.BimServerClientFactory;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginManager {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginManager.class);
	public static BimServerClientFactory bimServerClientFactory;
	private BimServerClient bimServerClient;
	private boolean loggedIn;

	public long getUoid() throws ServiceException {
		return getService().getCurrentUser().getOid();
	}

	public boolean login(AuthenticationInfo authenticationInfo, String remoteAddress) throws ServiceException {
		try {
			if (bimServerClient != null) {
				bimServerClient.disconnect();
			}
			bimServerClient = bimServerClientFactory.create(authenticationInfo, remoteAddress);
			loggedIn = bimServerClient.isConnected();
		} catch (ServiceException e) {
			LOGGER.error("", e);
		} catch (ConnectionException e) {
			LOGGER.error("", e);
		}
		return loggedIn;
	}
	
	public void logout() {
		try {
			bimServerClient.getServiceInterface().logout();
		} catch (ServiceException e) {
			LOGGER.error("", e);
		}
		loggedIn = false;
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	
	public ServiceInterface getService() {
		if (bimServerClient == null) {
			try {
				bimServerClient = bimServerClientFactory.create(null, "unknown");
			} catch (ServiceException e) {
				LOGGER.error("", e);
			} catch (ConnectionException e) {
				LOGGER.error("", e);
			}
		}
		return bimServerClient.getServiceInterface();
	}

	public SUserType getUserType() throws ServiceException {
		return getService().getCurrentUser().getUserType();
	}
}