package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class GetRevisionDatabaseAction extends BimDatabaseAction<Revision> {

	private final long roid;
	private Authorization authorization;

	public GetRevisionDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long roid, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.roid = roid;
		this.authorization = authorization;
	}

	@Override
	public Revision execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Revision revision = getRevisionByRoid(roid);
		if (revision == null) {
			throw new UserException("Revision does not exist");
		}
		Project project = revision.getProject();
		User user = getUserByUoid(authorization.getUoid());
		if (authorization.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
			return revision;
		}
		throw new UserException("User has no rights on this revision's project (" + project.getName() + ")");
	}
}