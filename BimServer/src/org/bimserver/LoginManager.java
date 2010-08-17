package org.bimserver;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.shared.AuthenticatedServiceWrapper;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.Token;
import org.bimserver.shared.UserException;

public class LoginManager {
	private boolean loggedIn = false;
	private static AuthenticatedServiceWrapper adminService;
	private AuthenticatedServiceWrapper authenticatedServiceWrapper;
	private static ServiceInterface service;

	public static void setService(ServiceInterface service) {
		LoginManager.service = service;
		try {
			Token adminToken = ((Service) service).loginAsAdmin();
			LoginManager.adminService = new AuthenticatedServiceWrapper(service, adminToken, true);
		} catch (UserException e) {
			e.printStackTrace();
		}
	}

	public boolean login(String username, String password) throws UserException {
		Token token = service.login(username, password);
		loggedIn = token != null;
		if (loggedIn) {
			authenticatedServiceWrapper = new AuthenticatedServiceWrapper(service, token, false);
		}
		return loggedIn;
	}
	
	public boolean autologin(String username, String hash) throws UserException {
		Token token = service.autologin(username, hash);
		loggedIn = token != null;
		if (loggedIn) {
			authenticatedServiceWrapper = new AuthenticatedServiceWrapper(service, token, false);
		}
		return loggedIn;
	}

	public long getUoid() {
		return authenticatedServiceWrapper.getCurrentUser().getOid();
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void logout() {
		authenticatedServiceWrapper.logout();
		authenticatedServiceWrapper = null;
		loggedIn = false;
	}

	public int getNumberOfTokens() {
		return ((Service) service).getTokenManager().getNumberOfTokens();
	}

	public AuthenticatedServiceWrapper getService() {
		return authenticatedServiceWrapper;
	}

	public SUserType getUserType() {
		return authenticatedServiceWrapper.getCurrentUser().getUserType();
	}

	public AuthenticatedServiceWrapper getAdminService() {
		return adminService;
	}

	public void loginAnonymous() {
		try {
			login("anonymous", "anonymous");
		} catch (UserException e) {
			e.printStackTrace();
		}
	}
}