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

import javax.servlet.http.HttpServletRequest;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ConnectionException;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimwebserver.BimWebServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginManager {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginManager.class);
	private BimServerClient bimServerClient;
	private boolean loggedIn;

	public long getUoid(HttpServletRequest request) throws ServiceException {
		return getService(request).getCurrentUser().getOid();
	}

	public long getUoid() throws ServiceException {
		return getService().getCurrentUser().getOid();
	}

	public boolean login(AuthenticationInfo authenticationInfo, String remoteAddress, HttpServletRequest request) throws ServiceException {
		try {
			if (bimServerClient != null) {
				bimServerClient.disconnect();
			}
			BimWebServer bimWebServer = (BimWebServer)request.getServletContext().getAttribute("bimwebserver");
			bimServerClient = bimWebServer.getBimServerClientFactory().create(authenticationInfo, remoteAddress);
			loggedIn = bimServerClient.isConnected();
			request.getSession().setAttribute("token", bimServerClient.getServiceInterface().getCurrentToken());
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
		return bimServerClient.getServiceInterface();
	}
	
	public ServiceInterface getService(HttpServletRequest request) {
		if (bimServerClient == null) {
			try {
				BimWebServer bimWebServer = (BimWebServer)request.getServletContext().getAttribute("bimwebserver");
				bimServerClient = bimWebServer.getBimServerClientFactory().create(null, "unknown");
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

	public SUserType getUserType(HttpServletRequest request) throws ServiceException {
		return getService(request).getCurrentUser().getUserType();
	}
}