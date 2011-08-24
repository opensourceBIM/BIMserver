package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Deserializer;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.UserException;

public class GetDeserializerByNameDatabaseAction extends BimDatabaseAction<Deserializer> {

	private final String name;

	public GetDeserializerByNameDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, String name) {
		super(bimDatabaseSession, accessMethod);
		this.name = name;
	}

	@Override
	public Deserializer execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getDeserializer_Name(), new StringLiteral(name));
		return getDatabaseSession().querySingle(condition, Deserializer.class, false);
	}
}