package org.bimserver.database.actions;

import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.store.StoreFactory;
import org.bimserver.database.store.User;
import org.bimserver.database.store.UserType;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.database.store.log.LogFactory;
import org.bimserver.database.store.log.NewUserAdded;
import org.bimserver.shared.UserException;
import org.bimserver.utils.Hashers;

public class AddUserDatabaseAction extends BimDatabaseAction<Long> {
	private final String name;
	private final String password;
	private final UserType userType;
	private final String username;
	private final long createrUoid;

	public AddUserDatabaseAction(AccessMethod accessMethod, String username, String password, String name, UserType userType, long createrUoid) {
		super(accessMethod);
		this.name = name;
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.createrUoid = createrUoid;
	}

	public Long execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDatabaseException, BimDeadlockException {
		String trimmedUserName = username.trim();
		String trimmedName = name.trim();
		if (trimmedUserName.equals("")) {
			throw new UserException("Invalid username");
		}
		if (trimmedName.equals("")) {
			throw new UserException("Invalid name");
		}
		if (password == null || password.trim().equals("")) {
			throw new UserException("Invalid password");
		}
		if (bimDatabaseSession.getUserByUserName(trimmedUserName) != null) {
			throw new UserException("A user with the username " + trimmedUserName + " already exists");
		}
		User actingUser = bimDatabaseSession.getUserByUoid(createrUoid);
		if (createrUoid != -1 && actingUser.getUserType() != UserType.ADMIN) {
			throw new UserException("Only admin users can create other users");
		}
		final User user = StoreFactory.eINSTANCE.createUser();
		user.setName(trimmedName);
		user.setUsername(trimmedUserName);
		user.setPassword(Hashers.getSha256Hash(password));
		user.setCreatedOn(new Date());
		user.setCreatedBy(bimDatabaseSession.getUserByUoid(createrUoid));
		user.setUserType(userType);
		user.setLastSeen(null);
		NewUserAdded newUserAdded = LogFactory.eINSTANCE.createNewUserAdded();
		newUserAdded.setUser(user);
		newUserAdded.setExecutor(actingUser);
		newUserAdded.setDate(new Date());
		newUserAdded.setAccessMethod(getAccessMethod());
		bimDatabaseSession.store(user);
		bimDatabaseSession.store(newUserAdded);
		bimDatabaseSession.savePidCounter();
		bimDatabaseSession.saveOidCounter();
		bimDatabaseSession.saveUidCounter();
		return user.getOid();
	}
}