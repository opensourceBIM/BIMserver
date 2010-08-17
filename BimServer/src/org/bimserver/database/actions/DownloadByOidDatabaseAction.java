package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.ReadSet;
import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.User;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.ifc.IfcModel;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class DownloadByOidDatabaseAction extends BimDatabaseAction<IfcModel> {

	private final long oid;
	private final long actingUoid;
	private final long roid;

	public DownloadByOidDatabaseAction(AccessMethod accessMethod, long roid, long oid, long actingUoid) {
		super(accessMethod);
		this.roid = roid;
		this.oid = oid;
		this.actingUoid = actingUoid;
	}

	@Override
	public IfcModel execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		Revision virtualRevision = bimDatabaseSession.getVirtualRevision(roid);
		Project project = virtualRevision.getProject();
		User user = bimDatabaseSession.getUserByUoid(actingUoid);
		if (!RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
			throw new UserException("User has insufficient rights to download revisions from this project");
		}
		IfcModel ifcModel = new IfcModel((int)virtualRevision.getSize());
		for (ConcreteRevision concreteRevision : virtualRevision.getConcreteRevisions()) {
			ReadSet mapWithOid = bimDatabaseSession.getMapWithOid(concreteRevision.getProject().getId(), concreteRevision.getId(), oid);
			merge(concreteRevision.getProject(), ifcModel, new IfcModel(mapWithOid.getMap()));
			ifcModel.setMainObject(mapWithOid.get(oid));
		}
		ifcModel.setRevisionNr(project.getRevisions().indexOf(virtualRevision) + 1);
		ifcModel.setAuthorizedUser(bimDatabaseSession.getUserByUoid(actingUoid).getName());
		ifcModel.setDate(virtualRevision.getDate());
		return ifcModel;
	}
}