package org.bimserver.database.actions;

import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.UserUndeleted;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.UserException;

public class UndeleteUserDatabaseAction extends BimDatabaseAction<Boolean> {

	private final long actingUoid;
	private final long uoid;

	public UndeleteUserDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long actingUoid, long uoid) {
		super(bimDatabaseSession, accessMethod);
		this.actingUoid = actingUoid;
		this.uoid = uoid;
	}

	@Override
	public Boolean execute() throws UserException, BimDatabaseException, BimDeadlockException {
		User actingUser = getUserByUoid(actingUoid);
		if (actingUser.getUserType() != UserType.ADMIN) {
			throw new UserException("Only administrators can undelete users");
		}
		final User user = getUserByUoid(uoid);
		if (user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.ANONYMOUS) {
			throw new UserException("Cannot undelete this user");
		}
		UserUndeleted userUndeleted = LogFactory.eINSTANCE.createUserUndeleted();
		userUndeleted.setAccessMethod(getAccessMethod());
		userUndeleted.setDate(new Date());
		userUndeleted.setExecutor(actingUser);
		userUndeleted.setUser(user);
		user.setState(ObjectState.ACTIVE);
		getDatabaseSession().store(user);
		getDatabaseSession().store(userUndeleted);
		return true;
	}
}