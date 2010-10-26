package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.CommitSet;
import org.bimserver.database.Database;
import org.bimserver.database.store.User;
import org.bimserver.database.store.UserType;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.shared.UserException;

public class ChangeUserTypeDatabaseAction extends BimDatabaseAction<Void> {

	private final long actingUoid;
	private final long uoid;
	private final SUserType userType;

	public ChangeUserTypeDatabaseAction(AccessMethod accessMethod, long actingUoid, long uoid, SUserType userType) {
		super(accessMethod);
		this.actingUoid = actingUoid;
		this.uoid = uoid;
		this.userType = userType;
	}

	@Override
	public Void execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		User actingUser = bimDatabaseSession.getUserByUoid(actingUoid);
		if (actingUser.getUserType() != UserType.ADMIN) {
			throw new UserException("Only admin users can change other user's types");
		} else {
		}
		User user = bimDatabaseSession.getUserByUoid(uoid);
		user.setUserType(UserType.get(userType.getOrdinal()));
		bimDatabaseSession.store(user, new CommitSet(Database.STORE_PROJECT_ID, -1));
		return null;
	}
}
