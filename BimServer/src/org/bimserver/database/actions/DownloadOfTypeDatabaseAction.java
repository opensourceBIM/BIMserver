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

public class DownloadOfTypeDatabaseAction extends BimDatabaseAction<IfcModel> {

	private final String className;
	private final long actingUoid;
	private final long roid;

	public DownloadOfTypeDatabaseAction(AccessMethod accessMethod, long roid, String className, long actingUoid) {
		super(accessMethod);
		this.roid = roid;
		this.actingUoid = actingUoid;
		this.className = className;
	}

	@Override
	public IfcModel execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		Revision virtualRevision = bimDatabaseSession.getVirtualRevision(roid);
		Project project = virtualRevision.getProject();
		User user = bimDatabaseSession.getUserByUoid(actingUoid);
		if (!RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
			throw new UserException("User has insufficient rights to download revisions from this project");
		}
		IfcModel IfcModel = new IfcModel((int)virtualRevision.getSize());
		for (ConcreteRevision concreteRevision : virtualRevision.getConcreteRevisions()) {
			ReadSet allOfType = bimDatabaseSession.getAllOfType(className, concreteRevision.getProject().getId(), concreteRevision.getId());
			merge(concreteRevision.getProject(), IfcModel, new IfcModel(allOfType.getMap()));
		}
		IfcModel.setRevisionNr(project.getRevisions().indexOf(virtualRevision) + 1);
		IfcModel.setAuthorizedUser(bimDatabaseSession.getUserByUoid(actingUoid).getName());
		IfcModel.setDate(virtualRevision.getDate());
		return IfcModel;
	}
}