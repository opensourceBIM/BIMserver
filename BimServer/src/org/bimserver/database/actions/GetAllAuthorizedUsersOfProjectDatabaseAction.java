package org.bimserver.database.actions;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.store.User;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.shared.UserException;
import org.eclipse.emf.common.util.EList;

public class GetAllAuthorizedUsersOfProjectDatabaseAction extends BimDatabaseAction<Set<User>>{

	private final long poid;

	public GetAllAuthorizedUsersOfProjectDatabaseAction(AccessMethod accessMethod, long poid) {
		super(accessMethod);
		this.poid = poid;
	}
	
	@Override
	public Set<User> execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		EList<User> users = bimDatabaseSession.getProjectByPoid(poid).getHasAuthorizedUsers();
		return new HashSet<User>(users);
	}
}