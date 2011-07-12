package org.bimserver.database.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class GetProjectsByNameDatabaseAction extends BimDatabaseAction<List<Project>> {

	private final long actionUoid;
	private final String name;

	public GetProjectsByNameDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, String name, long actionUoid) {
		super(bimDatabaseSession, accessMethod);
		this.name = name;
		this.actionUoid = actionUoid;
	}

	@Override
	public List<Project> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Set<Project> projects = getProjectsByName(name);
		List<Project> result = new ArrayList<Project>();
		User user = getUserByUoid(actionUoid);
		for (Project project : projects) {
			if ((project.getState() == ObjectState.ACTIVE && RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project))) {
				result.add(project);
			}
		}
		return result;
	}
}