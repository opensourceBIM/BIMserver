package org.bimserver.webservices;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.berkeley.BimserverConcurrentModificationDatabaseException;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ServerState;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.AdminAuthorization;
import org.bimserver.webservices.authorization.AnonymousAuthorization;
import org.bimserver.webservices.authorization.Authorization;
import org.bimserver.webservices.authorization.ExplicitRightsAuthorization;
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
		if (serviceMap.getAuthorization() == null) {
			throw new UserException("Authentication required for this call");
		}
		if (!(serviceMap.getAuthorization() instanceof AdminAuthorization) && !(serviceMap.getAuthorization() instanceof SystemAuthorization)) {
			throw new UserException("Administrator rights required for this call");
		}
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
		throw new ServerException("Unknown error: " + e.getMessage(), e);
	}
	
	public SUser getCurrentUser() throws UserException, ServerException {
		if (getAuthorization() == null) {
			return null;
		}
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			User user = session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), Query.getDefault());
			return getBimServer().getSConverter().convertToSObject(user);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	public String getRemoteAddress() {
		return serviceMap.getRemoteAddress();
	}
	
	public ServiceMap getServiceMap() {
		return serviceMap;
	}
	
	protected UserSettings getUserSettings(DatabaseSession session) throws BimserverLockConflictException, BimserverDatabaseException {
		User user = session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), Query.getDefault());
		return user.getUserSettings();
	}
}