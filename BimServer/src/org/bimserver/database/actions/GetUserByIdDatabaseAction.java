package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.Database;
import org.bimserver.database.ReadSet;
import org.bimserver.database.store.StorePackage;
import org.bimserver.database.store.User;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.shared.UserException;

public class GetUserByIdDatabaseAction extends BimDatabaseAction<User> {

	private final long uoid;
	private final long actingUoid;

	public GetUserByIdDatabaseAction(AccessMethod accessMethod, long uoid, int actingUoid) {
		super(accessMethod);
		this.uoid = uoid;
		this.actingUoid = actingUoid;
	}

	@Override
	public User execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
//		User actingUser = bimDatabaseSession.getUserById(actingUid);
//		if (uid == actingUid || uid == 2 || actingUser.getUserType() == UserType.ADMIN) {
		return (User) bimDatabaseSession.get(bimDatabaseSession.getCid(StorePackage.eINSTANCE.getUser()), uoid, new ReadSet(Database.STORE_PROJECT_ID, -1));
//		} else {
//			throw new UserException("Insufficient rights");
//		}
	}
}