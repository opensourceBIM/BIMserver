package org.bimserver.database.actions;

import java.util.Map;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.Database;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.IsOfTypeCondition;
import org.bimserver.database.query.literals.EnumLiteral;
import org.bimserver.database.store.ObjectState;
import org.bimserver.database.store.StorePackage;
import org.bimserver.database.store.User;
import org.bimserver.database.store.UserType;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.shared.UserException;
import org.bimserver.utils.CollectionUtils;

public class GetAllUsersDatabaseAction extends BimDatabaseAction<Set<User>> {

	private final long actingUoid;

	public GetAllUsersDatabaseAction(AccessMethod accessMethod, long actingUoid) {
		super(accessMethod);
		this.actingUoid = actingUoid;
	}

	@Override
	public Set<User> execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		Condition condition = new IsOfTypeCondition(StorePackage.eINSTANCE.getUser());
		User actingUser = bimDatabaseSession.getUserByUoid(actingUoid);
		if (actingUser.getUserType() != UserType.ADMIN) {
			condition.and(new AttributeCondition(StorePackage.eINSTANCE.getUser_State(), new EnumLiteral(ObjectState.ACTIVE)));
		}
		return CollectionUtils.mapToSet((Map<Long, User>) bimDatabaseSession.query(Database.STORE_PROJECT_ID, -1, condition, User.class));
	}
}