package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;

public class SetHttpCallbackUrlDatabaseAction extends BimDatabaseAction<Void> {

	private final long uoid;
	private final String url;
	private final long actingUoid;

	public SetHttpCallbackUrlDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long actingUoid, long uoid, String url) {
		super(bimDatabaseSession, accessMethod);
		this.actingUoid = actingUoid;
		this.uoid = uoid;
		this.url = url;
	}

	@Override
	public Void execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User actingUser = getUserByUoid(actingUoid);
		if (actingUoid != uoid) {
			if (actingUser.getUserType() != UserType.ADMIN && actingUser.getUserType() != UserType.SYSTEM) {
				throw new UserException("Only admin users can change other user's callback url");
			}
		}
		User user = getUserByUoid(uoid);
		user.setNotificationUrl(url);
		getDatabaseSession().store(user);
		return null;
	}
}