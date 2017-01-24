package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Project;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class GetSubProjectByNameDatabaseAction extends BimDatabaseAction<Project> {

	private final String name;
	private Long parentProjectId;

	public GetSubProjectByNameDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Long parentProjectId, String name, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.parentProjectId = parentProjectId;
		this.name = name;
	}

	@Override
	public Project execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Project parent = getProjectByPoid(parentProjectId);
		for (Project project : parent.getSubProjects()) {
			if (project.getName().equals(name)) {
				return project;
			}
		}
		return null;
	}
}