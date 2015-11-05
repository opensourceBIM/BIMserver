package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ExtendedDataSchema;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.UserException;

public class AddExtendedDataSchemaDatabaseAction extends AddDatabaseAction<ExtendedDataSchema> {

	public AddExtendedDataSchemaDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, ExtendedDataSchema extendedDataSchema) {
		super(databaseSession, accessMethod, extendedDataSchema);
	}
	
	@Override
	public Long execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		if (getIdEObject().getName() == null || getIdEObject().getName().trim().equals("")) {
			throw new UserException("Name cannot be empty");
		}
		if (getIdEObject().getNamespace() == null || getIdEObject().getNamespace().trim().equals("")) {
			throw new UserException("Namespace cannot be empty");
		}
		if (getDatabaseSession().querySingle(new AttributeCondition(StorePackage.eINSTANCE.getExtendedDataSchema_Name(), new StringLiteral(getIdEObject().getName())), ExtendedDataSchema.class, Query.getDefault()) != null) {
			throw new UserException("ExtendedDataSchema name must be unique");
		}
		if (getDatabaseSession().querySingle(new AttributeCondition(StorePackage.eINSTANCE.getExtendedDataSchema_Namespace(), new StringLiteral(getIdEObject().getNamespace())), ExtendedDataSchema.class, Query.getDefault()) != null) {
			throw new UserException("ExtendedDataSchema namespace must be unique");
		}
		return super.execute();
	}
}