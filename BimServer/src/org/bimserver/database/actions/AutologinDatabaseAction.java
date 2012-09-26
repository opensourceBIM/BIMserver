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

public class AutologinDatabaseAction extends BimDatabaseAction<Boolean>{

	private final String hash;
	private final String username;
	private final Service service;

	public AutologinDatabaseAction(DatabaseSession databaseSession, Service service, AccessMethod accessMethod, String username, String hash) {
		super(databaseSession, accessMethod);
		this.service = service;
		this.username = username;
		this.hash = hash;
	}

	@Override
	public Boolean execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		BimDatabaseAction<User> action = new GetUserByUserNameDatabaseAction(getDatabaseSession(), getAccessMethod(), username);
		User user = action.execute();
		if (user != null && hash.equals(Hashers.getSha256Hash(user.getUsername() + user.getPassword()))) {
			if (user.getState() == ObjectState.DELETED) {
				throw new UserException("User account has been deleted");
			} else if (user.getUserType() == UserType.SYSTEM) {
				throw new UserException("System user cannot login");
			}
			user.setLastSeen(new Date());
			service.setCurrentUser(user);
			getDatabaseSession().store(user);
			return true;
		} else {
			return false;
		}
	}
}