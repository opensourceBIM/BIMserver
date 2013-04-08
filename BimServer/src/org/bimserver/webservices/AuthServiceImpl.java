package org.bimserver.webservices;

import java.nio.ByteBuffer;

import javax.jws.WebMethod;
import javax.jws.WebParam;

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.actions.AutologinDatabaseAction;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.actions.ChangePasswordDatabaseAction;
import org.bimserver.database.actions.LoginDatabaseAction;
import org.bimserver.database.actions.RequestPasswordChangeDatabaseAction;
import org.bimserver.database.actions.ValidateUserDatabaseAction;
import org.bimserver.interfaces.objects.SAccessMethod;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.AuthInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.webservices.authorization.AuthenticationException;
import org.bimserver.webservices.authorization.Authorization;

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
	public void tokenlogin(String token) throws UserException {
		try {
			setAuthorization(Authorization.fromToken(getBimServer().getEncryptionKey(), token));
		} catch (AuthenticationException e) {
			throw new UserException(e);
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

	@Override
	public Boolean changePassword(Long uoid, String oldPassword, String newPassword) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new ChangePasswordDatabaseAction(getBimServer(), session, getInternalAccessMethod(), uoid, oldPassword, newPassword, getAuthorization());
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void requestPasswordChange(String username, String resetUrl) throws ServerException, UserException {
		// No authentication required because you should be able to do this wihout logging in...
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new RequestPasswordChangeDatabaseAction(session, getInternalAccessMethod(), getBimServer(), username, resetUrl);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SUser validateAccount(Long uoid, String token, String password) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<User> action = new ValidateUserDatabaseAction(session, getInternalAccessMethod(), uoid, token, password);
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}
}