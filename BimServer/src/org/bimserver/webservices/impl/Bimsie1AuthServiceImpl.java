package org.bimserver.webservices.impl;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

import java.io.IOException;

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.actions.LoginDatabaseAction;
import org.bimserver.database.actions.LoginUserTokenDatabaseAction;
import org.bimserver.interfaces.objects.SAccessMethod;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1AuthInterface;
import org.bimserver.webservices.ServiceMap;

public class Bimsie1AuthServiceImpl extends GenericServiceImpl implements Bimsie1AuthInterface {
	public Bimsie1AuthServiceImpl(ServiceMap serviceMap) {
		super(serviceMap);
	}

	@Override
	public String login(String username, String password) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			LoginDatabaseAction loginDatabaseAction = new LoginDatabaseAction(getBimServer(), session, getServiceMap(), super.getInternalAccessMethod(), username, password);
			return session.executeAndCommitAction(loginDatabaseAction);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void logout() throws UserException {
		requireAuthenticationAndRunningServer();
		setAuthorization(null);
	}
	
	@Override
	public Boolean isLoggedIn() {
		return getAuthorization() != null;
	}

	@Override
	public SAccessMethod getAccessMethod() {
		return SAccessMethod.valueOf(getInternalAccessMethod().getName());
	}

	@Override
	public String loginOpenId(String op, String returnUrl) throws ServerException, UserException {
		try {
			return getBimServer().getOpenIdManager().authRequest(op, returnUrl);
		} catch (IOException e) {
			throw new UserException(e);
		}
	}

	@Override
	public String validateOpenId(String queryString) throws ServerException, UserException {
		return null;
	}

	@Override
	public String loginUserToken(String token) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			LoginUserTokenDatabaseAction loginDatabaseAction = new LoginUserTokenDatabaseAction(getBimServer(), session, getServiceMap(), super.getInternalAccessMethod(), token);
			return session.executeAndCommitAction(loginDatabaseAction);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
}