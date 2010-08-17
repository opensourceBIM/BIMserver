package org.bimserver.database.actions;

import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.CommitSet;
import org.bimserver.database.Database;
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
		if (username == null || username.trim().equals("")) {
			throw new UserException("Invalid username");
		}
		if (name == null || name.trim().equals("")) {
			throw new UserException("Invalid name");
		}
		if (password == null || password.trim().equals("")) {
			throw new UserException("Invalid password");
		}
		if (bimDatabaseSession.getUserByUserName(username) != null) {
			throw new UserException("A user with the username " + username + " already exists");
		}
		User actingUser = bimDatabaseSession.getUserByUoid(createrUoid);
		if (createrUoid != -1 && actingUser.getUserType() != UserType.ADMIN) {
			throw new UserException("Only admin users can create other users");
		}
		final User user = StoreFactory.eINSTANCE.createUser();
		user.setName(name);
		user.setUsername(username);
		user.setPassword(Hashers.getSha256Hash(password));
		user.setCreatedOn(new Date());
		user.setCreatedBy(bimDatabaseSession.getUserByUoid(createrUoid));
		user.setUserType(userType);
		user.setLastSeen(new Date());
		NewUserAdded newUserAdded = LogFactory.eINSTANCE.createNewUserAdded();
		newUserAdded.setUser(user);
		newUserAdded.setExecutor(actingUser);
		newUserAdded.setDate(new Date());
		newUserAdded.setAccessMethod(getAccessMethod());
		CommitSet commitSet = new CommitSet(Database.STORE_PROJECT_ID, -1);
		bimDatabaseSession.store(user, commitSet);
		bimDatabaseSession.store(newUserAdded, commitSet);
		bimDatabaseSession.savePidCounter();
		bimDatabaseSession.saveOidCounter();
		bimDatabaseSession.saveUidCounter();
		return user.getOid();
	}
}