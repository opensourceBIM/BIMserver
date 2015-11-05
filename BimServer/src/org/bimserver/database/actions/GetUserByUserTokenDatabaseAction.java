package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;

public class GetUserByUserTokenDatabaseAction extends BimDatabaseAction<User> {

	private String userToken;

	public GetUserByUserTokenDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, String userToken) {
		super(databaseSession, accessMethod);
		this.userToken = userToken;
	}

	@Override
	public User execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getUser_Token(), new StringLiteral(userToken));
		return getDatabaseSession().querySingle(condition, User.class, Query.getDefault());
	}
}