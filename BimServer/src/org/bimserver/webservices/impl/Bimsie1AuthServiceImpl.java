package org.bimserver.webservices.impl;

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