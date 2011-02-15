package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.ObjectIdentifier;
import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.shared.SDataObject;
import org.bimserver.shared.UserException;

public class GetDataObjectByGuidDatabaseAction extends BimDatabaseAction<SDataObject>{

	private final String guid;
	private final long roid;

	public GetDataObjectByGuidDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long roid, String guid) {
		super(bimDatabaseSession, accessMethod);
		this.roid = roid;
		this.guid = guid;
	}
	
	@Override
	public SDataObject execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Revision virtualRevision = getVirtualRevision(roid);
		ObjectIdentifier objectIdentifier = null;
		for (ConcreteRevision concreteRevision : virtualRevision.getConcreteRevisions()) {
			objectIdentifier = getDatabaseSession().getOidOfGuid(guid, concreteRevision.getProject().getId(), concreteRevision.getId());
			if (objectIdentifier != null) {
				long oidOfGuid = objectIdentifier.getOid();
				if (oidOfGuid != -1) {
					break;
				}
			}
		}
		if (objectIdentifier == null) {
			throw new UserException("Guid " + guid + " not found in this revision/project");
		}
		
		return new GetDataObjectByOidDatabaseAction(getDatabaseSession(), getAccessMethod(), roid, objectIdentifier.getOid(), objectIdentifier.getCid()).execute();
	}
}