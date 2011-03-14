package org.bimserver.database.actions;

import java.util.Map;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.HasReferenceToCondition;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.UserException;
import org.bimserver.utils.CollectionUtils;

public class GetAllRevisionsByUserDatabaseAction extends BimDatabaseAction<Set<Revision>>{

	private final long uoid;

	public GetAllRevisionsByUserDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long uoid) {
		super(bimDatabaseSession, accessMethod);
		this.uoid = uoid;
	}

	@Override
	public Set<Revision> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User user = getUserByUoid(uoid);
		Condition condition = new HasReferenceToCondition(StorePackage.eINSTANCE.getRevision_User(), user);
		return CollectionUtils.mapToSet((Map<Long, Revision>) getDatabaseSession().query(condition, Revision.class, false));
	}
}