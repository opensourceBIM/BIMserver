package org.bimserver.webservices.impl;

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

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OperationType;
import org.bimserver.database.berkeley.BimserverConcurrentModificationDatabaseException;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ServerState;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.NoTransactionException;
import org.bimserver.webservices.ServiceMap;
import org.bimserver.webservices.authorization.AdminAuthorization;
import org.bimserver.webservices.authorization.AnonymousAuthorization;
import org.bimserver.webservices.authorization.Authorization;
import org.bimserver.webservices.authorization.ExplicitRightsAuthorization;
import org.bimserver.webservices.authorization.MonitorAuthorization;
import org.bimserver.webservices.authorization.SystemAuthorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenericServiceImpl {
	private static final Logger LOGGER = LoggerFactory.getLogger(GenericServiceImpl.class);
	private ServiceMap serviceMap;
	
	public GenericServiceImpl(ServiceMap serviceMap) {
		this.serviceMap = serviceMap;
	}
	
	protected void requireAuthenticationAndRunningServer() throws UserException {
		requireRunningServer();
		requireAuthentication();
	}

	protected void requireAdminAuthenticationAndRunningServer() throws UserException {
		requireRunningServer();
		requireAdminAuthentication();
	}

	protected void requireRunningServer() throws UserException {
		if (serviceMap.getBimServer().getServerInfo().getServerState() != ServerState.RUNNING) {
			throw new UserException("Call cannot be executed because the server is in " + serviceMap.getBimServer().getServerInfo().getServerState() + " mode");
		}
	}

	protected void requireAuthentication() throws UserException {
		if (serviceMap.getAuthorization() == null || serviceMap.getAuthorization() instanceof AnonymousAuthorization) {
			throw new UserException("Authentication required for this call");
		}
	}

	protected void requireAtLeastAnonymousAuthentication() throws UserException {
		if (serviceMap.getAuthorization() == null) {
			throw new UserException("Authentication required for this call");
		}
	}
	
	protected void requireRealUserAuthentication() throws UserException {
		requireRunningServer();
		if (serviceMap.getAuthorization() == null) {
			throw new UserException("Authentication required for this call");
		}
		if (serviceMap.getAuthorization() instanceof ExplicitRightsAuthorization) {
			throw new UserException("Real authentication required (this session has token authentication)");
		}
		if (serviceMap.getAuthorization() instanceof AnonymousAuthorization) {
			throw new UserException("Anonymous has no rights for this call");
		}
	}

	protected void requireAdminAuthentication() throws UserException {
		Authorization authorization = serviceMap.getAuthorization();
		if (authorization == null) {
			throw new UserException("Authentication required for this call");
		}
		if (authorization instanceof AdminAuthorization || authorization instanceof SystemAuthorization) {
			return;
		}
		throw new UserException("Administrator rights required for this call");
	}

	protected void requireAdminOrMonitorAuthentication() throws UserException {
		Authorization authorization = serviceMap.getAuthorization();
		if (authorization == null) {
			throw new UserException("Authentication required for this call");
		}
		if (authorization instanceof AdminAuthorization || authorization instanceof SystemAuthorization || authorization instanceof MonitorAuthorization) {
			return;
		}
		throw new UserException("Administrator rights required for this call");
	}

	protected void requireSelfregistrationAllowed() throws UserException {
		if (serviceMap.getAuthorization() == null) {
			throw new UserException("No self registration allowed");
		}
	}
	
	public BimServer getBimServer() {
		return serviceMap.getBimServer();
	}
	
	public Authorization getAuthorization() {
		return serviceMap.getAuthorization();
	}
	
	public void setAuthorization(Authorization authorization) {
		this.serviceMap.setAuthorization(authorization);
	}
	
	public AccessMethod getInternalAccessMethod() {
		return serviceMap.getAccessMethod();
	}
	
	protected <T> T handleException(Exception e) throws ServerException, UserException {
		if (e instanceof UserException) {
			throw (UserException) e;
		} else if (e instanceof ServerException) {
			LOGGER.error("", e);
			throw (ServerException) e;
		} else if (e instanceof NoTransactionException) {
			throw new UserException(e);
		} else if (e instanceof BimserverConcurrentModificationDatabaseException) {
			throw new ServerException("Concurrent modification of object, please try again", e);
		} else if (e instanceof BimserverDatabaseException) {
			LOGGER.error("", e);
			throw new ServerException("Database error", e);
		}
		LOGGER.error("", e);
		throw new ServerException("Unhandled exception (" + e.getClass().getName() + ")" + (e.getMessage() == null ? "" : (": " + e.getMessage())) + ". See the server log for more details", e);
	}
	
	public SUser getCurrentUser() throws UserException, ServerException {
		if (getAuthorization() == null) {
			return null;
		}
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			User user = session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), OldQuery.getDefault());
			return getBimServer().getSConverter().convertToSObject(user);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	public ServiceMap getServiceMap() {
		return serviceMap;
	}
	
	protected UserSettings getUserSettings(DatabaseSession session) throws BimserverLockConflictException, BimserverDatabaseException {
		User user = session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), OldQuery.getDefault());
		return user.getUserSettings();
	}
}