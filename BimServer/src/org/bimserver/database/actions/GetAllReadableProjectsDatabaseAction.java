package org.bimserver.database.actions;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.Database;
import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class GetAllReadableProjectsDatabaseAction extends BimDatabaseAction<Set<Project>> {

	private final long actingUoid;

	public GetAllReadableProjectsDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long actingUoid) {
		super(bimDatabaseSession, accessMethod);
		this.actingUoid = actingUoid;
	}

	@Override
	public Set<Project> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User user = getUserByUoid(actingUoid);
		IfcModel projectsModel = getDatabaseSession().getAllOfType(StorePackage.eINSTANCE.getProject(), Database.STORE_PROJECT_ID, Database.STORE_PROJECT_REVISION_ID, false);
		Set<Project> result = new HashSet<Project>();
		for (IdEObject idEObject : projectsModel.getValues()) {
			if (idEObject instanceof Project) {
				Project project = (Project)idEObject;
				if ((user.getUserType() == UserType.ADMIN || (project.getState() == ObjectState.ACTIVE) && RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project))) {
					result.add(project);
				}
			}
		}
		return result;
	}
}