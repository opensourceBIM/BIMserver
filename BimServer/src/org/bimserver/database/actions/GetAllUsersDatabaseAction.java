package org.bimserver.database.actions;

import java.util.Map;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.IsOfTypeCondition;
import org.bimserver.database.query.conditions.Not;
import org.bimserver.database.query.literals.EnumLiteral;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.UserException;
import org.bimserver.utils.CollectionUtils;

public class GetAllUsersDatabaseAction extends BimDatabaseAction<Set<User>> {

	private final long actingUoid;

	public GetAllUsersDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long actingUoid) {
		super(bimDatabaseSession, accessMethod);
		this.actingUoid = actingUoid;
	}

	@Override
	public Set<User> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User actingUser = getUserByUoid(actingUoid);
		if (actingUser.getUserType() == UserType.ANONYMOUS) {
			throw new UserException("Anonymous users are not allowed to list all users");
		}
		Condition condition = new IsOfTypeCondition(StorePackage.eINSTANCE.getUser());
		condition = condition.and(new Not(new AttributeCondition(StorePackage.eINSTANCE.getUser_UserType(), new EnumLiteral(UserType.SYSTEM))));
		if (actingUser.getUserType() != UserType.ADMIN) {
			condition = condition.and(new AttributeCondition(StorePackage.eINSTANCE.getUser_State(), new EnumLiteral(ObjectState.ACTIVE)));
		}
		return CollectionUtils.mapToSet((Map<Long, User>) getDatabaseSession().query(condition, User.class, false));
	}
}