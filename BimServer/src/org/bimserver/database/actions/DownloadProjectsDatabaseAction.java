package org.bimserver.database.actions;

import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.merging.Merger;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class DownloadProjectsDatabaseAction extends BimDatabaseAction<IfcModel> {

	private final long actingUoid;
	private final Set<Long> roids;

	public DownloadProjectsDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, Set<Long> roids, long actingUoid) {
		super(bimDatabaseSession, accessMethod);
		this.roids = roids;
		this.actingUoid = actingUoid;
	}

	@Override
	public IfcModel execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User user = getUserByUoid(actingUoid);
		Project project = null;
		String projectName = "";
		IfcModelSet ifcModelSet = new IfcModelSet();
		for (long roid : roids) {
			Revision revision = getVirtualRevision(roid);
			project = revision.getProject();
			if (RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
				for (ConcreteRevision concreteRevision : revision.getConcreteRevisions()) {
					IfcModel subModel = new IfcModel();
					getDatabaseSession().getMap(subModel, concreteRevision.getProject().getId(), concreteRevision.getId(), true);
					projectName += concreteRevision.getProject().getName() + "-";
					subModel.setDate(concreteRevision.getDate());
					ifcModelSet.add(subModel);
				}
			} else {
				throw new UserException("User has no rights on project " + project.getOid());
			}
		}
		IfcModel ifcModel = new Merger().merge(project, ifcModelSet, getSettings().isIntelligentMerging());
		if (projectName.endsWith("-")) {
			projectName = projectName.substring(0, projectName.length()-1);
		}
		return ifcModel;
	}
}