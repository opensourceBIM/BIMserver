package org.bimserver.database.actions;

import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.store.ObjectState;
import org.bimserver.database.store.User;
import org.bimserver.database.store.UserType;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.database.store.log.LogFactory;
import org.bimserver.database.store.log.UserUndeleted;
import org.bimserver.shared.UserException;

public class UndeleteUserDatabaseAction extends BimDatabaseAction<Boolean> {

	private final long actingUoid;
	private final long uoid;

	public UndeleteUserDatabaseAction(AccessMethod accessMethod, long actingUoid, long uoid) {
		super(accessMethod);
		this.actingUoid = actingUoid;
		this.uoid = uoid;
	}

	@Override
	public Boolean execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDatabaseException, BimDeadlockException {
		User actingUser = bimDatabaseSession.getUserByUoid(actingUoid);
		if (actingUser.getUserType() != UserType.ADMIN) {
			throw new UserException("Only administrators can undelete users");
		}
		final User user = bimDatabaseSession.getUserByUoid(uoid);
		if (user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.ANONYMOUS) {
			throw new UserException("Cannot undelete this user");
		}
		UserUndeleted userUndeleted = LogFactory.eINSTANCE.createUserUndeleted();
		userUndeleted.setAccessMethod(getAccessMethod());
		userUndeleted.setDate(new Date());
		userUndeleted.setExecutor(actingUser);
		userUndeleted.setUser(user);
		user.setState(ObjectState.ACTIVE);
		bimDatabaseSession.store(user);
		bimDatabaseSession.store(userUndeleted);
		return true;
	}
}