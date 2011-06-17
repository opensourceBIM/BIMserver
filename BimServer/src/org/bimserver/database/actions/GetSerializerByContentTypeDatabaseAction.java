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

public class GetSerializerByContentTypeDatabaseAction extends BimDatabaseAction<Serializer> {

	private final String contentType;

	public GetSerializerByContentTypeDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, String contentType) {
		super(bimDatabaseSession, accessMethod);
		this.contentType = contentType;
	}

	@Override
	public Serializer execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getSerializer_ContentType(), new StringLiteral(contentType));
		return getDatabaseSession().querySingle(condition, Serializer.class, false);
	}
}