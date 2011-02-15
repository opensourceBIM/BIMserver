package org.bimserver.database.actions;

import java.util.Map;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.HasReferenceToCondition;
import org.bimserver.database.query.conditions.Not;
import org.bimserver.database.store.StorePackage;
import org.bimserver.database.store.User;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.shared.UserException;
import org.bimserver.utils.CollectionUtils;

public class GetAllNonAuthorizedUsersOfProjectDatabaseAction extends BimDatabaseAction<Set<User>>{

	private final long poid;

	public GetAllNonAuthorizedUsersOfProjectDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long poid) {
		super(bimDatabaseSession, accessMethod);
		this.poid = poid;
	}
	
	@Override
	public Set<User> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Condition condition = new Not(new HasReferenceToCondition(StorePackage.eINSTANCE.getUser_HasRightsOn(), getProjectByPoid(poid)));
		return CollectionUtils.mapToSet((Map<Long, User>) getDatabaseSession().query(condition, User.class, false));
	}
}