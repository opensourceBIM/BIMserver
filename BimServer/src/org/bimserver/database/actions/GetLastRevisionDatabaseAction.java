package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.UserException;

public class GetLastRevisionDatabaseAction extends BimDatabaseAction<Revision> {

	private final int pid;

	public GetLastRevisionDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, int pid) {
		super(bimDatabaseSession, accessMethod);
		this.pid = pid;
	}

	@Override
	public Revision execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Project project = getProjectById(pid);
		if (project != null) {
			return project.getLastRevision();
		} else {
			throw new UserException("There is no project with id " + pid);
		}
	}
}