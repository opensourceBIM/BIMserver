package org.bimserver.database.actions;

import java.util.List;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class GetTopLevelProjectByNameDatabaseAction extends BimDatabaseAction<Project> {

	private final String name;
	private Authorization authorization;

	public GetTopLevelProjectByNameDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, String name, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.name = name;
		this.authorization = authorization;
	}

	@Override
	public Project execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		List<Project> projects = getProjectsByName(name);
		for (Project project : projects) {
			if (project.getParent() == null) {
				User user = getUserByUoid(authorization.getUoid());
				if ((project.getState() == ObjectState.ACTIVE && authorization.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project))) {
					return project;
				}
			}
		}
		return null;
	}
}