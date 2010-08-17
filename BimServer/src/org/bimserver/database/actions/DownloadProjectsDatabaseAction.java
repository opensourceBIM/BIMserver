package org.bimserver.database.actions;

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

public class DownloadProjectsDatabaseAction extends BimDatabaseAction<IfcModel> {

	private final long actingUoid;
	private final Set<Long> roids;

	public DownloadProjectsDatabaseAction(AccessMethod accessMethod, Set<Long> roids, long actingUoid) {
		super(accessMethod);
		this.roids = roids;
		this.actingUoid = actingUoid;
	}

	@Override
	public IfcModel execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		User user = bimDatabaseSession.getUserByUoid(actingUoid);
		IfcModel ifcModel = new IfcModel();
		String projectName = "";
		for (long roid : roids) {
			Revision revision = bimDatabaseSession.getVirtualRevision(roid);
			Project project = revision.getProject();
			if (RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
				for (ConcreteRevision concreteRevision : revision.getConcreteRevisions()) {
					ReadSet readSet = bimDatabaseSession.getMap(concreteRevision.getProject().getId(), concreteRevision.getId());
					projectName += concreteRevision.getProject().getName() + "-";
					merge(concreteRevision.getProject(), ifcModel, new IfcModel(readSet.getMap()));
				}
			} else {
				throw new UserException("User has no rights on project " + project.getOid());
			}
		}
		if (projectName.endsWith("-")) {
			projectName = projectName.substring(0, projectName.length()-1);
		}
		return ifcModel;
	}
}