package org.bimserver.webservices;

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.actions.AutologinDatabaseAction;
import org.bimserver.database.actions.LoginDatabaseAction;
import org.bimserver.interfaces.objects.SAccessMethod;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.AuthInterface;
import org.bimserver.shared.interfaces.ServiceInterface;

public class AuthServiceImpl extends GenericServiceImpl implements AuthInterface {
	public AuthServiceImpl(ServiceMap serviceMap) {
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
	public String autologin(String username, String hash) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			AutologinDatabaseAction action = new AutologinDatabaseAction(getBimServer(), session, getServiceMap(), super.getInternalAccessMethod(), username, hash);
			return session.executeAndCommitAction(action);
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
	public SUser getLoggedInUser() throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return getServiceMap().get(ServiceInterface.class).getUserByUoid(getAuthorization().getUoid());
	}
}