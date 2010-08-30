package org.bimserver.database.actions;

import java.util.Date;
import java.util.Set;

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

public class DownloadByOidsDatabaseAction extends BimDatabaseAction<IfcModel> {

	private final long actingUoid;
	private final Set<Long> oids;
	private final Set<Long> roids;

	public DownloadByOidsDatabaseAction(AccessMethod accessMethod, Set<Long> roids, Set<Long> oids, long actingUoid) {
		super(accessMethod);
		this.roids = roids;
		this.oids = oids;
		this.actingUoid = actingUoid;
	}

	@Override
	public IfcModel execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		User user = bimDatabaseSession.getUserByUoid(actingUoid);
		IfcModel ifcModel = new IfcModel();
		for (Long roid : roids) {
			Revision virtualRevision = bimDatabaseSession.getVirtualRevision(roid);
			Project project = virtualRevision.getProject();
			if (!RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
				throw new UserException("User has insufficient rights to download revisions from this project");
			}
			for (ConcreteRevision concreteRevision : virtualRevision.getConcreteRevisions()) {
				for (Long oid : oids) {
					ReadSet mapWithOid = bimDatabaseSession.getMapWithOid(concreteRevision.getProject().getId(), concreteRevision.getId(), oid);
					merge(concreteRevision.getProject(), ifcModel, new IfcModel(mapWithOid.getMap()));
					ifcModel.setMainObject(mapWithOid.get(oid));
				}
			}
		}
		ifcModel.setRevisionNr(1);
		ifcModel.setAuthorizedUser(bimDatabaseSession.getUserByUoid(actingUoid).getName());
		ifcModel.setDate(new Date());
		return ifcModel;
	}
}