package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Serializer;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.UserException;

public class GetSerializerByNameDatabaseAction extends BimDatabaseAction<Serializer> {

	private final String name;

	public GetSerializerByNameDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, String name) {
		super(bimDatabaseSession, accessMethod);
		this.name = name;
	}

	@Override
	public Serializer execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getSerializer_Name(), new StringLiteral(name));
		return getDatabaseSession().querySingle(condition, Serializer.class, false);
	}
}