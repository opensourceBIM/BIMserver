package org.bimserver.database.actions;

import java.util.Map;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.query.conditions.AndCondition;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.HasReferenceToCondition;
import org.bimserver.database.query.conditions.Not;
import org.bimserver.database.query.literals.EnumLiteral;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
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
		Condition condition = 
			new AndCondition(
				new AndCondition(
						new Not(new HasReferenceToCondition(StorePackage.eINSTANCE.getUser_HasRightsOn(), getProjectByPoid(poid))), 
						new AttributeCondition(StorePackage.eINSTANCE.getUser_State(), new EnumLiteral(ObjectState.ACTIVE))), 
				new Not(new AttributeCondition(StorePackage.eINSTANCE.getUser_UserType(), new EnumLiteral(UserType.SYSTEM))));
		return CollectionUtils.mapToSet((Map<Long, User>) getDatabaseSession().query(condition, User.class, false));
	}
}