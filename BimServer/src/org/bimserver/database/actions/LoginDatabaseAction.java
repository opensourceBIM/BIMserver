package org.bimserver.database.actions;

import java.util.Date;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.Hashers;
import org.bimserver.webservices.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginDatabaseAction extends BimDatabaseAction<Boolean> {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginDatabaseAction.class);
	private static final Integer DEFAULT_LOGIN_ERROR_TIMEOUT = 3000;

	private final String username;
	private final String password;
	private final Service service;

	public LoginDatabaseAction(DatabaseSession databaseSession, Service service, AccessMethod accessMethod, String username, String password) {
		super(databaseSession, accessMethod);
		this.service = service;
		this.username = username;
		this.password = password;
	}

	@Override
	public Boolean execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		BimDatabaseAction<User> action = new GetUserByUserNameDatabaseAction(getDatabaseSession(), getAccessMethod(), username);
		User user = action.execute();
		if (user != null && Hashers.getSha256Hash(password).equals(user.getPassword())) {
			if (user.getState() == ObjectState.DELETED) {
				throw new UserException("User account has been deleted");
			} else if (user.getUserType() == UserType.SYSTEM) {
				throw new UserException("System user cannot login");
			}
			service.setCurrentUser(user);
			user.setLastSeen(new Date());
			getDatabaseSession().store(user);
			return true;
		} else {
			try {
				Thread.sleep(DEFAULT_LOGIN_ERROR_TIMEOUT);
			} catch (InterruptedException e) {
				LOGGER.error("", e);
			}
			throw new UserException("Invalid username/password combination");
		}
	}
}