package org.bimserver.database.actions;

import java.util.Map;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.Database;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.HasReferenceToCondition;
import org.bimserver.database.store.Checkout;
import org.bimserver.database.store.StorePackage;
import org.bimserver.database.store.User;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.shared.UserException;
import org.bimserver.utils.CollectionUtils;

public class GetAllCheckoutsByUserDatabaseAction extends BimDatabaseAction<Set<Checkout>> {

	private final long uoid;

	public GetAllCheckoutsByUserDatabaseAction(AccessMethod accessMethod, long uoid) {
		super(accessMethod);
		this.uoid = uoid;
	}

	@Override
	public Set<Checkout> execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		User user = bimDatabaseSession.getUserByUoid(uoid);
		Condition condition = new HasReferenceToCondition(StorePackage.eINSTANCE.getCheckout_User(), user);
//		condition = condition.and(new AttributeCondition(StorePackage.eINSTANCE.getCheckout_Active(), new BooleanLiteral(true)));
		Map<Long, Checkout> query = (Map<Long, Checkout>) bimDatabaseSession.query(Database.STORE_PROJECT_ID, -1, condition, Checkout.class);
		return CollectionUtils.mapToSet(query);
	}
}