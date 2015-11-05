package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ExtendedData;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class GetExtendedDataByIdDatabaseAction extends GetByIdDatabaseAction<ExtendedData> {

	private Authorization authorization;

	public GetExtendedDataByIdDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization, long oid) {
		super(databaseSession, accessMethod, oid, StorePackage.eINSTANCE.getExtendedData());
		this.authorization = authorization;
	}
	
	@Override
	public ExtendedData execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		ExtendedData extendedData = super.execute();
		if (authorization == null) {
			throw new UserException("Authorization required for this call");
		}
		if (extendedData.getRevision() != null) {
			Revision revision = extendedData.getRevision();
			authorization.canReadExtendedData(revision.getOid());
		} else if (extendedData.getProject() != null) {
//			Project project = extendedData.getProject();
			// TODO check auth
		}
		return extendedData;
	}
}