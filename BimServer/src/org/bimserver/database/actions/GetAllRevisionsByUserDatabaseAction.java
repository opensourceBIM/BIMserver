package org.bimserver.database.actions;

import java.util.Map;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.HasReferenceToCondition;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.StorePackage;
import org.bimserver.database.store.User;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.shared.UserException;
import org.bimserver.utils.CollectionUtils;

public class GetAllRevisionsByUserDatabaseAction extends BimDatabaseAction<Set<Revision>>{

	private final long uoid;

	public GetAllRevisionsByUserDatabaseAction(AccessMethod accessMethod, long uoid) {
		super(accessMethod);
		this.uoid = uoid;
	}

	@Override
	public Set<Revision> execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		User user = bimDatabaseSession.getUserByUoid(uoid);
		Condition condition = new HasReferenceToCondition(StorePackage.eINSTANCE.getRevision_User(), user);
		return CollectionUtils.mapToSet((Map<Long, Revision>) bimDatabaseSession.query(condition, Revision.class));
	}
}