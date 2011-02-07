package org.bimserver.database.actions;

import java.util.Map;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.HasReferenceToCondition;
import org.bimserver.database.store.Checkout;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.StorePackage;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.shared.UserException;
import org.bimserver.utils.CollectionUtils;

public class GetAllCheckoutsOfRevisionDatabaseAction extends BimDatabaseAction<Set<Checkout>> {

	private final long roid;

	public GetAllCheckoutsOfRevisionDatabaseAction(AccessMethod accessMethod, long roid) {
		super(accessMethod);
		this.roid = roid;
	}

	@Override
	public Set<Checkout> execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		Revision revision = bimDatabaseSession.getVirtualRevision(roid);
		Condition condition = new HasReferenceToCondition(StorePackage.eINSTANCE.getCheckout_Revision(), revision);
		return CollectionUtils.mapToSet((Map<Long, Checkout>) bimDatabaseSession.query(condition, Checkout.class));
	}
}