package org.bimserver.database.actions;

import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ExtendedDataSchema;
import org.bimserver.models.store.StorePackage;

public class GetExtendedDataSchemaByNamespaceDatabaseAction extends AbstractGetByFieldDatabaseAction<ExtendedDataSchema> {

	public GetExtendedDataSchemaByNamespaceDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, String namespace) {
		super(databaseSession, accessMethod, ExtendedDataSchema.class, StorePackage.eINSTANCE.getExtendedDataSchema_Namespace(), namespace);
	}
}