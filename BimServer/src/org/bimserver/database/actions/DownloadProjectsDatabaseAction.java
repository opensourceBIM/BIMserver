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
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.merging.Merger;
import org.bimserver.rights.RightsManager;
import org.bimserver.settings.ServerSettings;
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
		Project project = null;
		String projectName = "";
		IfcModelSet ifcModelSet = new IfcModelSet();
		for (long roid : roids) {
			Revision revision = bimDatabaseSession.getVirtualRevision(roid);
			project = revision.getProject();
			if (RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
				for (ConcreteRevision concreteRevision : revision.getConcreteRevisions()) {
					ReadSet readSet = bimDatabaseSession.getMap(concreteRevision.getProject().getId(), concreteRevision.getId());
					projectName += concreteRevision.getProject().getName() + "-";
					IfcModel subModel = new IfcModel(readSet.getMap());
					subModel.setDate(concreteRevision.getDate());
					ifcModelSet.add(subModel);
				}
			} else {
				throw new UserException("User has no rights on project " + project.getOid());
			}
		}
		IfcModel ifcModel = new Merger().merge(project, ifcModelSet, ServerSettings.getSettings().isIntelligentMerging());
		if (projectName.endsWith("-")) {
			projectName = projectName.substring(0, projectName.length()-1);
		}
		return ifcModel;
	}
}