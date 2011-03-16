package org.bimserver.database.actions;

import org.bimserver.SettingsManager;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.ObjectIdentifier;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.SDataObject;
import org.bimserver.shared.UserException;

public class GetDataObjectByGuidDatabaseAction extends BimDatabaseAction<SDataObject>{

	private final String guid;
	private final long roid;
	private final SettingsManager settingsManager;

	public GetDataObjectByGuidDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, SettingsManager settingsManager, long roid, String guid) {
		super(bimDatabaseSession, accessMethod);
		this.settingsManager = settingsManager;
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
		
		return new GetDataObjectByOidDatabaseAction(getDatabaseSession(), getAccessMethod(), settingsManager, roid, objectIdentifier.getOid(), objectIdentifier.getCid()).execute();
	}
}