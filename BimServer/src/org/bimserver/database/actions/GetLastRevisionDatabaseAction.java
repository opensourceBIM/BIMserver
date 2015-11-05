package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.exceptions.UserException;

public class GetLastRevisionDatabaseAction extends BimDatabaseAction<Revision> {

	private final int pid;

	public GetLastRevisionDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, int pid) {
		super(databaseSession, accessMethod);
		this.pid = pid;
	}

	@Override
	public Revision execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Project project = getProjectById(pid);
		if (project != null) {
			return project.getLastRevision();
		} else {
			throw new UserException("There is no project with id " + pid);
		}
	}
}