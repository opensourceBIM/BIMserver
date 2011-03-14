package org.bimserver.database.actions;

import java.util.Map;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.HasReferenceToCondition;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.UserException;
import org.bimserver.utils.CollectionUtils;

public class GetAllCheckoutsOfRevisionDatabaseAction extends BimDatabaseAction<Set<Checkout>> {

	private final long roid;

	public GetAllCheckoutsOfRevisionDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long roid) {
		super(bimDatabaseSession, accessMethod);
		this.roid = roid;
	}

	@Override
	public Set<Checkout> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Revision revision = getVirtualRevision(roid);
		Condition condition = new HasReferenceToCondition(StorePackage.eINSTANCE.getCheckout_Revision(), revision);
		return CollectionUtils.mapToSet((Map<Long, Checkout>) getDatabaseSession().query(condition, Checkout.class, false));
	}
}